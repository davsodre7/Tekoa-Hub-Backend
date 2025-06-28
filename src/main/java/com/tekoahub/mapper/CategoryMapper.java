package com.tekoahub.mapper;

import com.tekoahub.model.Category;
import com.tekoahub.dto.CategoryRequestDTO;
import com.tekoahub.dto.CategoryResponseDTO;

public class CategoryMapper {
    
    public static CategoryResponseDTO toResponseDTO(Category category) {
        if (category == null) return null;
        
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .color(category.getColor())
                .createdAt(category.getCreatedAt())
                .build();
    }
    
    public static Category toEntity(CategoryRequestDTO dto) {
        if (dto == null) return null;
        
        return Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .color(dto.getColor())
                .build();
    }
} 