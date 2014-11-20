package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.business.response.VehicleClassResponse;
import com.kcdata.abe.data.dto.CarType;
import com.kcdata.abe.data.dto.VehicleClass;
import com.kcdata.abe.framework.dao.ABEDao;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * 
 * @author npanday
 * 
 */
public class VehicleClassSAPDaoImpl extends ABESAPDaoBase implements
		VehicleClassDao {

	public VehicleClassResponse retrieveVehicles() {
		VehicleClassResponse vehicleClassResponse = new VehicleClassResponse();
		List<CarType> carTypes = new ArrayList<CarType>();
		
			
		CarType carType1 = new CarType();
		carType1.setId(3);
		carType1.setName("Economy");
		carTypes.add(carType1);
		
		CarType carType2 = new CarType();
		carType2.setId(4);
		carType2.setName("Compact");
		carTypes.add(carType2);
		
		CarType carType3 = new CarType();
		carType3.setId(5);
		carType3.setName("Midsize");
		carTypes.add(carType3);
		
		CarType carType4 = new CarType();
		carType4.setId(8);
		carType4.setName("Fullsize");
		carTypes.add(carType4);
		
		CarType carType5 = new CarType();
		carType5.setId(9);
		carType5.setName("Luxury");
		carTypes.add(carType5);
		
		CarType carType6 = new CarType();
		carType6.setId(11);
		carType6.setName("Minivan");
		carTypes.add(carType6);
				
		CarType carType7 = new CarType();
		carType7.setId(27);
		carType7.setName("Standard SUV");
		carTypes.add(carType7);
				
		CarType carType8 = new CarType();
		carType8.setId(28);
		carType8.setName("Medium SUV");
		carTypes.add(carType8);
		
		CarType carType9 = new CarType();
		carType9.setId(29);
		carType9.setName("Jeep");
		carTypes.add(carType9);
		
		CarType carType10 = new CarType();
		carType10.setId(30);
		carType10.setName("Convertible");
		carTypes.add(carType10);
		
		vehicleClassResponse.setCarTypes(carTypes);
		
		return vehicleClassResponse;
	}

}
