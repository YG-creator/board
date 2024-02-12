package com.yg.boardserver.service;


import com.yg.boardserver.dto.PostDTO;
import com.yg.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getProducts(PostSearchRequest postSearchRequest);
}