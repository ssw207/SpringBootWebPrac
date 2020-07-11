package com.web.swsong.web.service;

import com.web.swsong.web.dto.PostsListResDto;
import com.web.swsong.web.dto.PostsReqSaveDto;
import com.web.swsong.web.dto.PostsResDto;

import java.util.List;

public interface PostsService {
    public List<PostsListResDto> findAllDesc();
    public PostsResDto get(Long id);
    public Long update(Long id, PostsReqSaveDto postsReqSaveDto);
    public Long save(PostsReqSaveDto postsReqSave);
    public void delete(Long id);
}
