/*
 * Copyright 1995-2014 Caplin Systems Ltd
 */
package com.github.bodrul2112.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.bodrul2112.rest.pojos.SimplePojo;
 
@Path("/a")
public class ExampleSvc {
	
 @GET
 @Path("/b")
 @Produces(MediaType.APPLICATION_JSON)
 public Object getB() 
 {
	 return new SimplePojo();
 }
 
 @GET
 @Path("/c")
 @Produces(MediaType.APPLICATION_JSON)
 public Object getC() 
 {
	 Map<String,Object> result = new HashMap<String,Object>();
	 Map<String,String> nestedResult = new HashMap<String,String>();
	 result.put("a", nestedResult);
	 nestedResult.put("inner key", "inner val");
	 
	 return result;
 }
 
// @POST
// @Path("/postEmployee")
// public void postEmployee(Employee employee) {
//  System.out.println("Output json server .... \n");
//  System.out.println(employee);
// } 
 
 
} 