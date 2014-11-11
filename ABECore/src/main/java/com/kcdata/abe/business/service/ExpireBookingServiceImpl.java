package com.kcdata.abe.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.application.command.ExpireBookingCommand;
import com.kcdata.abe.bapi.Yzexp_SeatType;
import com.kcdata.abe.data.dao.ExpireBookingDao;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.sms.data.dao.SMBookCancDao;
import com.kcdata.sms.data.dto.SMSeatBookingDetail;
import com.kcdata.sms.data.dto.SeatExpireLog;

public class ExpireBookingServiceImpl extends ABEServiceBase implements
		ExpireBookingService {
	ABELogger logger = ABELogger.getLogger(ExpireBookingServiceImpl.class);
	
	private ExpireBookingDao expireBookingDao;
	private SMBookCancDao smBookCancDao;
	
	public SMBookCancDao getSmBookCancDao() {
		return smBookCancDao;
	}

	public void setSmBookCancDao(SMBookCancDao smBookCancDao) {
		this.smBookCancDao = smBookCancDao;
	}

	public ExpireBookingDao getExpireBookingDao() {
		return expireBookingDao;
	}

	public void setExpireBookingDao(ExpireBookingDao expireBookingDao) {
		this.expireBookingDao = expireBookingDao;
	}

	public boolean processExpireBooking(ExpireBookingCommand bookingCommand) {
		int counter = 0;
		bookingCommand.setImUpdateTab(" ");
		bookingCommand.setImSeatStatus(" ");
		bookingCommand = this.expireBookingDao.retriveExpireBooking(bookingCommand);
		if(bookingCommand.getYzExpSeatTypes()!=null && bookingCommand.getYzExpSeatTypes().length>0){
			List<SMSeatBookingDetail> cancelList = new ArrayList<SMSeatBookingDetail>();
			SMSeatBookingDetail bookingDetail = null;
			for(Yzexp_SeatType seatType: bookingCommand.getYzExpSeatTypes()){
				try{
				bookingDetail = new SMSeatBookingDetail();
				bookingDetail.setSbsCarrier(seatType.getZzairline_Code());
				bookingDetail.setSbsDeparturDate(seatType.getZzdepdate());
				bookingDetail.setSbsOrigin(seatType.getMatnr().substring(0,3));
				bookingDetail.setSbsDestination(seatType.getMatnr().substring(3,6));
				bookingDetail.setSbsRotation(Integer.parseInt(seatType.getZzrotation()));
				bookingDetail.setSbsSeatNo(seatType.getZztstno());
				cancelList.add(bookingDetail);
				}catch (Exception e){
					// placeholder for added 
				}
			}
			this.smBookCancDao.bookCancelSeat(null, cancelList);
			logSeats(cancelList);
			for(SMSeatBookingDetail smsSeatBookingDetail : cancelList){
					for(Yzexp_SeatType seatType: bookingCommand.getYzExpSeatTypes()){
						try {
							if(smsSeatBookingDetail.getSbsCarrier().equals(seatType.getZzairline_Code())
									&& smsSeatBookingDetail.getSbsDeparturDate().getTime()== seatType.getZzdepdate().getTime()
									&& smsSeatBookingDetail.getSbsDestination().equals(seatType.getMatnr().substring(3,6))
									&& smsSeatBookingDetail.getSbsOrigin().equals(seatType.getMatnr().substring(0,3))
									&& smsSeatBookingDetail.getSbsRotation()==Integer.parseInt(seatType.getZzrotation())
									&& smsSeatBookingDetail.getSbsSeatNo().equals(seatType.getZztstno())){
								if(smsSeatBookingDetail.getBookingStatus()!=null && smsSeatBookingDetail.getBookingStatus().equals("HK")){
									seatType.setZzseat_Status("X");
									counter +=1;
								}
								break;
							}
						} catch(Exception e){
							e.printStackTrace();
						}
					}
				}
		}
			bookingCommand.setImUpdateTab("X");
			bookingCommand.setImSeatStatus(" ");
			/*Yzexp_SeatType[] seatTypeArr = new Yzexp_SeatType[counter];
			counter = 0;
			for(Yzexp_SeatType seatType : bookingCommand.getYzExpSeatTypes()){
				if(seatType.getZzseat_Status().equals("X")){
					seatTypeArr[counter] = seatType;
					counter +=1;
				}
			}
			bookingCommand.setYzExpSeatTypes(seatTypeArr);
			*/
			bookingCommand = this.expireBookingDao.updateExpireBooking(bookingCommand);
		
		return true;
	}
	public void logSeats(List<SMSeatBookingDetail> cancelList){
		if(cancelList!=null && cancelList.size()>0){
			SeatExpireLog seatExpireLog = null;
			List<SeatExpireLog> seatExpireLogList = null;
			seatExpireLogList = new ArrayList<SeatExpireLog>();
			for(SMSeatBookingDetail bookingDetail: cancelList){
				seatExpireLog = new SeatExpireLog();
				seatExpireLog.setSbsBookingDate(bookingDetail.getSbsBookingDate()==null?new Date():bookingDetail.getSbsBookingDate());
				seatExpireLog.setSbsCarrier(bookingDetail.getSbsCarrier());
				seatExpireLog.setSbsCost(bookingDetail.getSbsCost()==null?0.0:bookingDetail.getSbsCost());
				seatExpireLog.setSbsDepartureDate(bookingDetail.getSbsDeparturDate());
				seatExpireLog.setSbsDestination(bookingDetail.getSbsDestination());
				seatExpireLog.setSbsId(bookingDetail.getSbsId()==null?999:bookingDetail.getSbsId());
				seatExpireLog.setSbsLastUpdateDate(new Date());
				seatExpireLog.setSbsLastUpdatedBy(1);
				seatExpireLog.setSbsOrigin(bookingDetail.getSbsOrigin());
				seatExpireLog.setSbsPrice(bookingDetail.getSbsPrice()==null?0.0:bookingDetail.getSbsPrice());
				seatExpireLog.setSbsRotation(bookingDetail.getSbsRotation());
				seatExpireLog.setSbsSeatNo(bookingDetail.getSbsSeatNo()+""+bookingDetail.getBookingStatus());
				seatExpireLog.setSbsResponseTime(new Date());
				seatExpireLogList.add(seatExpireLog);
			}
			this.smBookCancDao.saveLogs(seatExpireLogList);
		}
		
	}

}
