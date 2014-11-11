/*
 * DateUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Class to hold the utility methods on Date object
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class DateUtils {

	/**
	 * Method to compute the date difference
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static long timeDifference(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			if (date1.after(date2)) {
				return date1.getTime() - date2.getTime();
			} else {
				return date2.getTime() - date1.getTime();
			}
		}
		return -1;
	}

	/**
	 * Method to compute the date difference in days
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static long dateDifferenceInDays(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			// Creates two calendars instances
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			// Set the date for both of the calendar instance
			cal1.setTime(date1);
			cal1.set(Calendar.HOUR_OF_DAY, 0);
			cal1.set(Calendar.MINUTE, 0);
			cal1.set(Calendar.SECOND, 0);
			cal1.set(Calendar.MILLISECOND, 0);
			cal2.setTime(date2);
			cal2.set(Calendar.HOUR_OF_DAY, 0);
			cal2.set(Calendar.MINUTE, 0);
			cal2.set(Calendar.SECOND, 0);
			cal2.set(Calendar.MILLISECOND, 0);
			// Get the represented date in milliseconds
			long milis1 = cal1.getTimeInMillis()
					+ cal1.getTimeZone().getOffset(cal1.getTimeInMillis());
			long milis2 = cal2.getTimeInMillis()
					+ cal2.getTimeZone().getOffset(cal2.getTimeInMillis());
			long diff = milis2 - milis1;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			return diffDays;
		}
		return -1;
	}

	public static long dateDifferenceInDaysForCancelPenalty(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			// Creates two calendars instances
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			// Set the date for both of the calendar instance
			cal1.setTime(date1);
			cal1.set(Calendar.HOUR_OF_DAY, 0);
			cal1.set(Calendar.MINUTE, 0);
			cal1.set(Calendar.SECOND, 0);
			cal1.set(Calendar.MILLISECOND, 0);
			cal2.setTime(date2);
			cal2.set(Calendar.HOUR_OF_DAY, 0);
			cal2.set(Calendar.MINUTE, 0);
			cal2.set(Calendar.SECOND, 0);
			cal2.set(Calendar.MILLISECOND, 0);
			// Get the represented date in milliseconds
			long milis1 = cal1.getTimeInMillis()
					+ cal1.getTimeZone().getOffset(cal1.getTimeInMillis());
			long milis2 = cal2.getTimeInMillis()
					+ cal2.getTimeZone().getOffset(cal2.getTimeInMillis());
			long diff = milis2 - milis1;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			return diffDays-1;
		}
		return -1;
	}
	/**
	 * Method to retrieve the time difference in milliseconds
	 * 
	 * @param date1
	 * @param timeZoneStr1
	 * @param date2
	 * @param timeZoneStr2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static long timeDifference(Date date1, String timeZoneStr1,
			Date date2, String timeZoneStr2) {
		if (date1 != null && date2 != null) {
			// Convert the date1 to required timezone
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			if (timeZoneStr1 != null && timeZoneStr2 != null) {
				Calendar calendar1 = new GregorianCalendar(TimeZone
						.getTimeZone(timeZoneStr1));
				calendar1
						.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DAY_OF_MONTH), cal
										.get(Calendar.HOUR_OF_DAY), cal
										.get(Calendar.MINUTE), cal
										.get(Calendar.SECOND));
				date1 = calendar1.getTime();
				// Convert the date2 to required timezone
				cal.setTime(date2);
				Calendar calendar2 = new GregorianCalendar(TimeZone
						.getTimeZone(timeZoneStr2));
				calendar2
						.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
								cal.get(Calendar.DAY_OF_MONTH), cal
										.get(Calendar.HOUR_OF_DAY), cal
										.get(Calendar.MINUTE), cal
										.get(Calendar.SECOND));

				// Set the dates calendar to date1 timezone
				Calendar targetCal = new GregorianCalendar(TimeZone
						.getTimeZone(timeZoneStr1));
				targetCal.setTimeInMillis(calendar2.getTimeInMillis());
				date2 = targetCal.getTime();
			}

			if (date1 != null && date2 != null) {
				if (date1.after(date2)) {
					return date1.getTime() - date2.getTime();
				} else {
					return date2.getTime() - date1.getTime();
				}
			}
		}
		return -1;
	}

	/**
	 * Method to retrieve the time difference in milliseconds
	 * 
	 * @param startDate
	 * @param noOfDays
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Date addDaysToDate(Date startDate, int noOfDays) {

		Date finalDate = new Date();
		if (startDate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			cal.add(Calendar.DATE, noOfDays);
			finalDate = cal.getTime();
		}
		return finalDate;
	}

	public static String reformatDate(String sourceDate, String sourceFormat,
			String targetFormat) {
		// takes sourcedate formatted as sourceFormat and reformats it as
		// targetFormat

		Date parsedDate = null;
		String result = "";

		try {

			// create Date Object using sourceformat
			SimpleDateFormat formatter = new SimpleDateFormat(sourceFormat);
			ParsePosition pos = new ParsePosition(0);
			parsedDate = formatter.parse(sourceDate, pos);

			// Format using new targetFormat
			formatter = new SimpleDateFormat(targetFormat);
			String formattedDate = formatter.format(parsedDate);
			result = formattedDate;

		} catch (Exception e) {
			return "";
		} 

		return (result);
	}
	
	/**
	 * Returns Date object in specific format for the string passed 
	 *
	 * @param strDate
	 * @param format
	 * @return
	 *
	 * @see
	 * @since
	 */
	public static Date getDate(String strDate, String format){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S z");
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(strDate, pos);
	}
	
	
	/**
	 * Returns Date object in specific format for the string passed 
	 *
	 * @param strDate
	 * @param format
	 * @return
	 * @throws ParseException 
	 *
	 * @see
	 * @since
	 */
	public static Date getDateInGivenFormat(String strDate, String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(strDate,pos);
		
	}
	
}
