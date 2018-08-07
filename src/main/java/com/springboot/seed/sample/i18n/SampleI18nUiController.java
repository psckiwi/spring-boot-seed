package com.springboot.seed.sample.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleI18nUiController {

    private final static Logger log = LoggerFactory.getLogger(SampleI18nUiController.class);

    @GetMapping("/i18n-ui")
    public String getMessageSource() {
        return "i18n.html";
    }
}
