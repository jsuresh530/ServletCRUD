package com.suresh.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {

	public static void main(String[] args) {
		
		String url = "https://www.geeksforgeeks.org/download-web-page-using-java/";
		downloadWebPage(url);
	}

	public static void downloadWebPage(String webPage) {

		try {
			// Create URL object
			URL url = new URL(webPage);
			BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));

			// Enter filename in which you want to download
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/Download.html"));

			// read each line from stream till end
			String line;
			while ((line = readr.readLine()) != null) {
				writer.write(line);
			}

			readr.close();
			writer.close();
			System.out.println("Successfully Downloaded.");
		}// Exceptions
		catch (MalformedURLException mue) {
			System.out.println("Malformed URL Exception raised "+mue);
		} catch (IOException ie) {
			System.out.println("IOException raised "+ie);
		}
	}
}
