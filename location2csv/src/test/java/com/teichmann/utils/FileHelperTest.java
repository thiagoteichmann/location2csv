package com.teichmann.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.teichmann.helper.FileHelper;
import com.teichmann.vo.GeoPosition;
import com.teichmann.vo.Location;

public class FileHelperTest {

	private FileHelper writer =new FileHelper();;
	private final String key = "test";
	
	@After
	public void deleteFile(){
		final File file = new File(writer.getFileNameForKey(key));
		System.out.println("file deleted: "+ file.delete());
	}
	
	@Test()
	public void testWriteCSVWithNull() throws IOException {

		final List<Location> locations= null;
		writer.writeToCSV(key, locations);
		
		File file = new File(writer.getFileNameForKey(key));
		Assert.assertFalse(file.exists());
		

	}
	
	@Test()
	public void testWriteCSVWithEmptyList() throws IOException {

		final List<Location> locations= new ArrayList<Location>();
		writer.writeToCSV(key, locations);
		
		final FileReader fileReader = new FileReader(writer.getFileNameForKey(key));
		final BufferedReader reader = new BufferedReader(fileReader);
		
		Assert.assertEquals("_id, name, type, latitude, longitude", reader.readLine());
		Assert.assertNull(reader.readLine()); //no more lines
		
		reader.close();

	}
	
	
	@Test()
	public void testWriteCSVWithLocationWithCommas() throws IOException {
		

		final GeoPosition geo = new GeoPosition();
		geo.setLatitude(1234.232);
		geo.setLongitude(12222.21112);
		
		final Location a = new Location();
		a.setId("123");
		a.setName("Bla,Bla");
		a.setType("airport");
		a.setGeoPosition(geo);
		
		final List<Location> locations= new ArrayList<Location>();
		locations.add(a);
		
		writer.writeToCSV(key,locations);
		
		final FileReader fileReader = new FileReader(writer.getFileNameForKey(key));
		final BufferedReader reader = new BufferedReader(fileReader);
		
		Assert.assertEquals("_id, name, type, latitude, longitude", reader.readLine());
		Assert.assertEquals("123,\"Bla,Bla\",airport,1234.232,12222.21112", reader.readLine());
		
		reader.close();
		
	}
	
	
	@Test()
	public void testWriteCSVWithOneLocation() throws IOException {

		final GeoPosition geo = new GeoPosition();
		geo.setLatitude(1234.232);
		geo.setLongitude(12222.21112);
		
		final Location a = new Location();
		a.setId("123");
		a.setName("Munich");
		a.setType("City");
		a.setGeoPosition(geo);
		
		final List<Location> locations= new ArrayList<Location>();
		locations.add(a);
		
		writer.writeToCSV(key,locations);
		
		final FileReader fileReader = new FileReader(writer.getFileNameForKey(key));
		final BufferedReader reader = new BufferedReader(fileReader);
		
		Assert.assertEquals("_id, name, type, latitude, longitude", reader.readLine());
		Assert.assertEquals("123,\"Munich\",City,1234.232,12222.21112", reader.readLine());
		
		reader.close();
		
	}
	
}
