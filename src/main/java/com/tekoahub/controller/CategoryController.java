package com.tekoahub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekoahub.service.CategoryService;
import com.tekoahub.dto.CategoryRequestDTO;
import com.tekoahub.dto.CategoryResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO dto) {
        logger.info("Recebida requisição POST /api/categorias");
        try {
            CategoryResponseDTO newCategory = categoryService.createCategory(dto);
            logger.info("Categoria criada com sucesso: {}", newCategory.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        } catch (RuntimeException e) {
            logger.error("Erro ao criar categoria", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        logger.info("Recebida requisição GET /api/categorias");
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        logger.info("Retornando {} categorias", categories.size());
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        try {
            CategoryResponseDTO category = categoryService.getCategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO dto) {
        try {
            CategoryResponseDTO updatedCategory = categoryService.updateCategory(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
} 