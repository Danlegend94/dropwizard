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
	
	/* @UnitOfWork -> annotazione che gestisce la richiesta di accesso di un metodo al db. Questa annotazione
	 * aprirà automaticamente una sessione, inizierà una transazione, chiamerà il metodo  al suo interno, eseguirà
	 * il commit della transazione e chiuderà la sessione. Se viene generata un'eccezione la transazione viene 
	 * annullata.
	 */
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("security")
	@UnitOfWork 
	public String greetSecurity(@Auth User user) {
		return "Hello world security";
	}
}
