package com.study.demo.tddstudy.domain.post.repository;

import com.study.demo.tddstudy.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
