/*
 * XMLConvertUtils.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 10, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.framework.logging.ABELogger;
import com.thoughtworks.xstream.XStream;

/**
 * XML utility class
 * 
 * @author agudise
 * @version
 * 
 * 
 * @see
 * @since
 */
public class XMLConvertUtils {

	ABELogger abeLogger = ABELogger.getLogger(XMLConvertUtils.class);
	private static final String XML_MARSHAL_EXCEPTION = "XML_MARSHAL_EXCEPTION";

	public XMLConvertUtils() {

	}

	public String getEmailSubject(boolean reservation, String dataXML)
			throws Exception {
		StringBuilder subject = new StringBuilder("");
		try {
			XMLHelper xmlHelp = new XMLHelper(dataXML);
			if (reservation) {
				StringBuilder bookingNumber = new StringBuilder("");
				StringBuilder passengerName = new StringBuilder("");
				if (xmlHelp.getElementCountByXPath(xmapthForGuests) >= 1) {
					passengerName.append(xmlHelp
							.getElementByXPath(xmapthForGuests + "/firstName"));
					passengerName.append(" ");
					passengerName.append(xmlHelp
							.getElementByXPath(xmapthForGuests + "/lastName"));
					passengerName.append("/");
					subject.append(passengerName);
				}// End of guestInfo condition...
				bookingNumber
						.append(xmlHelp
								.getElementByXPath("/Itinerary/bookingHeader/bookingNo"));
				subject.append(bookingNumber);
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				subject.append(dateFormat.format(cal.getTime()));
			}// End of else condition...
		} catch (Exception e) {
			throw new Exception(e);
		}// End of catch statement...
		return subject.toString();
	}// End of getEmailSubject function...

	public Document XMLDocFromString(String xml) throws Exception {

		Document doc = null;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// -- validate? factory.setValidating(true);
		try {

			DocumentBuilder db = factory.newDocumentBuilder();
			StringReader s = new StringReader(xml);
			InputSource is = new InputSource((Reader) s);
			doc = (Document) db.parse(is);

		} catch (SAXException sxe) {
			Exception e = sxe;
			if (sxe.getException() != null)
				e = sxe.getException();
			throw new Exception("Sax exception: " + e.toString());

		} catch (ParserConfigurationException pce) {
			throw new Exception("ParserConfigurationException: "
					+ pce.toString());

		} catch (IOException ioe) {
			throw new Exception("IOException: " + ioe.toString());
		}
		return doc;
	}

	public String transformXML(String XSLFormat, String xmlString,
			EmailAndPrintMessage message, String callType) throws Exception {

		Document doc = XMLDocFromString(xmlString);
		if (null != message) {
			customizeDocument(message, doc, xmlString);
		}
		Resource xsltFile = null;
		if (XSLFormat.equalsIgnoreCase("CUSTOMERFORMATBOOKING")) {
			if ("email".equalsIgnoreCase(callType)) {
				xsltFile = getCustomerBookingXSLT();
			} else {
				xsltFile = getCustomerBookingXSLTPRINT();
			}
		} else if (XSLFormat.equalsIgnoreCase("AGENTFORMATBOOKING")) {
			if ("email".equalsIgnoreCase(callType)) {
				xsltFile = getAgentBookingXSLT();
			} else {
				xsltFile = getAgentBookingXSLTPRINT();
			}
		} else if (XSLFormat.equalsIgnoreCase("CUSTOMERFORMATQUOTE")) {
			if ("email".equalsIgnoreCase(callType)) {
				xsltFile = getCustomerQuoteXSLT();
			} else {
				xsltFile = getCustomerQuoteXSLTPRINT();
			}
		} else if (XSLFormat.equalsIgnoreCase("AGENTFORMATQUOTE")) {
			if ("email".equalsIgnoreCase(callType)) {
				xsltFile = getAgentQuoteXSLT();
			} else {
				xsltFile = getAgentQuoteXSLTPRINT();
			}
		} else if (XSLFormat.equalsIgnoreCase("HOTEL_ALLOTMENT_VENDOR_REQUEST")) {
			xsltFile = getHotelAllotmentVenderXSLT();
		}

		try {
			StreamSource in = new StreamSource(xsltFile.getInputStream());
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(in);
			Source source = new DOMSource(doc);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Result transResult = new StreamResult(out);
			transformer.transform(source, transResult);
			return out.toString();
		} catch (Exception e) {
			throw new Exception("XSLT_TRANSFORMATION_EXCEPTION");
		}
	}

	/**
	 * 
	 * Transforms Breakdown chareges xml
	 * 
	 * @param xmlString
	 * @return
	 * @throws Exception
	 * 
	 * @see
	 * @since
	 */
	public String transformBreakdownChargesXML(String xmlString)
			throws Exception {
		Document doc = XMLDocFromString(xmlString);

		Resource xsltFile = null;
		/*
		 * if (XSLFormat.equalsIgnoreCase("CUSTOMERFORMATBOOKING")) { xsltFile =
		 * getCustomerBookingXSLT(); } else if
		 * (XSLFormat.equalsIgnoreCase("AGENTFORMATBOOKING")) { xsltFile =
		 * getAgentBookingXSLT(); } else if
		 * (XSLFormat.equalsIgnoreCase("CUSTOMERFORMATQUOTE")) { xsltFile =
		 * getCustomerQuoteXSLT(); } else if
		 * (XSLFormat.equalsIgnoreCase("AGENTFORMATQUOTE")) { xsltFile =
		 * getAgentQuoteXSLT(); }
		 */
		xsltFile = getBreakdownChargesXSLT();
		try {
			StreamSource in = new StreamSource(xsltFile.getInputStream());
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(in);
			Source source = new DOMSource(doc);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Result transResult = new StreamResult(out);
			transformer.transform(source, transResult);
			return out.toString();
		} catch (Exception e) {
			System.err.println("## error got while transforming into html");
			throw new Exception("XSLT_TRANSFORMATION_EXCEPTION");
		}
	}

	public String marshal(Object srcObject) throws Exception {
		XStream xstream;
		try {
			xstream = new XStream();
			return xstream.toXML(srcObject);
		} catch (Exception e) {
			throw new Exception(XML_MARSHAL_EXCEPTION);
		}
	}

	/**
	 * 
	 * Method used to customize the Itinerary data for emailing/printing
	 * 
	 * @param messages
	 * 
	 * @see
	 * @since
	 */

	public void customizeDocument(EmailAndPrintMessage messages, Document doc,
			String dataXML) {
		if (doc != null) {
			Element customMessages = doc.createElement("CustomMessages");
			if (messages.getOpeningMessage() != null) {
				Element openingMessage = doc.createElement("OpeningMessage");
				openingMessage.appendChild(doc.createTextNode(messages
						.getOpeningMessage()));
				customMessages.appendChild(openingMessage);
			}
			if (messages.getOpeningMessageText() != null) {
				Element openingMesgText = doc.createElement("OpeningMesgText");
				openingMesgText.appendChild(doc.createTextNode(messages
						.getOpeningMessageText()));
				customMessages.appendChild(openingMesgText);
			}
			if (messages.getClosingMessage() != null) {
				Element closingMessage = doc.createElement("ClosingMessage");
				closingMessage.appendChild(doc.createTextNode(messages
						.getClosingMessage()));
				customMessages.appendChild(closingMessage);
			}
			doc.getFirstChild().appendChild(customMessages);

			XMLHelper xmlHelp = new XMLHelper(dataXML);
			// compute Net total
			String tourPrice = xmlHelp
					.getElementByXPath("/Itinerary/bookingHeader/tourPrice");
			String baseCommission = xmlHelp
					.getElementByXPath("/Itinerary/bookingHeader/baseCommission");
			if (!tourPrice.equalsIgnoreCase("NaN")
					&& !baseCommission.equalsIgnoreCase("NaN")) {
				BigDecimal netTotal = new BigDecimal(tourPrice)
						.subtract(new BigDecimal(baseCommission));
				Element eleNetTotal = doc.createElement("netTotal");
				eleNetTotal.appendChild(doc.createTextNode(netTotal
						.toPlainString()));
				updateElement(doc, eleNetTotal, "bookingHeader");
			}

			// Insert Trip duration
			String tourID = xmlHelp
					.getElementByXPath("/Itinerary/bookingHeader/tourId");
			if (tourID != null) {
				String strTripDuration = tourID.substring(tourID.length() - 2,
						tourID.length());
				int duration = Integer.parseInt(strTripDuration);
				Element tripDuration = doc.createElement("tripDuration");
				tripDuration.appendChild(doc.createTextNode(duration
						+ " Nights"));
				updateElement(doc, tripDuration, "bookingHeader");
			}
		}
	}

	/**
	 * 
	 * Updates an XML element node
	 * 
	 * @param element
	 * @param elementName
	 * 
	 * @see
	 * @since
	 */
	private void updateElement(Document doc, Element element, String elementName) {
		NodeList nodeList = doc.getElementsByTagName(elementName);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element el = (Element) nodeList.item(i);
			el.appendChild(element);
		}
	}

	// String manifest for doc., Debug purpose
	public String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * @return the agentQuoteXSLT
	 */
	public Resource getAgentQuoteXSLT() {
		return agentQuoteXSLT;
	}

	/**
	 * @param agentQuoteXSLT
	 *            the agentQuoteXSLT to set
	 */
	public void setAgentQuoteXSLT(Resource agentQuoteXSLT) {
		this.agentQuoteXSLT = agentQuoteXSLT;
	}

	/**
	 * @return the agentBookingXSLT
	 */
	public Resource getAgentBookingXSLT() {
		return agentBookingXSLT;
	}

	/**
	 * @param agentBookingXSLT
	 *            the agentBookingXSLT to set
	 */
	public void setAgentBookingXSLT(Resource agentBookingXSLT) {
		this.agentBookingXSLT = agentBookingXSLT;
	}

	/**
	 * @return the customerQuoteXSLT
	 */
	public Resource getCustomerQuoteXSLT() {
		return customerQuoteXSLT;
	}

	/**
	 * @param customerQuoteXSLT
	 *            the customerQuoteXSLT to set
	 */
	public void setCustomerQuoteXSLT(Resource customerQuoteXSLT) {
		this.customerQuoteXSLT = customerQuoteXSLT;
	}

	/**
	 * @return the customerBookingXSLT
	 */
	public Resource getCustomerBookingXSLT() {
		return customerBookingXSLT;
	}

	/**
	 * @param customerBookingXSLT
	 *            the customerBookingXSLT to set
	 */
	public void setCustomerBookingXSLT(Resource customerBookingXSLT) {
		this.customerBookingXSLT = customerBookingXSLT;
	}

	/**
	 * @return the agentBookingXSLTPRINT
	 */
	public Resource getAgentBookingXSLTPRINT() {
		return agentBookingXSLTPRINT;
	}

	/**
	 * @param agentBookingXSLTPRINT
	 *            the agentBookingXSLTPRINT to set
	 */
	public void setAgentBookingXSLTPRINT(Resource agentBookingXSLTPRINT) {
		this.agentBookingXSLTPRINT = agentBookingXSLTPRINT;
	}

	/**
	 * @return the customerBookingXSLTPRINT
	 */
	public Resource getCustomerBookingXSLTPRINT() {
		return customerBookingXSLTPRINT;
	}

	/**
	 * @param customerBookingXSLTPRINT
	 *            the customerBookingXSLTPRINT to set
	 */
	public void setCustomerBookingXSLTPRINT(Resource customerBookingXSLTPRINT) {
		this.customerBookingXSLTPRINT = customerBookingXSLTPRINT;
	}

	/**
	 * @return the agentQuoteXSLTPRINT
	 */
	public Resource getAgentQuoteXSLTPRINT() {
		return agentQuoteXSLTPRINT;
	}

	/**
	 * @param agentQuoteXSLTPRINT
	 *            the agentQuoteXSLTPRINT to set
	 */
	public void setAgentQuoteXSLTPRINT(Resource agentQuoteXSLTPRINT) {
		this.agentQuoteXSLTPRINT = agentQuoteXSLTPRINT;
	}

	/**
	 * @return the customerQuoteXSLTPRINT
	 */
	public Resource getCustomerQuoteXSLTPRINT() {
		return customerQuoteXSLTPRINT;
	}

	/**
	 * @param customerQuoteXSLTPRINT
	 *            the customerQuoteXSLTPRINT to set
	 */
	public void setCustomerQuoteXSLTPRINT(Resource customerQuoteXSLTPRINT) {
		this.customerQuoteXSLTPRINT = customerQuoteXSLTPRINT;
	}

	private Resource agentQuoteXSLT;
	private Resource agentBookingXSLT;
	private Resource customerQuoteXSLT;
	private Resource customerBookingXSLT;
	private Resource breakdownChargesXSLT;
	private Resource hotelAllotmentVenderXSLT;
	private Resource agentBookingXSLTPRINT;
	private Resource customerBookingXSLTPRINT;
	private Resource agentQuoteXSLTPRINT;
	private Resource customerQuoteXSLTPRINT;

	/**
	 * @return the breakdownChargesXSLT
	 */
	public Resource getBreakdownChargesXSLT() {
		return breakdownChargesXSLT;
	}

	/**
	 * @param breakdownChargesXSLT
	 *            the breakdownChargesXSLT to set
	 */
	public void setBreakdownChargesXSLT(Resource breakdownChargesXSLT) {
		this.breakdownChargesXSLT = breakdownChargesXSLT;
	}

	/**
	 * @param hotelAllotmentVenderXSLT
	 *            the hotelAllotmentVenderXSLT to set
	 */
	public void setHotelAllotmentVenderXSLT(Resource hotelAllotmentVenderXSLT) {
		this.hotelAllotmentVenderXSLT = hotelAllotmentVenderXSLT;
	}

	/**
	 * @return the hotelAllotmentVenderXSLT
	 */
	public Resource getHotelAllotmentVenderXSLT() {
		return hotelAllotmentVenderXSLT;
	}

	private static final String xmapthForGuests = "/Itinerary/guests/object-array/GuestInfo";
}
