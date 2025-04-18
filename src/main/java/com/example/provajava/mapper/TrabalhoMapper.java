package com.example.provajava.mapper;

import com.example.provajava.controller.dto.TrabalhoDto;
import com.example.provajava.domain.Trabalho;

public class TrabalhoMapper {

    public static Trabalho paraDomain(TrabalhoDto dto) {
        return new Trabalho(
                dto.getId(),
                dto.getEndereco()
        );
    }

    public static TrabalhoDto paraDto(Trabalho domain) {
        return new TrabalhoDto(
                domain.getId(),
                domain.getEndereco()
        );
    }
}
