package com.kcdata.abe.data.dao;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.MultiDestPackagesRequest;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.RetrieveMultidestinationPackages;

public interface WesbMultiDestinationPackageDao
{
public List<Hotel> retrieveMultidestinationPackages(HotelsRequest multidestPackageRequest,Map<String,HBSiHotelInfo> hbsiHotelList);
}
