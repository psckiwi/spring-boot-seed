package com.springboot.seed.sample.jpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String content;
    private String author;
}
