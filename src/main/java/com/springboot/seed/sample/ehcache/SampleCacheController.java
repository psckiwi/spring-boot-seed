package com.springboot.seed.sample.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleCacheController {

    private static final Logger log = LoggerFactory.getLogger(SampleCacheController.class);

    @Autowired
    private SampleCacheService sampleCacheService;

    @GetMapping("/ehcache/{id}")
    public SampleCache getCacheData(@PathVariable("id") String id) throws Exception {
        long start = System.currentTimeMillis();

        SampleCache cacheData = sampleCacheService.getSampleCache(id);

        long end = System.currentTimeMillis();

        log.debug("ID : " + id + ", Execution Time : " + (end - start) + "ms");

        return cacheData;
    }
}
