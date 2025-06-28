package com.tekoahub.service;

import com.tekoahub.model.Content;
import com.tekoahub.model.Category;
import com.tekoahub.repository.ContentRepository;
import com.tekoahub.repository.CategoryRepository;
import com.tekoahub.dto.ContentRequestDTO;
import com.tekoahub.dto.ContentResponseDTO;
import com.tekoahub.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ContentResponseDTO createContent(ContentRequestDTO dto) {
        Category category = null;
        if (dto.getCategoryId() != null) {
            category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID " + dto.getCategoryId()));
        }

        Content content = Content.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .type(dto.getType())
                .ethnicity(dto.getEthnicity())
                .region(dto.getRegion())
                .imageUrl(dto.getImageUrl())
                .creator(dto.getCreator())
                .category(category)
                .build();

        Content savedContent = contentRepository.save(content);
        return ContentMapper.toResponseDTO(savedContent);
    }

    public List<ContentResponseDTO> getAllContents() {
        return contentRepository.findAll().stream()
                .map(ContentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ContentResponseDTO getContentById(Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteúdo não encontrado com ID " + id));
        return ContentMapper.toResponseDTO(content);
    }

    public ContentResponseDTO updateContent(Long id, ContentRequestDTO dto) {
        Content existing = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conteúdo não encontrado com ID " + id));

        Category category = null;
        if (dto.getCategoryId() != null) {
            category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID " + dto.getCategoryId()));
        }

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setType(dto.getType());
        existing.setEthnicity(dto.getEthnicity());
        existing.setRegion(dto.getRegion());
        existing.setImageUrl(dto.getImageUrl());
        existing.setCreator(dto.getCreator());
        existing.setCategory(category);

        Content updatedContent = contentRepository.save(existing);
        return ContentMapper.toResponseDTO(updatedContent);
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}