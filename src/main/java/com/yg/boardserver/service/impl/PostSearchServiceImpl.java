package com.yg.boardserver.service.impl;

import com.yg.boardserver.dto.PostDTO;
import com.yg.boardserver.dto.request.PostSearchRequest;
import com.yg.boardserver.mapper.PostSearchMapper;
import com.yg.boardserver.service.PostSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostSearchServiceImpl implements PostSearchService {

    private final PostSearchMapper productSearchMapper;

    @Async
    @Cacheable(value="getProducts", key = "'getProducts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()")
    @Override
    public List<PostDTO> getProducts(PostSearchRequest postSearchRequest) {
        return productSearchMapper.selectPosts(postSearchRequest);
    }

}