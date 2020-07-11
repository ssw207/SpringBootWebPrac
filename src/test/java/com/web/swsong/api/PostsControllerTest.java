package com.web.swsong.api;

import com.web.swsong.web.domain.PostsService;
import com.web.swsong.web.domain.posts.Posts;
import com.web.swsong.web.dto.PostsListResDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    PostsService postsService;

    @Test
    public void post리스트가_조회된다() {
        //given
        String title ="titile";
        String content = "content";

        //when
//        List<PostsListResDto> posts = postsService.
//        assertThat(posts.size()).isNotEqualTo(0);
    }
}
