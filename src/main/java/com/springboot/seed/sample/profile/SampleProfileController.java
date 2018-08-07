package com.springboot.seed.sample.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/sample")
public class SampleProfileController {

    @Autowired
    private Environment env;

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.toString(env.getActiveProfiles()) + env.getProperty("application.property.hello");
    }
}
