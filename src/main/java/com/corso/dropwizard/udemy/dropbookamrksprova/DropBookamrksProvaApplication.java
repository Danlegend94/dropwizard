package com.corso.dropwizard.udemy.dropbookamrksprova;

import com.corso.dropwizard.udemy.dropbookamrksprova.auth.UserAuthentication;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.UserDao;
import com.corso.dropwizard.udemy.dropbookamrksprova.resources.UserResources;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropBookamrksProvaApplication extends Application<DropBookamrksProvaConfiguration> {
	
	final HibernateBundle<DropBookamrksProvaConfiguration> hibernateBundle = 
			new HibernateBundle<DropBookamrksProvaConfiguration>(User.class) {

				@Override
				public DataSourceFactory getDataSourceFactory(DropBookamrksProvaConfiguration configuration) {
					return configuration.getDataSourceFactory();
				}
	};

    public static void main(final String[] args) throws Exception {
        new DropBookamrksProvaApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropBookamrksProva";
    }

    
    /*Metodo dove avviene l'inizializzazione degli elementi del progetto.*/
    @Override
    public void initialize(final Bootstrap<DropBookamrksProvaConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(
                new MigrationsBundle<DropBookamrksProvaConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(
            		DropBookamrksProvaConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }
    
    /*Environment è un oggetto che contiene tutte le risorse, le servlet, i filtri e i controlli di integrità,
     *provider Jersey, gli oggetti gestiti , le attività e le proprietà Jersey forniti dall'applicazione
     * 
     * All'interno del metodo run tutte le istanze
     */
    @Override
    public void run(final DropBookamrksProvaConfiguration configuration,
                    final Environment environment) {
    	final UserDao userDao = new UserDao(hibernateBundle.getSessionFactory());
    	environment.jersey().register(new UserResources(userDao));
    	environment.jersey().register(AuthFactory.binder(new BasicAuthFactory<>(new UserAuthentication(userDao), "SECURITY", User.class)));
    }

}
