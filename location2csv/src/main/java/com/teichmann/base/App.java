package com.teichmann.base;

public class App {

	public static void main(String[] args) {

		if (null == args || args.length != 1) {
			System.out.println("Usage: java -jar location2csv-jar-with-dependencies.jar <City name>");
		} else {
			final String cityName = args[0];

			try {
				ProcessorFacade.processRequest(cityName);
			} catch (Exception e) {
				System.out.println("An error ocurred.");
			}

		}

	}

}
