package com.corso.dropwizard.udemy.dropbookamrksprova;

import com.corso.dropwizard.udemy.dropbookamrksprova.auth.HelloAuthentication;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.UserDao;
import com.corso.dropwizard.udemy.dropbookamrksprova.resources.HelloResources;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

//TODO RIVEDI LEZIONE 50
public class DropBookamrksProvaApplication extends Application<DropBookamrksProvaConfiguration> {
	
	//TODO rivedi questa parte
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

    @Override
    public void run(final DropBookamrksProvaConfiguration configuration,
                    final Environment environment) {
    	final UserDao userDao = new UserDao(hibernateBundle.getSessionFactory());
    	environment.jersey().register(new HelloResources()); //permette l'accesso al metodo HelloResources tramite chiamata http
    	environment.jersey().register(AuthFactory.binder(new BasicAuthFactory<>(new HelloAuthentication(userDao), "SECURITY", User.class)));
    	
    
    }

}
