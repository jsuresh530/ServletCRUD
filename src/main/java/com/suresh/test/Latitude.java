package com.suresh.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Latitude {

	public static void main(String[] args) throws Exception
	  {
	    /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Please enter a location:");
	    String postcode=reader.readLine();*/
	    //String latLongs[] = getLatLongPositions("38119");
	    //System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
	    
	    //findLatitude("2286 N Germantown Pkwy, Cordova, TN 38016, USA");
	    //findLongitude("2286 N Germantown Pkwy, Cordova, TN 38016, USA");
	    
	    String latLongs[] = getLatLongPositions("2286 N Germantown Pkwy, Cordova, TN 38016, USA");
	    System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
	  }
	  
	  public static String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    System.out.println("Respose code "+responseCode);
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else if(status.equals("OVER_QUERY_LIMIT"))
		  {
		      Thread.sleep(1000);
		      return getLatLongPositions(address);
		  }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }
	  
	  public static String findLatitude(String zipcode)
	  {
		  String latitude = null;
		  int responseCode =0;
		  try {
			  String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(zipcode, "UTF-8") + "&sensor=true";
			  
			  System.out.println(api);
			  URL url = new URL(api);
			  HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			  httpConnection.connect();
			  responseCode = httpConnection.getResponseCode();
			  if(responseCode == 200)
			  {
				  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				  Document document = builder.parse(httpConnection.getInputStream());
				  XPathFactory xPathFactory = XPathFactory.newInstance();
				  XPath xpath = xPathFactory.newXPath();
				  XPathExpression expr = xpath.compile("/GeocodeResponse/status");
				  String status = (String)expr.evaluate(document, XPathConstants.STRING);
				  
				  if(status.equals("OK"))
				  {
					  expr = xpath.compile("//geometry/location/lat");
					  latitude = (String)expr.evaluate(document, XPathConstants.STRING);
				  }
				  else if(status.equals("OVER_QUERY_LIMIT"))
				  {
				      Thread.sleep(1000);
				      return findLatitude(zipcode);
				  }
				  
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  System.out.println(" Latitude is: "+latitude);
		  return latitude;
	  }
	  
	  public static String findLongitude(String zipcode)
	  {
		  String longitude = null;
		  int responseCode =0;
		  try {
			  String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(zipcode, "UTF-8") + "&sensor=true";
			  URL url = new URL(api);
			  HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			  httpConnection.connect();
			  responseCode = httpConnection.getResponseCode();
			  
			  if(responseCode == 200)
			  {
				  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				  Document document = builder.parse(httpConnection.getInputStream());
				  XPathFactory xPathFactory = XPathFactory.newInstance();
				  XPath xpath = xPathFactory.newXPath();
				  XPathExpression expr = xpath.compile("/GeocodeResponse/status");
				  String status = (String)expr.evaluate(document, XPathConstants.STRING);
				  if(status.equals("OK"))
				  {
					  expr = xpath.compile("//geometry/location/lng");
					  longitude = (String)expr.evaluate(document, XPathConstants.STRING);
				  }
				  else if(status.equals("OVER_QUERY_LIMIT"))
				  {
				      Thread.sleep(1000);
				      return findLongitude(zipcode);
				  }
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  System.out.println(" Longitude is: "+longitude);
		  return longitude;
	  }
}
