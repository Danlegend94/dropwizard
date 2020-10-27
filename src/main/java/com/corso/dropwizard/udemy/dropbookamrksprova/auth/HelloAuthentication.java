package com.corso.dropwizard.udemy.dropbookamrksprova.auth;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.google.common.base.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class HelloAuthentication implements Authenticator<BasicCredentials, User>{

	/* BasicCredentials contiene username e password che vengono passati con la chiamata http
	 * Se le credenziali sono corrette restituirà un optional altrimenti restituira un absent o
	 * un errore per credenziali errate
	 * 
	 * Optional.absent() restituisce un 401 Unauthorized con messaggio 
	 * Credentials are required to access this resource
	 */
	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if("password".equals(credentials.getPassword())) {
			return Optional.of((new User()));
		}
		
		return Optional.absent();
	}

}
