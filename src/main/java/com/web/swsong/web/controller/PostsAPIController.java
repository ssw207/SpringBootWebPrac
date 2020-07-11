package com.web.swsong.web.controller;

import com.web.swsong.web.domain.PostsService;
import com.web.swsong.web.domain.posts.Posts;
import com.web.swsong.web.domain.posts.PostsRepository;
import com.web.swsong.web.dto.PostsReqSaveDto;
import com.web.swsong.web.dto.PostsResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsAPIController {
    private final PostsService postsService;

    @GetMapping("/api/v1/posts/${id}")
    public PostsResDto get(@PathParam("id") Long id) {
        return postsService.get(id);
    }

    @PostMapping("/api/v1/posts/save")
    public Long save(@RequestBody PostsReqSaveDto postsReqSaveDto) {
        return postsService.save(postsReqSaveDto);
    }

    @PutMapping("/api/vi/posts/${id}")
    public Long update(@PathParam("id") Long id, @RequestBody PostsReqSaveDto postsReqSaveDto) {
        return postsService.update(id,postsReqSaveDto);
    }

    @DeleteMapping("/api/vi/posts/${id}")
    public void delete(@PathParam("id") Long id) {
        postsService.delete(id);
    }
}
