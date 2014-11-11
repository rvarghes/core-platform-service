package com.kcdata.abe.business.service;

import com.kcdata.abe.application.command.ExpireBookingCommand;
import com.kcdata.abe.framework.service.ABEService;

public interface ExpireBookingService extends ABEService{
	
	public boolean processExpireBooking(ExpireBookingCommand bookingCommand);
}
