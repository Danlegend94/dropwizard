package com.corso.dropwizard.udemy.dropbookamrksprova;

import io.dropwizard.Application;
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
        // TODO: implement application
    }

}
