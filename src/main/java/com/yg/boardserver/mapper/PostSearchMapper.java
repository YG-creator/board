package com.yg.boardserver.mapper;

import com.yg.boardserver.dto.PostDTO;
import com.yg.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {
    List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);
}