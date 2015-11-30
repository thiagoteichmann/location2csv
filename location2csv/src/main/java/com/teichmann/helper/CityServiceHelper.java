package com.teichmann.helper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.teichmann.base.AppConstants;

public class CityServiceHelper {

	public static Response getCityByName(final String cityName) throws BadRequestException {

		final String endpointAddress = String.format(AppConstants.API_URL, cityName);
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target(endpointAddress);
		final Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();

		
			if (Status.OK.getStatusCode() != response.getStatus()){
				throw new BadRequestException();
			}
		
		return response;
	}

}
