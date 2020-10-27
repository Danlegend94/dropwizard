package com.corso.dropwizard.udemy.dropbookamrksprova;

import com.corso.dropwizard.udemy.dropbookamrksprova.auth.HelloAuthentication;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.resources.HelloResources;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropBookamrksProvaApplication extends Application<DropBookamrksProvaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookamrksProvaApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropBookamrksProva";
    }

    @Override
    public void initialize(final Bootstrap<DropBookamrksProvaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropBookamrksProvaConfiguration configuration,
                    final Environment environment) {
    	environment.jersey().register(new HelloResources()); //permette l'accesso al metodo HelloResources tramite chiamata http
    	environment.jersey().register(AuthFactory.binder(new BasicAuthFactory<>(new HelloAuthentication(configuration.getPassword()), "SECURITY", User.class)));
    }

}
