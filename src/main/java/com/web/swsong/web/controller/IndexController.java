package com.web.swsong.web.controller;

import com.web.swsong.web.domain.PostsService;
import com.web.swsong.web.dto.PostsListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public List<PostsListResDto> index() {
        return postsService.findAllDesc();
    }
}
