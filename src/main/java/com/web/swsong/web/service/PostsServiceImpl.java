package com.web.swsong.web.service;

import com.web.swsong.web.domain.posts.Posts;
import com.web.swsong.web.domain.posts.PostsRepository;
import com.web.swsong.web.dto.PostsListResDto;
import com.web.swsong.web.dto.PostsReqSaveDto;
import com.web.swsong.web.dto.PostsResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsServiceImpl implements PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PostsListResDto> findAllDesc() {
        return null;
//        return postsRepository.findAllDesc().stream()
//                .map(PostsListResDto::new)
//                .collect(Collectors.toList());
    }

    @Override
    public PostsResDto get(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        return new PostsResDto(posts);
    }

    @Transactional
    @Override
    public Long update(Long id, PostsReqSaveDto postsReqSaveDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        posts.update(postsReqSaveDto);
        return posts.getId();
    }

    @Override
    public Long save(PostsReqSaveDto postsReqSave) {
        return postsRepository.save(postsReqSave.toEntity()).getId();
    }

    @Override
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        postsRepository.delete(id);
    }
}
