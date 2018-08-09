package com.springboot.seed.sample.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/sample")
public class SampleProfileController {

    private final static Logger log = LoggerFactory.getLogger(SampleProfileController.class);

    @Autowired
    private Environment env;

    @GetMapping("/profile")
    public String getProfile() {
        log.debug("Active Profiles : {}", Arrays.toString(env.getActiveProfiles()));
        return Arrays.toString(env.getActiveProfiles()) + env.getProperty("application.property.hello");
    }
}
