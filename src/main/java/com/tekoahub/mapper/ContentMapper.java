package com.tekoahub.mapper;

import com.tekoahub.model.Content;
import com.tekoahub.dto.ContentResponseDTO;

public class ContentMapper {
    public static ContentResponseDTO toResponseDTO(Content content) {
        if (content == null) return null;
        
        return ContentResponseDTO.builder()
                .id(content.getId())
                .title(content.getTitle())
                .description(content.getDescription())
                .type(content.getType())
                .ethnicity(content.getEthnicity())
                .region(content.getRegion())
                .imageUrl(content.getImageUrl())
                .creator(content.getCreator())
                .category(content.getCategory() != null ? CategoryMapper.toResponseDTO(content.getCategory()) : null)
                .createdAt(content.getCreatedAt())
                .build();
    }

    public static Content toEntity(ContentResponseDTO dto) {
        if (dto == null) return null;

        Content content = new Content();
        content.setId(dto.getId());
        content.setTitle(dto.getTitle());
        content.setDescription(dto.getDescription());
        content.setType(dto.getType());
        content.setEthnicity(dto.getEthnicity());
        content.setRegion(dto.getRegion());
        content.setImageUrl(dto.getImageUrl());
        content.setCreator(dto.getCreator());
        content.setCreatedAt(dto.getCreatedAt());
        return content;
    }
} 