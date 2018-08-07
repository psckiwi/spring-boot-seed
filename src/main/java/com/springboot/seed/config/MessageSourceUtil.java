package com.springboot.seed.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class MessageSourceUtil {

    private final static Logger log = LoggerFactory.getLogger(MessageSourceUtil.class);

    @Autowired
    private Environment env;

    @Autowired
    private MessageSource messageSource;

    private Locale locale;

    @PostConstruct
    public void initData() {
        locale = new Locale(env.getProperty("application.language"));
    }

    public String getMessage(String code) {
        return messageSource.getMessage( code, null, "no message", locale);
    }

    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage( code, args, "no message", locale);
    }

    public String getMessage(String code, Object[] args, String defaultMessage) {
        return messageSource.getMessage( code, args, defaultMessage, locale);
    }
}
