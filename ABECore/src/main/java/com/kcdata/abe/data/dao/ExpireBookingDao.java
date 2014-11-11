package com.kcdata.abe.data.dao;

import com.kcdata.abe.application.command.ExpireBookingCommand;
import com.kcdata.abe.framework.dao.ABEDao;

public interface ExpireBookingDao extends ABEDao {
	
	public ExpireBookingCommand retriveExpireBooking(ExpireBookingCommand bookingCommand);
	public ExpireBookingCommand updateExpireBooking(ExpireBookingCommand bookingCommand);
}
