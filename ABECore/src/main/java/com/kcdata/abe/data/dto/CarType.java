/**
 * 
 * 
 */
package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * 
 * @author npanday
 *
 */
public class CarType implements ABEDto {

	private static final long serialVersionUID = 817320002240076821L;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	private Integer id;
	private String name;
		
}