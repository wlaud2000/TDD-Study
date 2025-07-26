package com.study.demo.tddstudy.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PostRequestDTO {

    private String title;
    private String content;
}

