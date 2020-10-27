package com.corso.dropwizard.udemy.dropbookamrksprova;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class DropBookamrksProvaConfiguration extends Configuration {
	
	/* In questa classe avviene la lettura del file di properties e di cio che contiene.
	 * Il file di properties viene passato come argomento nel run dell'applicazione
	 * 
	 * Alla stringa password verrà asseganto il valore della rispettiva variabile password
	 * nel file yml.
	 * 
	 * Una volta fatto ciò all'interno di DropBookmarksApplication l' oggetto configuration
	 * conterrà il valore di password
	 * 
	 * 
	 */
    
	@NotEmpty
	private String password;

	//@JsonProperty
	public String getPassword() {
		return password;
	}
}
