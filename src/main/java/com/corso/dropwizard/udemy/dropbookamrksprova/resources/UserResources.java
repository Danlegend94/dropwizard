package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/hello") //utilizzato come request mapping
public class UserResources {
	
	/* HTTP REQUEST
	 * @GET
	 * @POST
	 * @DELETE
	 * @PUT
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("security")
	@UnitOfWork //TODO VEDERE QUESTA ANNOTATION
	public String greetSecurity(@Auth User user) {
		return "Hello world security";
	}
}
