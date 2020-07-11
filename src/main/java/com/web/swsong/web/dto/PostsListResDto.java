package com.web.swsong.web.dto;

import com.web.swsong.web.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class PostsListResDto {
    private String titile;
    private String content;
    private String autor;

    PostsListResDto (Posts posts) {
        this.titile = posts.getTitle();
        this.content = posts.getContent();
        this.autor = posts.getAuthor();
    }
}
