package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello") //utilizzato come request mapping
public class HelloResources {
	
	/* HTTP REQUEST
	 * @GET
	 * @POST
	 * @DELETE
	 * @PUT
	 */
	
	@GET
	@Produces(MediaType.TEXT_PLAIN) //indica cosa il metodo sta producendo come risposta
	public String greet() {
		return "Hello world";
	}

}
