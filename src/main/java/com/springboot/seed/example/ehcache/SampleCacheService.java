package com.springboot.seed.example.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class SampleCacheService {

    private static final Logger log = LoggerFactory.getLogger(SampleCacheService.class);

    @Cacheable(value = "sample-cache", key = "#id")
    public SampleCache getSampleCache(String id) throws Exception {
        SampleCache cacheData = new SampleCache();
        cacheData.setId(id);
        cacheData.setCreated(ZonedDateTime.now());
        Thread.sleep(1000);

        return cacheData;
    }
}
