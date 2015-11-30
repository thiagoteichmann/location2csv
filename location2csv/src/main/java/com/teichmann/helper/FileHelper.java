package com.teichmann.helper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringJoiner;

import com.teichmann.base.AppConstants;
import com.teichmann.vo.GeoPosition;
import com.teichmann.vo.Location;

public class FileHelper {

	public String getFileNameForKey(final String key) {
		return String.format(AppConstants.CSV_FILE, key);
	}

	public void writeToCSV(final String key, final List<Location> locations) throws FileNotFoundException {

		PrintWriter writer = null;
		try {

			if (locations != null) {
				writer = new PrintWriter(this.getFileNameForKey(key));
				writer.println(AppConstants.HEADER);

				for (Location loc : locations) {
					final GeoPosition geo = loc.getGeoPosition();

					final StringJoiner joiner = new StringJoiner(","); //Java 8 only, but's handy. ;)
					joiner.add(loc.getId());
					joiner.add(loc.getEscapedName());
					joiner.add(loc.getType());
					joiner.add(String.valueOf(geo.getLatitude()));
					joiner.add(String.valueOf(geo.getLongitude()));
					writer.println(joiner.toString());
				}
			}
		} finally {
			if (writer != null){
				writer.flush();
				writer.close();
			}
		}
	}

}
