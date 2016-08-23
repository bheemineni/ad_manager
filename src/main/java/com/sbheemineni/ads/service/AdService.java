/**
 * 
 */
package com.sbheemineni.ads.service;

import java.util.List;

import com.sbheemineni.ads.controller.Ad;

/**
 * @author SrinivasBheemineni
 * 
 * Service for CRUD operations on Ads. 
 *
 */
public interface AdService {
	
	List<Ad> retrieveAllAds();
	
	void createAd(Ad ad);
	
	void updateAd(Ad ad);

	Ad retrieveAd(String ad);

	void deleteAd(String partner_id);

}
