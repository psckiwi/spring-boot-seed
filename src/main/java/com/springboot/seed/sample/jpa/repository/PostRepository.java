package com.springboot.seed.sample.jpa.repository;

import com.springboot.seed.sample.jpa.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
