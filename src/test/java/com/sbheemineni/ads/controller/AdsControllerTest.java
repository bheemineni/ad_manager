/**
 * 
 */
package com.sbheemineni.ads.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import com.sbheemineni.ads.service.AdService;


/**
 * @author SrinivasBheemineni
 * 
 * JUnit test class for AdsController
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AdsControllerTest {

	@Mock
	private AdService adService;

	@InjectMocks 
	private AdsController adsController;
	
	private List<Ad> mockAds;
	
	private Ad mockAd;
	
	@Mock
	private BindingResult bindingResult;
	
	@Before
	public void setUp() {
		adsController = new AdsController();
		mockAds = createMockAds();
		mockAd = createMockAd();
		ReflectionTestUtils.setField(adsController, "adService", adService);
	}
	
	@After
	public void destroy() {
		adsController = null;
	}
	
	private List<Ad> createMockAds() {
		mockAds = new ArrayList<Ad>();
		Ad mockAd = createMockAd();
		mockAds.add(mockAd);
		return mockAds;
	}

	private Ad createMockAd() {
		Ad mockAd = new Ad();
		mockAd.setPartner_id("abc");
		mockAd.setDuration(60);
		mockAd.setAd_content("Try our product!");
		return mockAd;
	}
	
	@Test
	public void retrieveAllAds() {
		
		when(adService.retrieveAllAds()).thenReturn(mockAds);

		List<Ad> ads = adsController.retrieveAllAds();

		Assert.assertEquals(1, ads.size());
		Assert.assertEquals("abc", ads.get(0).getPartner_id());
	}
	
	@Test
	public void retrieveAd() {
		
		when(adService.retrieveAd("abc")).thenReturn(mockAd);

		Ad ad = adsController.retrieveAd("abc");

		Assert.assertNotNull(ad);
		Assert.assertEquals("abc", ad.getPartner_id());
		Assert.assertEquals(new Integer(60), ad.getDuration());
		Assert.assertEquals("Try our product!", ad.getAd_content());
	}
	
	@Test
	public void createAd() {
        doNothing().when(adService).createAd(mockAd);
		when(bindingResult.hasErrors()).thenReturn(false);

		adsController.createAd(mockAd, bindingResult);
		
		verify(adService, times(1)).createAd(mockAd);
	}
	
	@Test
	public void deleteAd() {
        doNothing().when(adService).deleteAd("abc");

		adsController.deleteAd("abc");
		
		verify(adService, times(1)).deleteAd("abc");
	}

}
