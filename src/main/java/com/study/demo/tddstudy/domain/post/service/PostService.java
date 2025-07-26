package com.study.demo.tddstudy.domain.post.service;

import com.study.demo.tddstudy.domain.post.dto.PostRequestDTO;
import com.study.demo.tddstudy.domain.post.entity.PostEntity;
import com.study.demo.tddstudy.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    public final PostRepository postRepository;

    public Long create(PostRequestDTO dto) {

        PostEntity postEntity = PostEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        if (dto.getTitle().isBlank()) {
            throw new IllegalArgumentException("빈값 금지");
        }

        return postRepository.save(postEntity).getId();
    }

}
