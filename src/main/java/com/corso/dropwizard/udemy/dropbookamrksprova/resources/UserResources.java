package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.UserDao;
import com.google.common.base.Optional;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/user") //utilizzato come request mapping
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
	
	public UserResources() {}
	
	private UserDao userDao;
	
	public UserResources(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("security")
	@UnitOfWork 
	public String greetSecurity(@Auth User user) {
		return "Accesso eseguito correttamente";
	}
	
	@GET
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	@GET
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("prova")
	public Optional<User> findByUsernameAndPassword(User user){
		return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	
}
