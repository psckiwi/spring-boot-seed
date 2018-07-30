package com.springboot.seed.example.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/example")
public class ProfileController {

    @Autowired
    private Environment env;

    @RequestMapping("/profile")
    public String getProfile() {
        return Arrays.toString(env.getActiveProfiles()) + env.getProperty("application.property.hello");
    }
}
