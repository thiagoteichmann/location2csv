package com.teichmann.base;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teichmann.helper.FileHelper;
import com.teichmann.helper.CityServiceHelper;
import com.teichmann.vo.Location;

public class ProcessorFacade {

	public static void processRequest(String cityName) throws Exception {
		try {
			final FileHelper fileHelper = new FileHelper();
			
			final Response response = CityServiceHelper.getCityByName(cityName);
			final List<Location> locations = convertToList(response);
			
			if (locations != null && locations.size()>0){
				fileHelper.writeToCSV(cityName,locations);	
				System.out.println("Generation done. Please check " + fileHelper.getFileNameForKey(cityName));
			}
			else{
				System.out.println("No results found. Have you mispelled the name? Please try again.");
			}
		} catch (Exception e) {
			throw e;
		}
		
	}

	private static List<Location> convertToList(final Response response) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final List<Location> locations = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Location>>(){});

	    return locations;
	}

}
