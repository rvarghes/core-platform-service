package com.kcdata.abe.data.dao;

import com.kcdata.abe.application.command.ExpireBookingCommand;
import com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Input;
import com.kcdata.abe.bapi.Yz_Ota_Exp_Booking_Output;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

public class ExpireBookingDaoImpl extends ABESAPDaoBase implements
		ExpireBookingDao {
	ABELogger logger = ABELogger.getLogger(ExpireBookingDaoImpl.class);
	
	public ExpireBookingCommand retriveExpireBooking(ExpireBookingCommand bookingCommand){
		Yz_Ota_Exp_Booking_Input exp_Booking_Input = new Yz_Ota_Exp_Booking_Input();
		exp_Booking_Input.setIm_Seat_Status(bookingCommand.getImSeatStatus());
		exp_Booking_Input.setIm_Update_Tab(bookingCommand.getImUpdateTab());
		Yz_Ota_Exp_Booking_Output exp_Booking_Output =  (Yz_Ota_Exp_Booking_Output)this.getBapiExecutionManager().executeBAPI("Yz_Ota_Exp_Booking", exp_Booking_Input);
		bookingCommand.setYzExpSeatTypes(exp_Booking_Output.getIt_Zexpire_Seat());
		return bookingCommand;
	}
	public ExpireBookingCommand updateExpireBooking(ExpireBookingCommand bookingCommand){
		if(bookingCommand.getYzExpSeatTypes()!=null && bookingCommand.getYzExpSeatTypes().length>0){
			Yz_Ota_Exp_Booking_Input exp_Booking_Input = new Yz_Ota_Exp_Booking_Input();
			exp_Booking_Input.setIm_Seat_Status(bookingCommand.getImSeatStatus());
			exp_Booking_Input.setIm_Update_Tab(bookingCommand.getImUpdateTab());
			exp_Booking_Input.setIt_Zexpire_Seat(bookingCommand.getYzExpSeatTypes());
			Yz_Ota_Exp_Booking_Output exp_Booking_Output =  (Yz_Ota_Exp_Booking_Output)this.getBapiExecutionManager().executeBAPI("Yz_Ota_Exp_Booking", exp_Booking_Input);
		}
		return bookingCommand;
	}

}
