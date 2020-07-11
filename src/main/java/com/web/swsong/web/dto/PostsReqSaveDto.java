package com.web.swsong.web.dto;

import com.web.swsong.web.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsReqSaveDto {
    private String titile;
    private String content;
    private String autor;

    public Posts toEntity () {
        return Posts.builder()
                .title(titile)
                .content(content)
                .author(autor)
                .build();
    }
}
