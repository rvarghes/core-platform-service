/**
 * Class used for fixing support Fix #3535943
 * 
 */
package com.kcdata.abe.data.factory;

import com.kcdata.abe.data.dao.threads.PricingThreadDao;

public interface PricingDaoFactory {

	public PricingThreadDao createPricingThreadDao();
}
