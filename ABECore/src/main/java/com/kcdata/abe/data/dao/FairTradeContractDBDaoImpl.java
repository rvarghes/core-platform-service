/*
 * FairTradeContractDBDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.kcdata.abe.business.response.FairTradeContractResponse;
import com.kcdata.abe.data.dto.FairTradeContract;
import com.kcdata.abe.framework.dao.ABEDBDaoBase;

/**
 * DAO implementation class for fair trade contract
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class FairTradeContractDBDaoImpl extends ABEDBDaoBase implements
		FairTradeContractDao {

	/**
	 * Returns terms and conditions text
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public FairTradeContractResponse retrieveTermsAndConditions() {
		FairTradeContractResponse ftcResponse = new FairTradeContractResponse();
		try {
			String ftcSql = "select po.policytext from policy po, policysection ps " +
					"where po.policyid=ps.policyid and po.publish='Y' and " +
					"ps.sectionname='About Us' and po.policyname='Fair Trade Contract' and " +
					"(po.expirationdate>=CURRENT DATE OR po.expirationdate IS NULL)";
			
			// Validate user and get details
			ParameterizedRowMapper<FairTradeContract> ftcMapper = new ParameterizedRowMapper<FairTradeContract>() {
				public FairTradeContract mapRow(ResultSet rs, int rowNum) {
					FairTradeContract fairTradeContract = new FairTradeContract();
					try {
						fairTradeContract.setTermsAndConditions(rs.getString("POLICYTEXT"));
					} catch (SQLException sqlex) {
					}

					return fairTradeContract;
				} // End of mapRow
			}; // End of ParameterizedRowMapper for fair trade contract text
			
			// Query user details
			FairTradeContract fairTradeContract = this.getSimpleJdbcTemplate().queryForObject(ftcSql,
					ftcMapper);
			ftcResponse.setFairTradeContract(fairTradeContract);
		} catch (EmptyResultDataAccessException erdaex) {
		}			
		return ftcResponse;
	}
}