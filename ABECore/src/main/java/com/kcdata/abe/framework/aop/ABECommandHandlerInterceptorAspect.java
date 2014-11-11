/*
 * ABECommandHandlerInterceptorAspect.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.aop.interceptor.ABEInterceptorBase;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABERequestContext;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.ABEUniqueIdGenerator;

/**
 * Class intercepts all the calls from FLEX to CommandHandler objects N/A
 * specific usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABECommandHandlerInterceptorAspect extends ABEInterceptorBase {

	/**
	 * Logger Initialization
	 */
	ABELogger performanceLogger = ABELogger.getLogger("performance.log");
	ABELogger logger = ABELogger
			.getLogger(ABECommandHandlerInterceptorAspect.class);

	private static String[] classesToProfile = {
			"com.kcdata.abe.application.command.RetrieveFlightsCommand",
			"com.kcdata.abe.application.command.RetrieveHotelsCommand",
			"com.kcdata.abe.application.command.RetrieveVehiclesCommand",
			"com.kcdata.abe.application.command.RetrievePackagesCommand",
			"com.kcdata.abe.application.command.RetrieveSpecialsCommand",
			"com.kcdata.abe.application.command.RetrieveMultiDestPackageCommand",
			"com.kcdata.abe.application.command.PriceItineraryCommand",
			"com.kcdata.abe.application.command.RetrieveServicesCommand",
			"com.kcdata.abe.application.command.RetrieveInsuranceCommand",
			"com.kcdata.abe.application.command.BookItineraryCommand",
			"com.kcdata.abe.application.command.RetrieveBookingCommand",
			"com.kcdata.abe.application.command.SaveItineraryChangeCommand" };

	private static List<String> profileClassesList = Arrays
			.asList(classesToProfile);

	/**
	 * "Before" advise method to inject the Context information into the
	 * ApplicationContext
	 * 
	 * @param command
	 * 
	 * @see
	 * @since
	 */
	public void interceptCommandHadler(ABECommand command) {

		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.getApplicationContextFactory().create();
		}
		ABERequestContext requestContext = applicationContext
				.getRequestContext();
		requestContext.setRequestId(ABEUniqueIdGenerator.generateUniqueID());
		requestContext.setRequestTime(new Date());
		requestContext.setRequestTier(ABETier.PRESENTATION);
		if (command != null && command.getIMApplicationInfo() != null) {
			requestContext.setIMApplicationInfo(command.getIMApplicationInfo());
		}
	}

	/**
	 * "Around Advice" method to profile the response times
	 * 
	 * @param pjp
	 * @param command
	 * @return
	 * @throws Throwable
	 * 
	 * @see
	 * @since
	 */
	public Object profileCommandHandler(ProceedingJoinPoint pjp,
			ABECommand command) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("PROFILE");
		Object output = pjp.proceed(new Object[] { command });
		stopWatch.stop();
		if (profileClassesList.contains(command.getClass().getName())) {
			// Profile the command
			profileCommand(command, stopWatch.getTotalTimeMillis());
		}
		return output;
	}

	/**
	 * "After" advise method to log all the system errors
	 * 
	 * @param command
	 * 
	 * @see
	 * @since
	 */
	public Object logSystemErrors(ABECommand command) {
		if (command.getSystemErrors() != null
				&& command.getSystemErrors().size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (ABESystemError systemError : command.getSystemErrors()) {
				sb.append("CODE: ");
				sb.append(systemError.getErrorCode());
				sb.append("\n");
				sb.append(" DESCRIPTION: ");
				sb.append(systemError.getErrorDescription());
				sb.append("\n");
				sb.append(" DEBUG MESSAGE: ");
				sb.append(systemError.getDebugMessage());
				sb.append("\n");
			}
			logger.fatal(sb.toString());
		}
		return command;
	}

	/**
	 * Method to profile the {@link ABECommand}
	 * 
	 * @param abeCommand
	 * @param timeInMillis
	 */
	private void profileCommand(ABECommand abeCommand, long timeInMillis) {
		if (abeCommand == null) {
			return;
		}
		List<String> messages = new ArrayList<String>();
		String className = abeCommand.getClass().getName();
		messages.add(className.substring(className.lastIndexOf(".") + 1));
		messages.add("" + timeInMillis);
		messages
				.add(profileIMApplicationInfo(abeCommand.getIMApplicationInfo()));
		SearchCriteria searchCriteria = (SearchCriteria) invokeMethod(
				abeCommand, "getSearchCriteria");
		if (searchCriteria != null) {
			messages.add(profileSearchCriteria(searchCriteria));
		} else {
			Itinerary itinerary = (Itinerary) invokeMethod(abeCommand,
					"getItinerary");
			if (itinerary != null) {
				// Profile the itinerary
				messages.add(profileItinerary(itinerary));
			} else {
				messages.add(",,,,,,,");
			}
		}
		performanceLogger.info(StringUtils
				.collectionToCommaDelimitedString(messages));
		return;
	}

	/**
	 * Method to profile {@link IMApplicationInfo}
	 * 
	 * @param imApplicationInfo
	 * @return
	 */
	private String profileIMApplicationInfo(IMApplicationInfo imApplicationInfo) {
		if (imApplicationInfo == null) {
			return ",,,";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(imApplicationInfo.getContextID() == null ? ""
				: imApplicationInfo.getContextID());
		sb.append(",");
		sb.append(imApplicationInfo.getType() == null ? "" : imApplicationInfo
				.getType().getCode());
		sb.append(",");
		sb.append(imApplicationInfo.getRequestorID() == null ? ""
				: imApplicationInfo.getRequestorID());
		sb.append(",");
		sb.append(imApplicationInfo.getAgentNumber() == null ? ""
				: imApplicationInfo.getAgentNumber());
		return sb.toString();
	}

	/**
	 * Method to profile the {@link SearchCriteria}
	 * 
	 * @param searchCriteria
	 * @return
	 */
	private String profileSearchCriteria(SearchCriteria searchCriteria) {
		if (searchCriteria == null) {
			return ",,,,,,";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(searchCriteria.getGateway() == null ? "" : searchCriteria
				.getGateway());
		sb.append(",");
		if (searchCriteria.getDepartureDate() != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			sb.append(dateFormat.format(searchCriteria.getDepartureDate()));
		}
		sb.append(",");
		if (searchCriteria.getDestinationOptions() != null) {
			if (searchCriteria.getDestinationOptions().size() == 1) {
				sb.append(searchCriteria.getDestinationOptions().get(0)
						.getDestination());
			} else {
				sb.append(searchCriteria.getAnchorGateway());
			}
			sb.append(",");
			sb.append(searchCriteria.getTripDuration());
			sb.append(",");
			sb.append(searchCriteria.getDestinationOptions().size());
			sb.append(",");
		} else {
			sb.append(",,,");
		}
		sb.append(searchCriteria.getBookingNo() == null ? "" : searchCriteria
				.getBookingNo());
		sb.append(",");
		return sb.toString();
	}

	/**
	 * Method to profile the {@link Itinerary} object
	 * 
	 * @param itinerary
	 * @return
	 */
	private String profileItinerary(Itinerary itinerary) {
		if (itinerary == null) {
			return ",,,,,,";
		}
		byte noOfComponents = 0;
		StringBuffer sb = new StringBuffer();
		if (itinerary.getFlights() != null) {
			noOfComponents += itinerary.getFlights().size();
		}
		if (itinerary.getHotels() != null) {
			noOfComponents += itinerary.getHotels().size();
		}
		if (itinerary.getVehicles() != null) {
			noOfComponents += itinerary.getVehicles().size();
		}
		if (itinerary.getPackages() != null) {
			noOfComponents += itinerary.getPackages().size();
		}
		if (itinerary.getMultiDestinationPackages() != null) {
			noOfComponents += itinerary.getMultiDestinationPackages().size();
		}
		if (noOfComponents == 1 && itinerary.getSearchCriteria() != null) {
			if (itinerary.getBookingNo() != null) {
				itinerary.getSearchCriteria().setBookingNo(
						itinerary.getBookingNo());
			}
			sb.append(profileSearchCriteria(itinerary.getSearchCriteria()));
		} else {
			sb.append(",,,,,");
			sb.append(itinerary.getBookingNo() == null ? "" : itinerary
					.getBookingNo());
			sb.append(",");
		}
		sb.append("" + noOfComponents);
		return sb.toString();
	}

	/**
	 * Method to retrieve the specific field value from the {@link ABECommand}
	 * 
	 * @param abeCommand
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings( { "unchecked" })
	private Object invokeMethod(ABECommand abeCommand, String methodName) {
		Class commandClass = abeCommand.getClass();
		try {
			Method method = commandClass.getMethod(methodName);
			if (method == null) {
				return null;
			}
			return method.invoke(abeCommand);
		} catch (Exception ex) {
			return null;
		}
	}
}
