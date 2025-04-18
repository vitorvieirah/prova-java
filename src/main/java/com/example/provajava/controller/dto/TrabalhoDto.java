package com.example.provajava.controller.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TrabalhoDto {

    private Long id;
    private String endereco;

    public TrabalhoDto(Long id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }
}
