package com.web.swsong.domain;

import com.web.swsong.web.domain.posts.Posts;
import com.web.swsong.web.domain.posts.PostsRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void post가_생성_조회된다() {
        //givne
        String title = "title";
        String content = "content";
        String author = "author";
        Posts entity = Posts.builder().author(author).title(title).content(content).build();

        //when
        Posts savedPost = postsRepository.save(entity);
        Posts resPost = postsRepository.findById(savedPost.getId()).orElseThrow(() -> new IllegalArgumentException("post가 조회되지 않습니다."));

        //then
        assertThat(resPost.getContent()).isEqualTo(content);
    }
    
    @Test
    public void post의_생성_수정시간이_자동저장된다() {
        //givne
        String title = "title";
        String content = "content";
        String author = "author";
        Posts entity = Posts.builder().author(author).title(title).content(content).build();
        LocalDateTime now = LocalDateTime.of(2020,1,1,0,0);

        //when
        Posts savedPost = postsRepository.save(entity);
        Posts resPost = postsRepository.findById(savedPost.getId()).orElseThrow(() -> new IllegalArgumentException("post가 조회되지 않습니다."));

        //then
        log.info("생성시간 : {}, 변경시간 : {}",resPost.getCreatedDate(), resPost.getModifiedDate());

        //then
        assertThat(resPost.getCreatedDate()).isAfter(now);
        assertThat(resPost.getModifiedDate()).isAfter(now);
    }
}
