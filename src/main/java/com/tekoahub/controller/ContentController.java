package com.tekoahub.controller;

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

  @Autowired
  private ContentService contentService;

  @PostMapping
  public ResponseEntity<ContentResponseDTO> createContent(@RequestBody ContentRequestDTO dto) {
    try {
      ContentResponseDTO newContent = contentService.createContent(dto);
      return ResponseEntity.status(HttpStatus.CREATED).body(newContent);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<ContentResponseDTO>> getAllContents() {
    List<ContentResponseDTO> contents = contentService.getAllContents();
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