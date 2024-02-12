package com.yg.boardserver.service;


import com.yg.boardserver.dto.PostDTO;
import com.yg.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);
    List<PostDTO> getPostByTag(String tagName);
}