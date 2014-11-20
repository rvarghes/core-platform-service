package com.kcdata.abe.business.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.HotelBusServiceExport_HotelServiceBSHttpPortProxy;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.PackageServiceExport_PackageServiceBSHttpPortProxy;

public class WesbProxyService {

	private HotelBusServiceExport_HotelServiceBSHttpPortProxy proxyService = null;
	private PackageServiceExport_PackageServiceBSHttpPortProxy packageProxyService = null;
	
	public WesbProxyService(String wesbHotelURL,String wesbHotelQname,String wesbPackageURL,String wesbPackageQname) throws MalformedURLException{
		//System.out.println("--"+wesbURL);
		this.proxyService = new HotelBusServiceExport_HotelServiceBSHttpPortProxy(new  URL(wesbHotelURL),new QName(wesbHotelQname,"HotelBusServiceExport_HotelServiceBSHttpService"));
		this.packageProxyService = new PackageServiceExport_PackageServiceBSHttpPortProxy(new  URL(wesbPackageURL),new QName(wesbPackageQname, "PackageServiceExport_PackageServiceBSHttpService"));
	}

	/**
	 * @return the proxyService
	 */
	public  HotelBusServiceExport_HotelServiceBSHttpPortProxy getProxyService() {
		return this.proxyService;
	}

	/**
	 * @param proxyService
	 *            the proxyService to set
	 */
	public void setProxyService(
			HotelBusServiceExport_HotelServiceBSHttpPortProxy proxyService) {
		this.proxyService = proxyService;
	}

	/**
	 * @return the packageProxyService
	 */
	public PackageServiceExport_PackageServiceBSHttpPortProxy getPackageProxyService() {
		return packageProxyService;
	}

	/**
	 * @param packageProxyService the packageProxyService to set
	 */
	public void setPackageProxyService(
			PackageServiceExport_PackageServiceBSHttpPortProxy packageProxyService) {
		this.packageProxyService = packageProxyService;
	}

	
}
