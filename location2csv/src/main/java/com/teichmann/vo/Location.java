package com.teichmann.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a simplification of the structure of the JSON for testing/application
 * purposes.
 * 
 * @author thiago
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Location {

	@JsonProperty("_id")
	private String id;
	
	private String name;

	private String fullName;
	
	@JsonProperty("iata_airport_code")
	private String iataAirportCode;
	
	private String location;
	
	private String key;

	private String type;
	
	private String country;
	
	@JsonProperty("geo_position")
	private GeoPosition geoPosition;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	};
	
	public String getEscapedName(){
		return "\""+ this.getName()+"\"";
	}

}
