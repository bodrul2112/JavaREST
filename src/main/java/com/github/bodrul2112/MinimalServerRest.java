/*
 * Copyright 1995-2014 Caplin Systems Ltd
 */
package com.github.bodrul2112;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
 
public class MinimalServerRest {
 
     public static void main(String[] args) throws Exception {
    	 
    	 final ResourceConfig rc = new PackagesResourceConfig("com.test.resources");
    	    final Map<String, Object> config = new HashMap<String, Object>();
    	    config.put("com.sun.jersey.api.json.POJOMappingFeature", true);
    	    rc.setPropertiesAndFeatures(config);
    	 
         ServletHolder sh = new ServletHolder(ServletContainer.class);    
         sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
         sh.setInitParameter("com.sun.jersey.config.property.packages", "com.github.bodrul2112.rest"); //Set the package where the services reside
         sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
       
         Server server = new Server(9999);
         ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
         context.addServlet(sh, "/*");
         server.start();
         server.join();      
      }
}