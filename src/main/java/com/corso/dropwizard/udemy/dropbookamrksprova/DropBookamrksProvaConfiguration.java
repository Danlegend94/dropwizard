package com.corso.dropwizard.udemy.dropbookamrksprova;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

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
	 * In questa classe viene inoltre creata la connessione al dataBase. I dati vengono prelevati dal file yml sotto la voce database
	 */
	
	@NotNull
	@Valid
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	
	@JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
    
	@NotEmpty
	private String password;

	//@JsonProperty
	public String getPassword() {
		return password;
	}
	
	
}
