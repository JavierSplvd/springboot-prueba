package com.sbj.controller;

import com.sbj.controller.CourseController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(CourseController.class);
    }
}
