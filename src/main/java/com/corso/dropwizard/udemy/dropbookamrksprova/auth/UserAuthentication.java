package com.corso.dropwizard.udemy.dropbookamrksprova.auth;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.UserDao;
import com.google.common.base.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import lombok.Data;

@Data
public class UserAuthentication implements Authenticator<BasicCredentials, User>{

	/* BasicCredentials contiene username e password che vengono passati con la chiamata http
	 * Se le credenziali sono corrette restituirà un optional altrimenti restituira un absent o
	 * un errore per credenziali errate
	 * 
	 * Optional.absent() restituisce un 401 Unauthorized con messaggio 
	 * Credentials are required to access this resource
	 * 
	 * il metodo authenticate viene costruito in base ai parametri passati ad 
	 * Authenticator<BasicCredentials, User>. Quindi se per esempio creassi una classe Animale
	 * il metodo Optional<User> authenticate(BasicCredentials credentials) diventerebbe 
	 * Optional<Animale> authenticate(BasicCredentials credentials)
	 */
	
	
		//private String password;
		/*
		 * @Override public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		 * if(password.equals(credentials.getPassword())) 
		 * 		{ 
		 * 			return Optional.of((new User())); 
		 * 		}
		 * 
		 *   return Optional.absent(); 
		 * }
		 */
	
	private UserDao userDao;
	
	public UserAuthentication() {}
	
	public UserAuthentication(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		return userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
	}
	
	

}
