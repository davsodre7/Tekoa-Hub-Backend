package com.tekoahub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tekoahub.service.ContentService;
import com.tekoahub.dto.ContentRequestDTO;
import com.tekoahub.dto.ContentResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/conteudos")
public class ContentController {

  private static final Logger logger = LoggerFactory.getLogger(ContentController.class);

  @Autowired
  private ContentService contentService;

  @PostMapping
  public ResponseEntity<ContentResponseDTO> createContent(@RequestBody ContentRequestDTO dto) {
    logger.info("Recebida requisição POST /api/conteudos");
    try {
      ContentResponseDTO newContent = contentService.createContent(dto);
      logger.info("Conteúdo criado com sucesso: {}", newContent.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(newContent);
    } catch (RuntimeException e) {
      logger.error("Erro ao criar conteúdo", e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<ContentResponseDTO>> getAllContents() {
    logger.info("Recebida requisição GET /api/conteudos");
    List<ContentResponseDTO> contents = contentService.getAllContents();
    logger.info("Retornando {} conteúdos", contents.size());
    return ResponseEntity.status(HttpStatus.OK).body(contents);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ContentResponseDTO> getContentById(@PathVariable Long id) {
    try {
      ContentResponseDTO content = contentService.getContentById(id);
      return ResponseEntity.status(HttpStatus.OK).body(content);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<ContentResponseDTO> updateContent(@PathVariable Long id, @RequestBody ContentRequestDTO dto) {
    try {
      ContentResponseDTO updatedContent = contentService.updateContent(id, dto);
      return ResponseEntity.status(HttpStatus.OK).body(updatedContent);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
    try {
      contentService.deleteContent(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}