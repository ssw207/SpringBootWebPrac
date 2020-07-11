package com.web.swsong.web.domain.posts;

import com.web.swsong.web.domain.BaseTimeEntity;
import com.web.swsong.web.dto.PostsReqSaveDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(PostsReqSaveDto postsReqSaveDto) {
        this.title = postsReqSaveDto.getTitile();
        this.content = postsReqSaveDto.getContent();
    }
}
