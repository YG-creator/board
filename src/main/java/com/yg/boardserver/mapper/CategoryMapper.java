package com.yg.boardserver.mapper;

import com.yg.boardserver.dto.CategoryDTO;

public interface CategoryMapper {
    int register(CategoryDTO productDTO);

    void updateCategory(CategoryDTO categoryDTO);

    void deleteCategory(int categoryId);
}