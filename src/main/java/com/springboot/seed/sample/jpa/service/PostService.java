package com.springboot.seed.sample.jpa.service;

import com.springboot.seed.sample.jpa.domain.Post;
import com.springboot.seed.sample.jpa.dto.PostDto;
import com.springboot.seed.sample.jpa.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostRepository postsRepository;

    public Post save(PostDto postDto) {
        return postsRepository.save(Post.builder()
            .title(postDto.getTitle())
            .content(postDto.getContent())
            .author(postDto.getAuthor())
            .build());
    }

    public List<Post> findAll() {
        return postsRepository.findAll();
    }
}
