package com.teichmann.http;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import com.teichmann.helper.CityServiceHelper;



public class HTTPHelperTest {


	
	@Test(expected=BadRequestException.class)
	public void testLocationBlank() throws Exception{
		final String cityName = "";
		
		CityServiceHelper.getCityByName(cityName);
	}
	
	@Test
	public void testLocationReturns() throws Exception{
		final String cityName = "Frankfurt";
		
		final Response resp  = CityServiceHelper.getCityByName(cityName);

		Assert.assertTrue(resp.getStatus() == 200);
	}
	
	
}
