/**
 * 
 */
package com.sbheemineni.ads.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author SrinivasBheemineni
 * 
 * The content of an Ad.
 *
 */
public class Ad {
	
	/**
	 * unique string representing partner
	 */
	@NotEmpty
	private String partner_id;
	
	
	/**
	 * campaign duration in seconds from now
	 */
	@NotNull
	private Integer duration;
	
	
	/**
	 * content to be displayed as an ad
	 */
	@NotEmpty
	private String ad_content;

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	
}
