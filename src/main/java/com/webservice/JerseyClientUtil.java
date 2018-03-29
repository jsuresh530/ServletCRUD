package com.webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientUtil
{
	public String sendPost(StringBuffer requestString, String url, String reqTypeHeader) {
		
		String output = "";
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(url);
						
			ClientResponse response = webResource.type(reqTypeHeader).post(ClientResponse.class, requestString.toString());
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			output = response.getEntity(String.class);
			if (response != null) {
				System.out.println("<<<<<<<<<< JSON RESPONSE ::"+output);
			}
		} catch (Exception e) {
		}
		return output;
	}
}
