package com.study.demo.tddstudy.domain.post.service;

import com.study.demo.tddstudy.domain.post.dto.PostRequestDTO;
import com.study.demo.tddstudy.domain.post.entity.PostEntity;
import com.study.demo.tddstudy.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;

    @Test
    void create_테스트1() {

        // given
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .title("제목1")
                .content("내용1")
                .build();

        PostEntity saved = PostEntity.builder()
                .title("제목")
                .content("내용")
                .build();
        ReflectionTestUtils.setField(saved, "id", 1L);
        given(postRepository.save(any(PostEntity.class))).willReturn(saved);

        // when
        Long resultId = postService.create(requestDTO);

        // then
        assertInstanceOf(Long.class, resultId);
    }

    @Test
    void create_테스트2() {

        // given
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .title("제목2")
                .content("내용2")
                .build();

        PostEntity saved = PostEntity.builder()
                .title("제목")
                .content("내용")
                .build();
        ReflectionTestUtils.setField(saved, "id", 1L);
        given(postRepository.save(any(PostEntity.class))).willReturn(saved);

        // when
        postService.create(requestDTO);

        // then
        verify(postRepository).save(any(PostEntity.class));
    }

    @Test
    void create_테스트3() {

        // given
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .title("")
                .content("내용2")
                .build();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            postService.create(requestDTO);
        });
    }

}