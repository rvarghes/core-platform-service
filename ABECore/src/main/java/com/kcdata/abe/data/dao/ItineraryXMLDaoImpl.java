/*
 * ItineraryXMLDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.SendFailedException;

import org.springframework.util.StringUtils;
import org.zefer.pd4ml.PD4ML;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.PrintItinerary;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.Vendor;
import com.kcdata.abe.data.util.EmailUtils;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.data.util.XMLConvertUtils;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.DateUtils;
import com.thoughtworks.xstream.XStream;

public class ItineraryXMLDaoImpl extends ABEDaoBase implements ItineraryXMLDao {

	ABELogger abeLogger = ABELogger.getLogger(ItineraryXMLDaoImpl.class);
	private static final String XML_MARSHAL_EXCEPTION = "XML_MARSHAL_EXCEPTION";
	private static final String XSLT_TRANSFORMATION_EXCEPTION = "XSLT_TRANSFORMATION_EXCEPTION";
	private static final String DEPARTING = "Departing";
	private static final String RETURN = "Return";
	private Properties emailProps;

	/**
	 * 
	 * Method to send email to recipient emailId, in the emailFormat
	 * [Customer,Agent]
	 * 
	 * @param itinerary
	 * @param emailType
	 * @param emailId
	 * @return
	 * 
	 * @seeis
	 * @since
	 */
	public ItineraryResponse emailItinerary(PrintItinerary itinerary,
			String emailType, String emailId, EmailAndPrintMessage messages,
			String fromEmailId) {
		ItineraryResponse emailResponse = new ItineraryResponse();
		String emailBody = "";// html format
		String emailSubject = "";
		try {
			// apply no of nights for hotels
			processNoOfNightsHotels(itinerary);
			// Modify deposit due for customer format
			modifyDepositDue(itinerary, emailType);
			// set commission amount in case agent quote
			if (emailType.equalsIgnoreCase("AGENTFORMATQUOTE")) {
				calculateCommissionAmount(itinerary);
			}
			// Set RFA email and Fax
			if (emailType.equalsIgnoreCase("HOTEL_ALLOTMENT_VENDOR_REQUEST")) {
				String rfaFromEmailAddress = emailProps
						.getProperty("rfaemail.from.address");
				String rfaFromFaxNumber = emailProps
						.getProperty("rfaemail.from.faxnumber");
				itinerary.setRfaFromEmailAddress(rfaFromEmailAddress);
				itinerary.setRfaFromFaxNumber(rfaFromFaxNumber);
			}
			// marshal itinerary object to xml string
			setSeatAllocationsAsServices(itinerary);
			String itineraryXML = marshal(itinerary);
			String fileExtension = ".pdf";
			// XSLT-HTML transformation
			emailBody = xmlConverter.transformXML(emailType, itineraryXML,
					messages, "email");
			String fileName = null;
			String requestType = "";

			if (null != itinerary.getQuoteNo()) {
				fileName = itinerary.getQuoteNo();
				requestType = "Quote";
			} else {
				fileName = itinerary.getBookingNo();
				requestType = "Booking";
			}

			// Set image path
			String attachment = fileName + fileExtension;
			// Meta tage for content type to be remove from generated html
			String metaContent = "<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
			// Create PDF from HTML
			PD4ML pd4ml = new PD4ML();
			pd4ml.clearCache();
			pd4ml.adjustHtmlWidth();
			emailBody = emailBody.replaceAll("&amp;", "&");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			InputStream in = new ByteArrayInputStream(emailBody.replaceAll(
					metaContent, "").getBytes());
			InputStreamReader inputStreamReader = new InputStreamReader(in);
			pd4ml.render(inputStreamReader, bos);
			inputStreamReader.close();
			bos.close();
			// Sending Mail
			emailSubject = getEmailSubject(emailType, itineraryXML);
			String[] cc = null;
			if (emailType.equalsIgnoreCase("HOTEL_ALLOTMENT_VENDOR_REQUEST")) {
				cc = new String[1];
				cc[0] = emailProps.getProperty("rfaemail.cc.address");
				// cc[1]="rpalamar@applevac.com";
				fromEmailId = emailProps.getProperty("rfaemail.from.address");
				Vendor vendor = itinerary.getHotels().get(0).getVendor();
				// if((null !=
				// vendor.getMode())&&(vendor.getMode().equalsIgnoreCase("Phone")||vendor.getMode().equalsIgnoreCase("Fax"))){
				if (null == emailId || emailId.trim().length() == 0)
					emailId = emailProps
							.getProperty("rfaemail.phonemode.to.address");
				// }
				RoomCategory roomCategory = itinerary.getHotels().get(0)
						.getDisplayRoomCategory();
				String hotelName = itinerary.getHotels().get(0).getHotelName();
				String roomCategoryName = roomCategory.getRoomTypeCode();
				String departureDate = DateUtils.reformatDate(itinerary
						.getSearchCriteria().getDepartureDate().toString(),
						"E MMM dd HH:mm:ss Z yyyy", "MM/dd/yyyy");
				String agentfullName = itinerary.getImApplicationInfo()
						.getSelectedAgent().getFullName();
				String customerNumber = itinerary.getImApplicationInfo()
						.getRequestorID();
				String bookingAgentName = itinerary.getImApplicationInfo()
						.getContextID();
				emailSubject = "Hotel request, " + hotelName + ", "
						+ roomCategoryName + ", " + departureDate + ","
						+ bookingAgentName + "/" + agentfullName + ", "
						+ customerNumber;
				requestType = "RFA";

			}

			// emailProcessor.sendMessageWithAttachment(emailId, emailBody,
			// emailSubject, fromEmailId, attachment, fileName,
			// fileExtension, cc);
			emailProcessor.sendMessageWithAttachmentStream(emailId, emailBody,
					emailSubject, fromEmailId, bos, fileName, fileExtension,
					cc, requestType);

		} catch (SendFailedException e) {
			e.printStackTrace();

			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_EMAIL_ADDRESS");
			businessError.setErrorDescription(e.getMessage());
			emailResponse.saveBusinessError(businessError);
			return emailResponse;

		}

		catch (Exception e) {
			e.printStackTrace();

			String debugMessage = "";
			if (XML_MARSHAL_EXCEPTION.equalsIgnoreCase(e.getMessage())) {
				debugMessage = "Email Itinerary ERROR: Error converting Itinerary object to XML";
			} else if (XSLT_TRANSFORMATION_EXCEPTION.equalsIgnoreCase(e
					.getMessage())) {
				debugMessage = "Email Itinerary ERROR: Error Transforming XSLT-HTML";
			} else {
				debugMessage = "Email Itinerary ERROR: Error Emailing Itinerary";
			}
			// this.processWarningErrors(e, emailResponse, debugMessage);
			abeLogger.trace(debugMessage, e);
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("UNABLE TO SEND EMAIL");
			businessError.setErrorDescription(e.getMessage());
			emailResponse.saveBusinessError(businessError);
			return emailResponse;
		}
		// emailResponse.setItinerary(itinerary);
		return emailResponse;
	}

	public ItineraryResponse printItinerary(PrintItinerary itinerary,
			String printType, EmailAndPrintMessage messages) {
		ItineraryResponse printResponse = new ItineraryResponse();
		String printContent = "";// html format

		try {
			// apply no of nights for hotels
			processNoOfNightsHotels(itinerary);
			// Modify deposit due for customer format
			modifyDepositDue(itinerary, printType);
			// set commission amount in case agent quote
			if (printType.equalsIgnoreCase("AGENTFORMATQUOTE")) {
				calculateCommissionAmount(itinerary);
			}
			// marshal itinerary object to xml string
			setSeatAllocationsAsServices(itinerary);
			String itineraryXML = marshal(itinerary);
			// XSLT-HTML transformation
			printContent = xmlConverter.transformXML(printType, itineraryXML,
					messages, "print");
		} catch (Exception e) {
			e.printStackTrace();
			String debugMessage = "";
			if (XML_MARSHAL_EXCEPTION.equalsIgnoreCase(e.getMessage())) {
				debugMessage = "Print Itinerary ERROR: Error converting Itinerary object to XML";
			}
			if (XSLT_TRANSFORMATION_EXCEPTION.equalsIgnoreCase(e.getMessage())) {
				debugMessage = "Print Itinerary ERROR: Error Transforming XSLT-HTML";
			} else {
				debugMessage = "Print Itinerary ERROR: Error Printing Itinerary";
			}
			this.processWarningErrors(e, printResponse, debugMessage);
			return printResponse;
		}
		// printResponse.setItinerary(itinerary);
		printResponse.setHtmlItinerary(printContent);
		return printResponse;
	}

	private void setSeatAllocationsAsServices(PrintItinerary itinerary) {
		List<Service> services = itinerary.getServices();
		if (services == null) {
			services = new java.util.ArrayList<Service>();
		}
		Iterator<Service> serviceIterator = services.iterator();

		Service service = null;

		while (serviceIterator.hasNext()) {
			service = serviceIterator.next();
			if (StringUtils.hasText(service.getServiceCode())
					&& service.getServiceCode().contains(
							ABEConstants.SEAT_MATERIAL_CODE)) {
				serviceIterator.remove();
			}
		}

		if (itinerary.getSeatAllocations() != null
				&& itinerary.getSeatAllocations().size() > 0) {
			// Blank list handled for seat
			Collections.sort(itinerary.getSeatAllocations(), new Comparator() {
				public int compare(Object o1, Object o2) {
					SeatAllocations p1 = (SeatAllocations) o1;
					SeatAllocations p2 = (SeatAllocations) o2;
					return p1.getPaxNo().compareToIgnoreCase(p2.getPaxNo());
				}
			});
			StringBuilder sb = null;
			for (SeatAllocations seatAllocations : itinerary
					.getSeatAllocations()) {
				service = new Service();
				// seatAllocations.setSelectedDate("20120810");
				service.setGuestAllocation(seatAllocations.getPaxNo());
				sb = new StringBuilder();
				if (StringUtils.hasText(seatAllocations.getSeatType())) {
					if ("PPP".equalsIgnoreCase(seatAllocations.getSeatType())
							|| ABEConstants.PPP
									.equalsIgnoreCase(seatAllocations
											.getSeatType())) {
						sb.append(ABEConstants.PPP);
					} else if ("PRM".equalsIgnoreCase(seatAllocations
							.getSeatType())
							|| ABEConstants.PRM
									.equalsIgnoreCase(seatAllocations
											.getSeatType())) {
						sb.append(ABEConstants.PRM);
					} else {
						sb.append(seatAllocations.getSeatType());
					}
					sb.append(ABEConstants.BLANK_SPACE);
				} else {
					if ("F".equalsIgnoreCase(seatAllocations.getCabinClass())
							|| "First".equalsIgnoreCase(seatAllocations
									.getCabinClass())) {
						sb.append("First");
					} else {
						sb.append("Coach");
					}
					sb.append(ABEConstants.BLANK_SPACE);
					sb.append("Class");
				}

				sb.append(ABEConstants.BLANK_SPACE);
				sb.append("Seat");
				sb.append(ABEConstants.BLANK_SPACE);
				sb.append(seatAllocations.getSeatNo());
				sb.append(ABEConstants.BLANK_SPACE);
				service.setServiceCode("Seat");
				service.setServiceName(sb.toString());
				if (StringUtils.hasText(seatAllocations.getSelectedDate())) {
					service.setSelectedDate(DateUtils.getDateInGivenFormat(
							seatAllocations.getSelectedDate(),
							ABEConstants.SEAT_SELECTED_DATE_FORMAT));
				}
				services.add(service);
			}
		}
		if (services.size() > 0) {
			itinerary.setServices(services);
		}

	}

	private String getEmailSubject(String emailType, String dataXML)
			throws Exception {

		boolean reservation = false;
		StringBuilder emailSubject = new StringBuilder("");

		if (emailType.equalsIgnoreCase("CUSTOMERFORMATBOOKING")) {
			reservation = true;
		} else if (emailType.equalsIgnoreCase("AGENTFORMATBOOKING")) {
			reservation = true;
		} else if (emailType.equalsIgnoreCase("CUSTOMERFORMATQUOTE")) {
			reservation = false;
		} else if (emailType.equalsIgnoreCase("AGENTFORMATQUOTE")) {
			reservation = false;
		}

		try {
			emailSubject.append(emailProcessor.getMessegeSubject(reservation));
			emailSubject.append(" ");
			emailSubject.append(xmlConverter.getEmailSubject(reservation,
					dataXML));
		} catch (Exception e) {
			throw new Exception(e);
		}
		return emailSubject.toString();
	}

	/**
	 * 
	 * Method used to generate an XML manifestation of Itinerary object
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private String marshal(PrintItinerary itinerary) throws Exception {
		XStream xstream;
		try {
			xstream = new XStream();
			// Replace fully qualified names of classes with readable XML names
			xstream.alias("Itinerary",
					com.kcdata.abe.data.dto.PrintItinerary.class);
			xstream.alias("Passenger", com.kcdata.abe.data.dto.Passenger.class);
			xstream.alias("Agent", com.kcdata.abe.data.dto.Agent.class);
			xstream.alias("GuestInfo", com.kcdata.abe.data.dto.GuestInfo.class);
			xstream.alias("TripFlight",
					com.kcdata.abe.data.dto.TripFlight.class);
			xstream.alias("FlightSegment",
					com.kcdata.abe.data.dto.FlightSegment.class);
			xstream.alias("Hotel", com.kcdata.abe.data.dto.Hotel.class);
			xstream.alias("RoomCategory",
					com.kcdata.abe.data.dto.RoomCategory.class);
			xstream.alias("RoomPrice", com.kcdata.abe.data.dto.RoomPrice.class);
			xstream.alias("Insurance", com.kcdata.abe.data.dto.Insurance.class);
			xstream.alias("Service", com.kcdata.abe.data.dto.Service.class);
			xstream.alias("Package", com.kcdata.abe.data.dto.Package.class);
			xstream.alias("Vehicle", com.kcdata.abe.data.dto.Vehicle.class);
			xstream.alias("PaymentHistory",
					com.kcdata.abe.data.dto.PaymentHistoryInfo.class);
			xstream.alias("CreditCard",
					com.kcdata.abe.data.dto.CreditCard.class);
			xstream.alias("GuaranteedCheck",
					com.kcdata.abe.data.dto.GuaranteedCheck.class);
			xstream.alias("MoneyTransfer",
					com.kcdata.abe.data.dto.MoneyTransfer.class);
			xstream.alias("Alert", com.kcdata.abe.data.dto.Alert.class);
			return xstream.toXML(itinerary);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(XML_MARSHAL_EXCEPTION);
		}
	}

	private XMLConvertUtils xmlConverter;
	private EmailUtils emailProcessor;

	/**
	 * @return the emailProcessor
	 */
	public EmailUtils getEmailProcessor() {
		return emailProcessor;
	}

	/**
	 * @param emailProcessor
	 *            the emailProcessor to set
	 */
	public void setEmailProcessor(EmailUtils emailProcessor) {
		this.emailProcessor = emailProcessor;
	}

	/**
	 * @return the xmlConverter
	 */
	public XMLConvertUtils getXmlConverter() {
		return xmlConverter;
	}

	/**
	 * @param xmlConverter
	 *            the xmlConverter to set
	 */
	public void setXmlConverter(XMLConvertUtils xmlConverter) {
		this.xmlConverter = xmlConverter;
	}

	private void processWarningErrors(Exception e, ABEResponse response,
			String debugMessage) {
		// Throw in case of irrecoverable error
		ABESystemError systemError = new ABESystemError("101", e.getMessage(),
				debugMessage);
		throw new ABESystemException(systemError, ABETier.BUSINESS,
				e.getMessage());
	}

	/**
	 * 
	 * Updates the deposit due from gross total for travel dates less than 45,
	 * for customer format print/email invoices.
	 * 
	 * @param itinerary
	 * @param xslFormat
	 * 
	 * @see
	 * @since
	 */
	private void modifyDepositDue(PrintItinerary itinerary, String xslFormat) {
		if (xslFormat.equalsIgnoreCase("CUSTOMERFORMATBOOKING")) {
			// long datediff = DateUtils.dateDifferenceInDays(itinerary
			// .getBookingHeader().getBookingDate(), itinerary
			// .getBookingHeader().getDepartureDate());
			// if (datediff <= 45) { //CQ#8927 - Condition added for equal to 45

			// for Holiday period 60 days and non holdiday persion 45 scenarion
			// both opt date and finalpayment date will be same
			// according to kim
			long datediff = DateUtils.dateDifferenceInDays(itinerary
					.getBookingHeader().getOptionDate(), itinerary
					.getBookingHeader().getFinalDueDate());
			if (datediff == 0) { // CQ#8927 - Condition added for equal to 45
				itinerary.getBookingHeader().setMinimumAmount(
						itinerary.getBookingHeader().getTourPrice()
								- itinerary.getBookingHeader().getAmountPaid());
			}
			// CQ#8955 - Added for displaying Gross balance Due in Agent
		} else if (xslFormat.equalsIgnoreCase("AGENTFORMATBOOKING")) {
			long datediff = DateUtils.dateDifferenceInDays(itinerary
					.getBookingHeader().getBookingDate(), itinerary
					.getBookingHeader().getDepartureDate());
			// if (datediff > 45) {
			itinerary.getBookingHeader().setGrossBalanceDue(
					itinerary.getBookingHeader().getTourPrice()
							- itinerary.getBookingHeader().getAmountPaid());
			// }

		}
	}

	/**
	 * 
	 * Method to add no of nights for a hotel to existing itinerary for email
	 * and print purpose
	 * 
	 * @param itinerary
	 * 
	 */
	public static void processNoOfNightsHotels(PrintItinerary itinerary) {

		if (itinerary.getPackages() != null
				&& itinerary.getPackages().size() > 0) {
			List<Package> packages = itinerary.getPackages();
			Iterator<Package> iterator = packages.iterator();
			while (iterator.hasNext()) {
				Package package1 = (Package) iterator.next();
				Hotel selectedHotel = package1.getSelectedHotel();
				selectedHotel.setNoOfNights(String.valueOf(DateUtils
						.dateDifferenceInDays(selectedHotel.getCheckInDate(),
								selectedHotel.getCheckOutDate())));
			}
		} else if (itinerary.getHotels() != null
				&& itinerary.getHotels().size() > 0) {
			List<Hotel> hotels = itinerary.getHotels();
			Iterator<Hotel> iterator = hotels.iterator();
			while (iterator.hasNext()) {
				Hotel hotel = iterator.next();
				hotel.setNoOfNights(String.valueOf(DateUtils
						.dateDifferenceInDays(hotel.getCheckInDate(),
								hotel.getCheckOutDate())));
			}
		}

	}

	/**
	 * 
	 * TODO: Updates commission amount for quote for agent
	 * 
	 * @param itinerary
	 * @param xslFormat
	 * 
	 * @see
	 * @since
	 */
	private void calculateCommissionAmount(PrintItinerary itinerary) {
		double commissionAmount = 0.0;

		// calculate commissionAmount for hotels
		commissionAmount = commissionAmount
				+ calculateCommissionAmountHotels(itinerary);

		// calculate commissionAmount for flights
		commissionAmount = commissionAmount
				+ calculateCommissionAmountFlights(itinerary);

		// calculate commissionAmount for vehicles
		commissionAmount = commissionAmount
				+ calculateCommissionAmountVehicles(itinerary);

		// calculate commissionAmount for package
		commissionAmount = commissionAmount
				+ calculateCommissionAmountPackage(itinerary);

		// calculate commissionAmount for multidest package
		commissionAmount = commissionAmount
				+ calculateCommissionAmountMultPackage(itinerary);

		// set commission amount
		itinerary.getBookingHeader().setBaseCommission(commissionAmount);

	}

	/**
	 * 
	 * Calculate commission amount for hotels
	 * 
	 * @param itinerary
	 * @return commission amount
	 * 
	 * @see
	 * @since
	 */
	private double calculateCommissionAmountHotels(PrintItinerary itinerary) {
		double commissionAmount = 0.0;
		if (itinerary.getHotels() != null && itinerary.getHotels().size() > 0) {
			for (Hotel hotel : itinerary.getHotels()) {
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					commissionAmount = commissionAmount
							+ roomPrice.getCommissionAmount();
				}
			}
		}

		return commissionAmount;
	}

	/**
	 * 
	 * Calculate commission amount for flights
	 * 
	 * @param itinerary
	 * @return commission amount
	 * 
	 * @see
	 * @since
	 */
	private double calculateCommissionAmountFlights(PrintItinerary itinerary) {
		double commissionAmount = 0.0;
		if (itinerary.getFlights() != null && itinerary.getFlights().size() > 0) {
			for (com.kcdata.abe.data.dto.TripFlight flight : itinerary
					.getFlights()) {
				commissionAmount = commissionAmount
						+ flight.getPrice().getCommissionAmount();
			}
		}

		return commissionAmount;
	}

	/**
	 * 
	 * Calculate commission amount for vehicles
	 * 
	 * @param itinerary
	 * @return commission amount
	 * 
	 * @see
	 * @since
	 */
	private double calculateCommissionAmountVehicles(PrintItinerary itinerary) {
		double commissionAmount = 0.0;
		if (itinerary.getVehicles() != null
				&& itinerary.getVehicles().size() > 0) {
			for (Vehicle vehicle : itinerary.getVehicles()) {
				commissionAmount = commissionAmount
						+ vehicle.getPrice().getCommissionAmount();
			}
		}

		return commissionAmount;
	}

	/**
	 * 
	 * Calculate commission amount for Package
	 * 
	 * @param itinerary
	 * @return commission amount
	 * 
	 * @see
	 * @since
	 */
	private double calculateCommissionAmountPackage(PrintItinerary itinerary) {
		double commissionAmount = 0.0;
		if (itinerary.getPackages() != null
				&& itinerary.getPackages().size() > 0) {
			for (Package packag : itinerary.getPackages()) {
				commissionAmount = commissionAmount
						+ packag.getPrice().getCommissionAmount();
			}
		}

		return commissionAmount;
	}

	/**
	 * 
	 * Calculate commission amount for MultiDestPackage
	 * 
	 * @param itinerary
	 * @return commission amount
	 * 
	 * @see
	 * @since
	 */
	private double calculateCommissionAmountMultPackage(PrintItinerary itinerary) {
		double commissionAmount = 0.0;
		if (itinerary.getMultiDestinationPackages() != null
				&& itinerary.getMultiDestinationPackages().size() > 0) {
			for (MultiDestinationPackage packag : itinerary
					.getMultiDestinationPackages()) {
				commissionAmount = commissionAmount
						+ packag.getPrice().getCommissionAmount();
			}
		}

		return commissionAmount;
	}

	/**
	 * @param emailProps
	 *            the emailProps to set
	 */
	public void setEmailProps(Properties emailProps) {
		this.emailProps = emailProps;
	}

	/**
	 * @return the emailProps
	 */
	public Properties getEmailProps() {
		return emailProps;
	}
}
