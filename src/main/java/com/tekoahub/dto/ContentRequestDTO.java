package com.tekoahub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentRequestDTO {
    
    @NotBlank(message = "Título é obrigatório")
    @Size(max = 255, message = "Título deve ter no máximo 255 caracteres")
    private String title;
    
    @Size(max = 2000, message = "Descrição deve ter no máximo 2000 caracteres")
    private String description;
    
    @NotBlank(message = "Tipo é obrigatório")
    @Size(max = 100, message = "Tipo deve ter no máximo 100 caracteres")
    private String type;
    
    @Size(max = 100, message = "Etnia deve ter no máximo 100 caracteres")
    private String ethnicity;
    
    @Size(max = 100, message = "Região deve ter no máximo 100 caracteres")
    private String region;
    
    @Size(max = 512, message = "URL da imagem deve ter no máximo 512 caracteres")
    private String imageUrl;
    
    @Size(max = 100, message = "Criador deve ter no máximo 100 caracteres")
    private String creator;
    
    private Long categoryId;
} 