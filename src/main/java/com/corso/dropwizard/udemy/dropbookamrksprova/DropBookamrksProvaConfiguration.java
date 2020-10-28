package com.corso.dropwizard.udemy.dropbookamrksprova;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class DropBookamrksProvaConfiguration extends Configuration {
	
	/* In questa classe avviene la lettura del file di properties e di cio che contiene.
	 * Il file di properties viene passato come argomento nel run dell'applicazione
	 * 
	 * In questo caso vengono passati i valri per creare la connessione con il database
	 */
	
	@NotNull
	@Valid
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	
	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
		this.dataSourceFactory = dataSourceFactory;
	}

	@JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
}
