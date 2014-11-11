/*
 * UserDBDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.kcdata.abe.business.response.AuthenticateUserResponse;
import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.data.dto.UserGroup;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.dao.ABEDBDaoBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.util.ABEConstants;

/**
 * User dao implementation class for user services
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class UserDBDaoImpl extends ABEDBDaoBase implements UserDao,
		ABEConstants {

	/**
	 * Method for authenticating logged in user details
	 * 
	 * @param user
	 *            object with login id and password
	 * @return Response object with user details
	 * 
	 * @see
	 * @since
	 */
	
	public AuthenticateUserResponse authenticateUser(User user) {
		AuthenticateUserResponse userResponse = new AuthenticateUserResponse();
		if (user == null) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_USER_DETAILS");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_USER_DETAILS", null, null));
			userResponse.saveBusinessError(businessError);
			return userResponse;
		}

		try {
			String authUserSql = "select * from UserDetails where loginid = ? and password = ?";
			// Validate user and get details
			ParameterizedRowMapper<User> mapper = new ParameterizedRowMapper<User>() {
				public User mapRow(ResultSet rs, int rowNum) {
					User user = null;
					try {
						user = new User();
						user.setUserId(rs.getInt("USERID"));
						user.setFirstName(rs.getString("FIRSTNAME"));
						user.setMiddleName(rs.getString("MIDDLENAME"));
						user.setLastName(rs.getString("LASTNAME"));
						user.setOrganization(rs.getString("ORGANIZATION"));
						user.setEmailId(rs.getString("EMAILID"));
						user.setLoginId(rs.getString("LOGINID"));
						user.setPassword(rs.getString("PASSWORD"));
						user.setPasswordHint(rs.getString("PASSWORDHINT"));
						user.setPasswordHintAnswer(rs
								.getString("PASSWORDHINTANS"));
						user.setSapId(rs.getString("SAPID"));
						user.setIataNumber(rs.getString("IATANUMBER"));
						user.setAllowABEAccess(rs.getString("GROUPS"));
					} catch (SQLException sqlex) {
					}

					return user;
				} // End of mapRow
			}; // End of ParameterizedRowMapper for user
			// Query user details
			user = this.getSimpleJdbcTemplate().queryForObject(authUserSql,
					mapper, user.getLoginId(), user.getPassword());

			// Retrieve user group details
			String userGroupSql = "select ug.groupid, um.username groupname from UserGroup ug, UserMaster um "
					+ " where ug.groupid = um.userid and ug.userid=?";

			ParameterizedRowMapper<UserGroup> userGroupMapper = new ParameterizedRowMapper<UserGroup>() {
				public UserGroup mapRow(ResultSet rs, int rowNum) {
					UserGroup userGroup = null;
					try {
						userGroup = new UserGroup();
						userGroup.setGroupId(rs.getInt("GROUPID"));
						userGroup.setGroupName(rs.getString("GROUPNAME"));
					} catch (SQLException sqlex) {
					}

					return userGroup;
				} // End of mapRow
			}; // End of ParameterizedRowMapper for user group
			// Query user group details
			UserGroup userGroup = this.getSimpleJdbcTemplate().queryForObject(
					userGroupSql, userGroupMapper, user.getUserId());

			switch (userGroup.getGroupId()) {
				case USERTYPE_TRAVELAGENT:
					user.setUserType(UserType.TRAVEL_AGENT);
					break;
				case USERTYPE_RESERVATIONAGENT:
					user.setUserType(UserType.RESERVATION_AGENT);
					break;
				case USERTYPE_ADMINISTRATOR:
					user.setUserType(UserType.ADMINISTRATOR);
					break;
				case USERTYPE_SKEDCDESK:
					user.setUserType(UserType.SKED_DESK);
					break;
			}
			//Set user group
			user.setUserGroup(userGroup);
			
			// If the User is travel agent, check whether travel agent have access to ABE
			if(user.getUserType().isTravelAgent() && !"Y".equals(user.getAllowABEAccess())) {
				ABEBusinessError businessError = new ABEBusinessError();
				businessError.setErrorCode("UNAUTHORIZED_ACCESS");
				businessError.setErrorDescription(this.getMessageSource()
						.getMessage("UNAUTHORIZED_ACCESS", null, null));
				userResponse.saveBusinessError(businessError);				
			} else {
				// Set user details to user response
				userResponse.setUser(user);				
			}			
		} catch (EmptyResultDataAccessException erdaex) {
			// Invalid userid/password, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_USER_PASSWORD");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_USER_PASSWORD", null, null));
			userResponse.saveBusinessError(businessError);
		}
		return userResponse;
	}

	/**
	 * Method for changing user password
	 * 
	 * @param user
	 * @return Response object with updated user details
	 * 
	 * @see
	 * @since
	 */
	
	public AuthenticateUserResponse changePassword(User user) {
		if (user == null) {
			ABESystemError systemError = new ABESystemError(
					"INVALID_USER_DETAILS", getMessageSource().getMessage(
							"INVALID_USER_DETAILS", null, null));
			throw new ABESystemException(systemError, ABETier.DATA, "");
		}
		AuthenticateUserResponse userResponse = new AuthenticateUserResponse();
		if (user.getPassword() == null || "".equals(user.getPassword().trim())) {
			// Incorrect old password, return to presentation with error message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INCORRECT_OLD_PASSWORD");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INCORRECT_OLD_PASSWORD", null, null));
			userResponse.saveBusinessError(businessError);
			return userResponse;
		}
		if (user.getNewPassword() == null
				|| "".equals(user.getNewPassword().trim())) {
			// Empty new password, return to presentation with error message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("EMPTY_NEW_PASSWORD");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("EMPTY_NEW_PASSWORD", null, null));
			userResponse.saveBusinessError(businessError);
			return userResponse;
		}

		String validPasswordSql = "select count(*) from UserDetails where loginid=? and password=?";

		int rowCnt = this.getSimpleJdbcTemplate().queryForInt(validPasswordSql,
				user.getLoginId(), user.getPassword());
		if (rowCnt == 0) {
			// Incorrect old password, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INCORRECT_OLD_PASSWORD");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INCORRECT_OLD_PASSWORD", null, null));
			userResponse.saveBusinessError(businessError);
			return userResponse;
		}

		String updatePasswordSql = "update UserDetails set password = ? where loginid = ? ";
		this.getSimpleJdbcTemplate().update(updatePasswordSql,
				user.getNewPassword(), user.getLoginId());
		// Update password, empty passwords in object
		user.setPassword(user.getNewPassword());
		user.setNewPassword("");
		userResponse.setUser(user);
		ABEInfoMessage infoMessage = new ABEInfoMessage();
		infoMessage.setErrorCode("PASSWORD_CHANGED_SUCCESSFULLY");
		infoMessage.setErrorDescription(this.getMessageSource()
				.getMessage("PASSWORD_CHANGED_SUCCESSFULLY", null, null));
		userResponse.saveInfoMessage(infoMessage);
		return userResponse;
	}
}