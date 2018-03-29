package com.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bo.RequestBO;
import com.bo.ResponseBO;
import com.google.gson.Gson;

@Path("/webservice")
@Produces("application/json")
public class WebController
{
	//Content-Type application/json
	public static final String AUTHENTICATION_HEADER = "Apikey";
    private Gson                                gson                          = new Gson();
	
	@POST
    @Path("/test")
    @Produces("application/json")
    @Consumes("application/json")
    public Response test(RequestBO requestBO, @HeaderParam(AUTHENTICATION_HEADER) String headerParams)
    {
		LoggingUtil.writeApplicationLogs("Response in Json: " + gson.toJson(requestBO), WebController.class);
        ResponseBO bo = new ResponseBO();
        bo.setResponseCode(200);
        bo.setResponseMsg("success");
        bo.setEmailAddress("jsuresh530@gmail.com");
        LoggingUtil.writeApplicationLogs("Response in Json: " + gson.toJson(bo), WebController.class);
        
        //return Response.status(responseBO1.getResponseCode()).entity(responseBO1).build();
        return  Response.status(bo.getResponseCode()).entity(bo).build();
    }
}
