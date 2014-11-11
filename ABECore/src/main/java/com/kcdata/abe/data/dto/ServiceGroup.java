/*
 * ServiceGroup.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 5, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to group the supplements based on material group
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServiceGroup implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8628912466093629373L;

	private String code;
	private String description;
	private List<Service> services;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * Method to add a service to the group
	 *
	 * @param service
	 *
	 * @see
	 * @since
	 */
	public void addServiceToGroup(Service service) {
		if(service == null) {
			return;
		}
		if(services == null) {
			services = new ArrayList<Service>();
		}
		services.add(service);
	}
	
	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		ServiceGroup serviceGroup = (ServiceGroup) super.clone();
		if (services != null) {
			ArrayList<Service> servicesList = new ArrayList<Service>();
			for (Service service : services) {
				servicesList.add((Service) service.clone());
			}
			serviceGroup.setServices(servicesList);
		}
		return serviceGroup;
	}
}
