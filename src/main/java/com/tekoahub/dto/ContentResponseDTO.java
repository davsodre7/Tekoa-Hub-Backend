package com.tekoahub.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentResponseDTO {
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String title;
    @NotBlank(message = "Descrição é obrigatória")
    private String description;
    @NotBlank(message = "Tipo é obrigatório")
    private String type;
    @NotBlank(message = "Etnia é obrigatória")
    private String ethnicity;
    @NotBlank(message = "Região é obrigatória")
    private String region;
    private String imageUrl;
    @NotBlank(message = "Criador é obrigatório")
    private String creator;
    private CategoryResponseDTO category;
    private LocalDateTime createdAt;
} 