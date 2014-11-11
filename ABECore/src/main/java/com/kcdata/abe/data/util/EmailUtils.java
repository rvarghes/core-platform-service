/*
 * EmailUtils.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 18, 2010  vgandrap
 ******************************************************************************
 *
 */

package com.kcdata.abe.data.util;


import java.io.ByteArrayOutputStream;
import java.io.File;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.URLDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



import org.springframework.core.io.ByteArrayResource;


import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtils {
	private Properties emailProps;
	private JavaMailSender mailSender;

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * @return the emailProps
	 */
	public Properties getEmailProps() {
		return emailProps;
	}

	/**
	 * @param emailProps
	 *            the emailProps to set
	 */
	public void setEmailProps(Properties emailProps) {
		this.emailProps = emailProps;
	}

	public void sendMessage(String toAddress, String emailBody,
			String emailSubject, String fromEmailId) throws Exception {
		String mailer = "sendhtml";
		Properties props = System.getProperties();
		String hostname = (String) emailProps.get("smtp.host.address");
		props.put("mail.smtp.host", hostname);

		// Get a Session object
		Session session = Session.getDefaultInstance(props, null);
		// construct the message
		Message msg = new MimeMessage(session);
		// capture this from FE instead...
		String fromAddress = "";
		if (fromEmailId != null && !"".equals(fromEmailId)) {
			fromAddress = fromEmailId;
		} else {
			fromAddress = (String) emailProps.get("default.from.address");
		}
		msg.setFrom(new InternetAddress(fromAddress));
		msg.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(toAddress, false));
		msg.setSubject(emailSubject);
		msg.setDataHandler(new DataHandler(emailBody, "text/html"));
		msg.setHeader("X-Mailer", mailer);
		msg.setSentDate(new Date());
		Transport.send(msg);
	}

//	public void sendMessageWithAttachment(String toAddress, String emailBody,
//			String emailSubject, String fromEmailId, String filePath,
//			String fileName, String fileExtension, String[] cc) throws Exception {
//
//		Properties props = System.getProperties();
//		String hostname = (String) emailProps.get("smtp.host.address");
//		props.put("mail.smtp.host", hostname);
//		// Get a Session object
//		Session session = Session.getDefaultInstance(props, null);
//		// construct the message
//		MimeMessage message = new MimeMessage(session);
//		// capture this from FE instead...
//		String fromAddress = "";
//		if (fromEmailId != null && !"".equals(fromEmailId)) {
//			fromAddress = fromEmailId;
//		} else {
//			fromAddress = (String) emailProps.get("default.from.address");
//		}
//		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//		helper.setFrom(fromAddress);
//		helper.addAttachment(fileName + fileExtension, new File(filePath));
//		helper.setTo(toAddress);
//		helper.setSubject(emailSubject);
//		helper.setText("Please Check out the Attached PDF");
//		if((null != cc) && (cc.length > 0)){
//			helper.setCc(cc);
//		}
//		Transport.send(message);
//		//mailSender.send(message);
//	}
	
	public void sendMessageWithAttachmentStream(String toAddress, String emailBody,
			String emailSubject, String fromEmailId, ByteArrayOutputStream bos,
			String fileName, String fileExtension, String[] cc,String requestType) throws Exception {

		Properties props = System.getProperties();
		String hostname = (String) emailProps.get("smtp.host.address");
		props.put("mail.smtp.host", hostname);
		// Get a Session object
		Session session = Session.getDefaultInstance(props, null);
		// construct the message
		MimeMessage message = new MimeMessage(session);
		// capture this from FE instead...
		String fromAddress = "";
		if (fromEmailId != null && !"".equals(fromEmailId)) {
			fromAddress = fromEmailId;
		} else {
			fromAddress = (String) emailProps.get("default.from.address");
		}
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom(fromAddress);
		helper.setTo(toAddress);
		helper.setSubject(emailSubject);
		if (requestType.equalsIgnoreCase("Quote")) {
			helper.setText((String) emailProps.get("email.quote.message"), true);
		} else if (requestType.equalsIgnoreCase("Booking")) {
			helper.setText((String) emailProps.get("email.invoice.message"), true);
		} else
			if (requestType.equalsIgnoreCase("RFA")) {
				helper.setText((String) emailProps.get("email.rfa.message"), true);
			}else				
			helper.setText("Thank you for booking with Apple Vacations.", true);
		helper.addAttachment(fileName + fileExtension, new ByteArrayResource(bos.toByteArray()));
		if((null != cc) && (cc.length > 0)){
			helper.setCc(cc);
		}
		Transport.send(message);
		//mailSender.send(message);
	}


	public void sendCreditCardPaymentForm(String emailId, Resource filename)
			throws Exception {
		Properties props = System.getProperties();
		String hostname = (String) emailProps.get("smtp.host.address");
		props.put("mail.smtp.host", hostname);
		// Get a Session object
		Session session = Session.getDefaultInstance(props, null);
		// construct the message
		Message msg = new MimeMessage(session);
		String fromAddress = (String) emailProps.get("default.from.address");
		MimeBodyPart mbp = new MimeBodyPart();
		URLDataSource fds = new URLDataSource(filename.getURL());
		mbp.setDataHandler(new DataHandler(fds));
		mbp.setFileName("Credit_Card_Authorization.pdf");
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp);
		msg.setFrom(new InternetAddress(fromAddress));
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailId, false));
		String subject = (String) emailProps.get("email.creditcardform.subject");
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setContent(mp);
		Transport.send(msg);
	}

	public void sendItineraryComparison(String emailId, byte[] imgByteArray,String fileName) throws Exception {
		Properties props = System.getProperties();
		String hostname = (String) emailProps.get("smtp.host.address");
		props.put("mail.smtp.host", hostname);		
		Session session = Session.getDefaultInstance(props, null);		
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		String fromAddress = (String) emailProps.get("default.from.address");
		helper.setFrom(fromAddress);
		helper.addAttachment(fileName + ".jpeg", new ByteArrayResource(imgByteArray));
		helper.setTo(emailId);
		helper.setSubject((String) emailProps.get("email.itincomparison.subject"));
		helper.setText((String)emailProps.get("email.compare.message"),true);
		Transport.send(message);
		//mailSender.send(message);
	}

	public String getMessegeSubject(boolean reservation) throws Exception {
		String subject = "";
		if (reservation) {
			subject = (String) emailProps.get("email.reservation.subject");
		} else {
			subject = (String) emailProps.get("email.quote.subject");
		}// End of else condition...
		return subject;
	}// End of getMessegeSubject function

	public EmailUtils() {
	}

}
