package com.springboot.seed.sample.i18n;

import com.springboot.seed.config.MessageSourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleI18nController {

    private final static Logger log = LoggerFactory.getLogger(SampleI18nController.class);

    @Autowired
    private MessageSourceUtil messageSourceUtil;

    @GetMapping("/i18n")
    public String getMessageSource() {
        String message = messageSourceUtil.getMessage("hello");

        log.debug("greeting message : {}", message);

        return message;
    }
}
