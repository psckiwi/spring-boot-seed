package com.springboot.seed.example.ehcache;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class SampleCache {
    private String id;
    private ZonedDateTime created;
}