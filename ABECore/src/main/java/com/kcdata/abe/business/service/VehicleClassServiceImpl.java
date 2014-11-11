/**
 * 
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.VehicleClassResponse;
import com.kcdata.abe.data.dao.VehicleClassDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * 
 * @author npanday
 *
 */
public class VehicleClassServiceImpl extends ABEServiceBase implements
		VehicleClassService {

	
	private VehicleClassDao vehicleClassDao;

	/**
	 * @param vehicleClassDao the vehicleClassDao to set
	 */
	public void setVehicleClassDao(VehicleClassDao vehicleClassDao) {
		this.vehicleClassDao = vehicleClassDao;
	}

	/**
	 * @return the vehicleClassDao
	 */
	public VehicleClassDao getVehicleClassDao() {
		return vehicleClassDao;
	}

	public VehicleClassResponse retrieveVehicleClass() {		
		return vehicleClassDao.retrieveVehicles();
	}
	
}