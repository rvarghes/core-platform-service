/*
 * Itinerary.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 * Oct 21, 2009	 hguntupa	  Added new fields for Services
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO to hold the itinerary information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Itinerary  implements ABEDto ,Externalizable {
	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3871460798032016013L;

	private String bookingNo;
	private String name;
	private String quoteNo;
	private SearchCriteria searchCriteria;
	private IMApplicationInfo imApplicationInfo;
	private BookingHeader bookingHeader;
	private List<TripFlight> flights;
	private List<Hotel> hotels;
	private List<GuestInfo> guests;
	private List<Insurance> insurances;
	private List<OpsAlert> opsAlerts;
	private List<ItineraryCharge> itineraryCharges;
	private ItineraryPrice itineraryPrice;
	private Address shippingAddress;
	private List<Vehicle> vehicles;
	private List<Package> packages;
	private List<MultiDestinationPackage> multiDestinationPackages;
	private PaymentInformation paymentInformation;
	private List<Service> services;
	private Occupancy maxOccupancy;
	private OpsAlert transferInfo;
	private boolean allowEdocs;
	private boolean tabUpdated;
	private boolean bookingCancelled;
	private BookingLockDetails bookingLockDetails;
	private List<Alert> notices;
	private ItineraryCancellationRules cancellationRules;
	private boolean allowBPG;
	private Date extendOptionDate;
	private boolean needToResync;
	private boolean isReserve;
	private boolean isNoChange;
	private boolean isModify;
	private RFARequest rfaRequest;
	
	
	public boolean isReserve() {
		return isReserve;
	}
	public void setReserve(boolean isReserve) {
		this.isReserve = isReserve;
	}
	public boolean isNoChange() {
		return isNoChange;
	}
	public void setNoChange(boolean isNoChange) {
		this.isNoChange = isNoChange;
	}
	public boolean isModify() {
		return isModify;
	}
	public void setModify(boolean isModify) {
		this.isModify = isModify;
	} 
	
	private List<SeatAllocations> seatAllocationList;
	/**
	 * @return the extendOptionDate
	 */
	public Date getExtendOptionDate() {
		return extendOptionDate;
	}
	/**
	 * @param extendOptionDate the extendOptionDate to set
	 */
	public void setExtendOptionDate(Date extendOptionDate) {
		this.extendOptionDate = extendOptionDate;
	}


	/**
	 * @return the allowBPG
	 */
	public boolean isAllowBPG() {
		return allowBPG;
	}
	/**
	 * @param allowBPG the allowBPG to set
	 */
	public void setAllowBPG(boolean allowBPG) {
		this.allowBPG = allowBPG;
	}
	/**
	 * @return the cancellationRules
	 */
	public ItineraryCancellationRules getCancellationRules() {
		return cancellationRules;
	}
	/**
	 * @param cancellationRules the cancellationRules to set
	 */
	public void setCancellationRules(ItineraryCancellationRules cancellationRules) {
		this.cancellationRules = cancellationRules;
	}

	/**
	 * List to hold the deleted objects from the Itinerary
	 */
	private List<ABEDto> deletedList;

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quoteNo
	 */
	public String getQuoteNo() {
		return quoteNo;
	}

	/**
	 * @param quoteNo
	 *            the quoteNo to set
	 */
	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the imApplicationInfo
	 */
	public IMApplicationInfo getImApplicationInfo() {
		return imApplicationInfo;
	}

	/**
	 * @param imApplicationInfo
	 *            the imApplicationInfo to set
	 */
	public void setImApplicationInfo(IMApplicationInfo imApplicationInfo) {
		this.imApplicationInfo = imApplicationInfo;
	}

	/**
	 * @return the bookingHeader
	 */
	public BookingHeader getBookingHeader() {
		return bookingHeader;
	}

	/**
	 * @param bookingHeader
	 *            the bookingHeader to set
	 */
	public void setBookingHeader(BookingHeader bookingHeader) {
		this.bookingHeader = bookingHeader;
	}

	/**
	 * @return the flights
	 */
	public List<TripFlight> getFlights() {
		return flights;
	}

	/**
	 * @param flights
	 *            the flights to set
	 */
	public void setFlights(List<TripFlight> flights) {
		this.flights = flights;
	}

	/**
	 * @return the hotels
	 */
	public List<Hotel> getHotels() {
		return hotels;
	}

	/**
	 * @param hotels
	 *            the hotels to set
	 */
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	/**
	 * @return the guests
	 */
	public List<GuestInfo> getGuests() {
		return guests;
	}

	/**
	 * @param guests
	 *            the guests to set
	 */
	public void setGuests(List<GuestInfo> guests) {
		this.guests = guests;
	}

	/**
	 * @return the insurances
	 */
	public List<Insurance> getInsurances() {
		return insurances;
	}

	/**
	 * @param insurances
	 *            the insurances to set
	 */
	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	/**
	 * @return the opsAlerts
	 */
	public List<OpsAlert> getOpsAlerts() {
		return opsAlerts;
	}

	/**
	 * @param opsAlerts
	 *            the opsAlerts to set
	 */
	public void setOpsAlerts(List<OpsAlert> opsAlerts) {
		this.opsAlerts = opsAlerts;
	}

	/**
	 * @return the itineraryCharges
	 */
	public List<ItineraryCharge> getItineraryCharges() {
		return itineraryCharges;
	}

	/**
	 * @param itineraryCharges
	 *            the itineraryCharges to set
	 */
	public void setItineraryCharges(List<ItineraryCharge> itineraryCharges) {
		this.itineraryCharges = itineraryCharges;
	}

	/**
	 * @return the itineraryPrice
	 */
	public ItineraryPrice getItineraryPrice() {
		return itineraryPrice;
	}

	/**
	 * @param itineraryPrice
	 *            the itineraryPrice to set
	 */
	public void setItineraryPrice(ItineraryPrice itineraryPrice) {
		this.itineraryPrice = itineraryPrice;
	}

	/**
	 * @return the shippingAddress
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress
	 *            the shippingAddress to set
	 */
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles
	 *            the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the packages
	 */
	public List<Package> getPackages() {
		return packages;
	}

	/**
	 * @param packages
	 *            the packages to set
	 */
	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	/**
	 * @return the multiDestinationPackages
	 */
	public List<MultiDestinationPackage> getMultiDestinationPackages() {
		return multiDestinationPackages;
	}

	/**
	 * @param multiDestinationPackages
	 *            the multiDestinationPackages to set
	 */
	public void setMultiDestinationPackages(
			List<MultiDestinationPackage> multiDestinationPackages) {
		this.multiDestinationPackages = multiDestinationPackages;
	}

	/**
	 * @return the paymentInformation
	 */
	public PaymentInformation getPaymentInformation() {
		return paymentInformation;
	}

	/**
	 * @param paymentInformation
	 *            the paymentInformation to set
	 */
	public void setPaymentInformation(PaymentInformation paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * @return the maxOccupancy
	 */
	public Occupancy getMaxOccupancy() {
		return maxOccupancy;
	}

	/**
	 * @param maxOccupancy
	 *            the maxOccupancy to set
	 */
	public void setMaxOccupancy(Occupancy maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	/**
	 * @return the transferInfo
	 */
	public OpsAlert getTransferInfo() {
		return transferInfo;
	}

	/**
	 * @param transferInfo
	 *            the transferInfo to set
	 */
	public void setTransferInfo(OpsAlert transferInfo) {
		this.transferInfo = transferInfo;
	}

	/**
	 * @return the allowEdocs
	 */
	public boolean isAllowEdocs() {
		return allowEdocs;
	}

	/**
	 * @param allowEdocs
	 *            the allowEdocs to set
	 */
	public void setAllowEdocs(boolean allowEdocs) {
		this.allowEdocs = allowEdocs;
	}

	/**
	 * @return the deletedList
	 */
	public List<ABEDto> getDeletedList() {
		return deletedList;
	}

	/**
	 * @param deletedList
	 *            the deletedList to set
	 */
	public void setDeletedList(List<ABEDto> deletedList) {
		this.deletedList = deletedList;
	}

	/**
	 * @return the bookingCancelled
	 */
	public boolean isBookingCancelled() {
		return bookingCancelled;
	}

	/**
	 * @param bookingCancelled
	 *            the bookingCancelled to set
	 */
	public void setBookingCancelled(boolean bookingCancelled) {
		this.bookingCancelled = bookingCancelled;
	}
	
	/**
	 * @return the bookingLockDetails
	 */
	public BookingLockDetails getBookingLockDetails() {
		return bookingLockDetails;
	}

	/**
	 * @param bookingLockDetails the bookingLockDetails to set
	 */
	public void setBookingLockDetails(BookingLockDetails bookingLockDetails) {
		this.bookingLockDetails = bookingLockDetails;
	}

	/**
	 * @return the seatAllocationList
	 */
	public List<SeatAllocations> getSeatAllocationList() {
		return seatAllocationList;
	}
	/**
	 * @param seatAllocationList the seatAllocationList to set
	 */
	public void setSeatAllocationList(List<SeatAllocations> seatAllocationList) {
		this.seatAllocationList = seatAllocationList;
	}
	/**
	 * toString method implementation
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Itinerary>\n");
		sb.append("bookingNo: " + bookingNo + "\n");
		sb.append("name: " + name + "\n");
		sb.append("quoteNo: " + quoteNo + "\n");
		sb.append("searchCriteria: " + searchCriteria + "\n");
		sb.append("imApplicationInfo: " + imApplicationInfo + "\n");
		sb.append("bookingHeader: " + bookingHeader + "\n");
		sb.append("flights: " + flights + "\n");
		sb.append("hotels: " + hotels + "\n");
		sb.append("guests: " + guests + "\n");
		sb.append("itineraryCharges: " + itineraryCharges + "\n");
		sb.append("itineraryPrice: " + itineraryPrice + "\n");
		sb.append("shippingAddress: " + shippingAddress + "\n");
		sb.append("eDocsAllowed: " + allowEdocs + "\n");
		sb.append("isTabUpdated: " + tabUpdated + "\n");
		sb.append("</Itinerary>");
		return sb.toString();
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */

	public Object clone() throws CloneNotSupportedException {
		Itinerary itinerary = (Itinerary) super.clone();
		if (searchCriteria != null) {
			itinerary.searchCriteria = (SearchCriteria) searchCriteria.clone();
		}
		if (imApplicationInfo != null) {
			itinerary.imApplicationInfo = (IMApplicationInfo) imApplicationInfo
					.clone();
		}
		if (bookingHeader != null) {
			itinerary.bookingHeader = (BookingHeader) bookingHeader.clone();
		}
		if (flights != null) {
			ArrayList<TripFlight> tripFlightsList = new ArrayList<TripFlight>();
			for (TripFlight tripFlight : flights) {
				tripFlightsList.add((TripFlight) tripFlight.clone());
			}
			itinerary.flights = tripFlightsList;
		}
		if (hotels != null) {
			ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
			for (Hotel hotel : hotels) {
				hotelsList.add((Hotel) hotel.clone());
			}
			itinerary.hotels = hotelsList;
		}
		if (guests != null) {
			ArrayList<GuestInfo> guestList = new ArrayList<GuestInfo>();
			for (GuestInfo guestInfo : guests) {
				guestList.add((GuestInfo) guestInfo.clone());
			}
			itinerary.guests = guestList;
		}
		if (itineraryCharges != null) {
			ArrayList<ItineraryCharge> chargesList = new ArrayList<ItineraryCharge>();
			for (ItineraryCharge guestInfo : itineraryCharges) {
				chargesList.add((ItineraryCharge) guestInfo.clone());
			}
			itinerary.itineraryCharges = chargesList;
		}
		if (itineraryPrice != null) {
			itinerary.itineraryPrice = (ItineraryPrice) itineraryPrice.clone();
		}
		if (shippingAddress != null) {
			itinerary.shippingAddress = (Address) shippingAddress.clone();
		}
		if (packages != null) {
			ArrayList<Package> packagesList = new ArrayList<Package>();
			for (Package availablePackage : packages) {
				packagesList.add((Package) availablePackage.clone());
			}
			itinerary.packages = packagesList;
		}
		if (maxOccupancy != null) {
			itinerary.maxOccupancy = (Occupancy) maxOccupancy.clone();
		}
		if (deletedList != null) {
			ArrayList<ABEDto> deletedItemsList = new ArrayList<ABEDto>();
			for (ABEDto object : deletedList) {
				if (object instanceof TripFlight) {
					deletedItemsList
							.add((ABEDto) ((TripFlight) object).clone());
				} else if (object instanceof Hotel) {
					deletedItemsList.add((ABEDto) ((Hotel) object).clone());
				} else if (object instanceof Vehicle) {
					deletedItemsList.add((ABEDto) ((Vehicle) object).clone());
				} else if (object instanceof Service) {
					deletedItemsList.add((ABEDto) ((Service) object).clone());
				} else if (object instanceof Insurance) {
					deletedItemsList.add((ABEDto) ((Insurance) object).clone());
				}else if(object instanceof SeatAllocations)
				{
					deletedItemsList.add((ABEDto) ((SeatAllocations) object).clone());
				}
			}
		}
		if (bookingLockDetails != null) {
			itinerary.bookingLockDetails = (BookingLockDetails) bookingLockDetails.clone();
		}
		if (notices != null) {
			ArrayList<Alert> noticesList = new ArrayList<Alert>();
			for (Alert alert : notices) {
				noticesList.add((Alert) alert.clone());
			}
			itinerary.notices = noticesList;
		}		
		return itinerary;
	}

	/**
	 * @return the notices
	 */
	public List<Alert> getNotices() {
		return notices;
	}

	/**
	 * @param notices the notices to set
	 */
	public void setNotices(List<Alert> notices) {
		this.notices = notices;
	}

	public void setTabUpdated(boolean tabUpdated) {
		this.tabUpdated = tabUpdated;
	}

	public boolean isTabUpdated() {
		return tabUpdated;
	}
	
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(bookingNo);
		out.writeObject(name);
		out.writeObject(quoteNo);
		out.writeObject(searchCriteria);
		out.writeObject(imApplicationInfo);
		out.writeObject(bookingHeader);
		out.writeObject(flights);
		out.writeObject(hotels);
		out.writeObject(vehicles);
		out.writeObject(packages);
		out.writeObject(multiDestinationPackages);
		out.writeObject(insurances);
		out.writeObject(opsAlerts);
		out.writeObject(services);
		out.writeObject(paymentInformation);
		out.writeObject(guests);
		out.writeObject(itineraryCharges);	
		out.writeObject(itineraryPrice);	
		out.writeObject(shippingAddress);			
		out.writeObject(maxOccupancy);
		out.writeBoolean(allowEdocs);		
		out.writeObject(deletedList);
		out.writeObject(bookingLockDetails);
		out.writeBoolean(tabUpdated);
		out.writeBoolean(bookingCancelled);
		out.writeObject(notices);
		out.writeObject(cancellationRules);
		out.writeBoolean(allowBPG);	
		out.writeObject(extendOptionDate);
		//out.writeObject(currentState);
		//out.writeObject(agency);
		//out.writeObject(isChangeBooking);
		out.writeObject(transferInfo);
		out.writeObject(rfaRequest);
		out.writeObject(seatAllocationList);
		
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		bookingNo=(String)in.readObject();
		name=(String)in.readObject();
		quoteNo=(String)in.readObject();
		searchCriteria=(SearchCriteria)in.readObject();
		imApplicationInfo=(IMApplicationInfo)in.readObject();
		bookingHeader=(BookingHeader)in.readObject();
		flights=(List<TripFlight>)in.readObject();
		hotels=(List<Hotel>)in.readObject();
		vehicles=(List<Vehicle>)in.readObject();
		packages=(List<Package>)in.readObject();
		multiDestinationPackages=(List<MultiDestinationPackage>)in.readObject();
		insurances=(List<Insurance>)in.readObject();
		opsAlerts=(List<OpsAlert>)in.readObject();
		services=(List<Service>)in.readObject();
		paymentInformation=(PaymentInformation)in.readObject();
		guests=(List<GuestInfo>)in.readObject();
		itineraryCharges=(List<ItineraryCharge>)in.readObject();	
		itineraryPrice=(ItineraryPrice)in.readObject();	
		shippingAddress=(Address)in.readObject();			
		maxOccupancy=(Occupancy)in.readObject();
		allowEdocs=in.readBoolean();		
		deletedList=(List<ABEDto>)in.readObject();
		bookingLockDetails=(BookingLockDetails)in.readObject();
		tabUpdated=in.readBoolean();
		bookingCancelled=in.readBoolean();
		notices=(List<Alert>)in.readObject();
		cancellationRules=(ItineraryCancellationRules)in.readObject();
		allowBPG=in.readBoolean();
		extendOptionDate =(Date) in.readObject();
		//currentState=in.readObject();
		//agency=in.readObject();
		//isChangeBooking=in.readObject();
		transferInfo=(OpsAlert)in.readObject();
		rfaRequest=(RFARequest)in.readObject();
		seatAllocationList = (List<SeatAllocations>)in.readObject();
		// when ever a change is done  on this make sure add the line to copyItinerary Method
		
	}
	//Xstream data causing issue when serilized using EXternilization
	public PrintItinerary copyItinerary(){
		PrintItinerary printItinerary= new PrintItinerary();
		printItinerary.setBookingNo(bookingNo);
		printItinerary.setName(getName());
		printItinerary.setQuoteNo(quoteNo);
		printItinerary.setSearchCriteria(searchCriteria);
		printItinerary.setImApplicationInfo(imApplicationInfo);
		printItinerary.setBookingHeader(bookingHeader);
		printItinerary.setFlights(flights);
		printItinerary.setHotels(hotels);
		printItinerary.setVehicles(vehicles);	
		printItinerary.setPackages(packages);
		printItinerary.setMultiDestinationPackages(multiDestinationPackages);
		printItinerary.setInsurances(insurances);
		printItinerary.setOpsAlerts(opsAlerts);
		printItinerary.setServices(services);
		printItinerary.setPaymentInformation(paymentInformation);
		printItinerary.setGuests(guests);
		printItinerary.setItineraryCharges(itineraryCharges);
		printItinerary.setItineraryPrice(itineraryPrice);
		printItinerary.setShippingAddress(shippingAddress);
		printItinerary.setMaxOccupancy(maxOccupancy);
		printItinerary.setAllowEdocs(allowEdocs);
		printItinerary.setDeletedList(deletedList);
		printItinerary.setBookingLockDetails(bookingLockDetails);
		printItinerary.setTabUpdated(tabUpdated);
		printItinerary.setBookingCancelled(bookingCancelled);
		printItinerary.setNotices(notices);
		printItinerary.setCancellationRules(cancellationRules);
		printItinerary.setAllowBPG(allowBPG);
		printItinerary.setExtendOptionDate(extendOptionDate);
		//printItinerary.set//currentState
		//printItinerary.set//agency
		//printItinerary.set//isChangeBooking
		printItinerary.setTransferInfo(transferInfo);
		printItinerary.setSeatAllocations(seatAllocationList);
		return printItinerary;
	}
	/**
	 * @param needToResync the needToResync to set
	 */
	public void setNeedToResync(boolean needToResync) {
		this.needToResync = needToResync;
	}
	/**
	 * @return the needToResync
	 */
	public boolean isNeedToResync() {
		return needToResync;
	}
	/**
	 * @return the rfaRequest
	 */
	public RFARequest getRfaRequest() {
		return rfaRequest;
	}
	/**
	 * @param rfaRequest the rfaRequest to set
	 */
	public void setRfaRequest(RFARequest rfaRequest) {
		this.rfaRequest = rfaRequest;
	}
}