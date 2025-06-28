package com.tekoahub.service;

import com.tekoahub.model.Category;
import com.tekoahub.repository.CategoryRepository;
import com.tekoahub.dto.CategoryRequestDTO;
import com.tekoahub.dto.CategoryResponseDTO;
import com.tekoahub.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toResponseDTO(savedCategory);
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID " + id));
        return CategoryMapper.toResponseDTO(category);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID " + id));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setColor(dto.getColor());

        Category updatedCategory = categoryRepository.save(existing);
        return CategoryMapper.toResponseDTO(updatedCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
} 