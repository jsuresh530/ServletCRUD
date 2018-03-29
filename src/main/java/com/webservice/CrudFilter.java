package com.webservice;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CrudFilter implements ContainerResponseFilter
{
	private static final Logger	logger		= LoggerFactory.getLogger(CrudFilter.class);
	
	
	@Override
	public ContainerResponse filter(ContainerRequest req, ContainerResponse contResp)
	{
		logger.info("inside method...ContainerResponse ", CrudFilter.class);
		ResponseBuilder resp = Response.fromResponse(contResp.getResponse());
		resp.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

		String reqHead = req.getHeaderValue("Access-Control-Request-Headers");

		if (null != reqHead && !reqHead.equals("")) {
			resp.header("Access-Control-Allow-Headers", reqHead);
		}

		contResp.setResponse(resp.build());
		return contResp;
	}
	
}
