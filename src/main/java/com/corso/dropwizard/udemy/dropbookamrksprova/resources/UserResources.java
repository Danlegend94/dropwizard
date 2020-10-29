package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.impl.UserDaoServiceImpl;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;


@Path("/user")
public class UserResources {

	
	/* @UnitOfWork -> annotazione che gestisce la richiesta di accesso di un metodo al db. Questa annotazione
	 * aprirà automaticamente una sessione, inizierà una transazione, chiamerà il metodo  al suo interno, eseguirà
	 * il commit della transazione e chiuderà la sessione. Se viene generata un'eccezione la transazione viene 
	 * annullata.
	 */
	
	public UserResources() {}
	
	private UserDaoServiceImpl userDao;
	
	public UserResources(UserDaoServiceImpl userDao) {
		this.userDao = userDao;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("authentication")
	@UnitOfWork 
	public User authentication(@Auth User user) {
		return user;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@UnitOfWork
	public User save(User user) {
		return userDao.save(user);
	}
	
	@GET
	@UnitOfWork
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	//FUNZIONA anche se da 500
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@UnitOfWork 
	public User update(@Auth User user, User updateUser) {
		return userDao.update(user, updateUser);
	}
	
	//ERRORE PER ELIMINAZIONE IN CASCATA DA VERIFICARE
	@DELETE
	@UnitOfWork
	public void delete(@Auth User user) {
		userDao.delete(user.getId());
	}
	
}
