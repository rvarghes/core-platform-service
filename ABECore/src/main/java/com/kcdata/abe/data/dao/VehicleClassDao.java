

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.VehicleClassResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * 
 * @author npanday
 *
 */
public interface VehicleClassDao extends ABEDao {


	public VehicleClassResponse retrieveVehicles();

}
