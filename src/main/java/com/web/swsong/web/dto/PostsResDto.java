package com.web.swsong.web.dto;

import com.web.swsong.web.domain.posts.Posts;

public class PostsResDto {
    private String titile;
    private String content;
    private String autor;

    PostsResDto (Posts posts) {
        this.titile = posts.getTitle();
        this.content = posts.getContent();
        this.autor = posts.getAuthor();
    }
}
