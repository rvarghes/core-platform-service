/**
 * Class used for fixing support Fix #3535943
 * 
 */

package com.kcdata.abe.application.command.handler;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.application.command.PriceChangeBookingCommand;
import com.kcdata.abe.business.service.PricingThreadService;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class PriceChangeBookingCommandHandler extends ABECommandHandlerBase{

	private PricingThreadService pricingThreadService;
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof PriceChangeBookingCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "PriceChangeBookingCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		PriceChangeBookingCommand priceChangeBookingCommand = (PriceChangeBookingCommand) command;
		//PriceChangeBookingResponse priceChangeBookingResponse = new PriceChangeBookingResponse();
		List<GroupedTripFlight> flightList  = null;
		if(priceChangeBookingCommand.getBookingTypeIndicator()!=null &&
				!"".equals(priceChangeBookingCommand.getBookingTypeIndicator())){
			if("CP".equalsIgnoreCase(priceChangeBookingCommand.getBookingTypeIndicator())){
				flightList = pricingThreadService.
					createItineraryForPricingOnOtherInstance(priceChangeBookingCommand.getGroupedTripFlight() , priceChangeBookingCommand.getItinerary());
			}
			else if("CL".equalsIgnoreCase(priceChangeBookingCommand.getBookingTypeIndicator())
			||	"CA".equalsIgnoreCase(priceChangeBookingCommand.getBookingTypeIndicator())	
			||  "SA".equalsIgnoreCase(priceChangeBookingCommand.getBookingTypeIndicator())
			||  "SL".equalsIgnoreCase(priceChangeBookingCommand.getBookingTypeIndicator())){
				flightList = pricingThreadService.
				createItineraryForFlightOnlyPricingOnOtherInstance(priceChangeBookingCommand.getGroupedTripFlight() , priceChangeBookingCommand.getItinerary());
			}
		}
		List <TripFlight> tempBVF;
		
		for(GroupedTripFlight grpdTripFlight : flightList)
		{
			if(grpdTripFlight.isPackagePriced()){
			tempBVF = new ArrayList<TripFlight>();
			for (TripFlight tFlight : grpdTripFlight.getTripFlights())
			{
				if(tFlight.isPackagePriceSet())
					tempBVF.add(tFlight);			
			}
			if(tempBVF.size() == 0)
			{
				grpdTripFlight.getTripFlights().clear();
			}
			else{
				TripFlight firstTF = (TripFlight)tempBVF.get(0);
				for (TripFlight priceTf : tempBVF){
					priceTf.setFlightSelectedForDisplay(false);
					if(priceTf.getPrice().getOccpancyBasedPrice() < firstTF.getPrice().getOccpancyBasedPrice())
						firstTF = priceTf;
					}
				firstTF.setFlightSelectedForDisplay(true);	//Minimum priced class of services' flightSelectedForDisplay to true
				grpdTripFlight.getTripFlights().clear();
				grpdTripFlight.setTripFlights(tempBVF);
				}
			tempBVF = null;	//Release this object, job over.
			}
		}
		
		List<GroupedTripFlight> mainList = priceChangeBookingCommand.getTotalGroupedTripFlight();
		//Updating 10 GTF List in main GTF List
		for(GroupedTripFlight pricedGTF:flightList)		//Received 10 GTF, setting them in main list
		{
			for(int pos=0; pos < mainList.size(); pos++)	//Main groupedTripFlight Collection 
			{
				if(pricedGTF.getFlightId()!=null && !"".equals(pricedGTF.getFlightId())
						&& pricedGTF.getFlightId().equalsIgnoreCase(mainList.get(pos).getFlightId())){
					mainList.remove(pos);
					mainList.add(pos, pricedGTF);
					break;
				}
			}
		}
		
		List<TripFlight> displayTripFlightList = new ArrayList<TripFlight>();
		//Setting DisplayTripFlight List
		for (GroupedTripFlight grpdTripFlight : mainList)
		{
			for (TripFlight tFlight : grpdTripFlight.getTripFlights())
			{
				if(tFlight.isFlightSelectedForDisplay())
					displayTripFlightList.add(tFlight);
			}
		}
		//priceChangeBookingResponse.setGroupedTripFlight(flightList);
		priceChangeBookingCommand.setDisplayTripFlightList(displayTripFlightList);
		priceChangeBookingCommand.setTotalGroupedTripFlight(priceChangeBookingCommand.getTotalGroupedTripFlight());
		return priceChangeBookingCommand;
	}

	/**
	 * @return the pricingThreadService
	 */
	public PricingThreadService getPricingThreadService() {
		return pricingThreadService;
	}

	/**
	 * @param pricingThreadService the pricingThreadService to set
	 */
	public void setPricingThreadService(PricingThreadService pricingThreadService) {
		this.pricingThreadService = pricingThreadService;
	}

}
