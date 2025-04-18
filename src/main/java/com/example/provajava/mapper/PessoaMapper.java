package com.example.provajava.mapper;

import com.example.provajava.controller.dto.PessoaDto;
import com.example.provajava.domain.Pessoa;

public class PessoaMapper {

    public static Pessoa paraDomain(PessoaDto dto) {
        return new Pessoa(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                TrabalhoMapper.paraDomain(dto.getTrabalho())
        );
    }

    public static PessoaDto paraDto(Pessoa domain) {
        return new PessoaDto(
                domain.getId(),
                domain.getNome(),
                domain.getCpf(),
                TrabalhoMapper.paraDto(domain.getTrabalho())
        );
    }
}
