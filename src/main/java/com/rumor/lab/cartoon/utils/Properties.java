package com.rumor.lab.cartoon.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${spring.web.resources.static-locations}")
    public static String staticResourceLocations;
}
