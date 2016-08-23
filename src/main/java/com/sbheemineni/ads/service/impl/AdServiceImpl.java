/**
 * 
 */
package com.sbheemineni.ads.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sbheemineni.ads.controller.Ad;
import com.sbheemineni.ads.service.AdService;

/**
 * @author SrinivasBheemineni
 * 
 * Service implementation for CRUD operations on Ads. 
 * Ideally this class should call DAO classes or any back end services. But that is not in our scope right now.
 *
 */
@Service
public class AdServiceImpl implements AdService {
	
	/**
	 * Temporary storage for Ads. We can replace this with any persistent storage system.
	 */
	private Map<String, Ad> ads;
	
	@Override
	public void createAd(Ad ad) {
		if(CollectionUtils.isEmpty(ads)){
			ads = new HashMap<String, Ad>();
		}
		
		ads.put(ad.getPartner_id(), ad);
	}
	
	@Override
	public void updateAd(Ad ad) {
		if(CollectionUtils.isEmpty(ads)){
			ads = new HashMap<String, Ad>();
		}
		
		ads.put(ad.getPartner_id(), ad);
	}
	
	@Override
	public List<Ad> retrieveAllAds() {
		
		if(CollectionUtils.isEmpty(ads)) {
			return new ArrayList<Ad>();
		}
		return new ArrayList<Ad>(ads.values());
	}
	
	@Override
	public Ad retrieveAd(String partnerId) {
		Ad ad = null;
		if(!CollectionUtils.isEmpty(ads)){
			ad = ads.get(partnerId);
		}
		
		return ad;
	}

	@Override
	public void deleteAd(String partnerId) {
		
		if(!CollectionUtils.isEmpty(ads)){
			ads.remove(partnerId);
		}
	}
	
	public void setAds(Map<String, Ad> ads) {
		this.ads = ads;
	}

}
