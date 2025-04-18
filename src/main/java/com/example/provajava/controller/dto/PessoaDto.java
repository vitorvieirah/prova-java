package com.example.provajava.controller.dto;

import com.example.provajava.domain.Trabalho;

public class PessoaDto {

    private Long id;
    private String nome;
    private String cpf;

    private TrabalhoDto trabalho;

    public PessoaDto(Long id, String nome, String cpf, TrabalhoDto trabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.trabalho = trabalho;
    }

    public TrabalhoDto getTrabalho() {
        return trabalho;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTrabalho(TrabalhoDto trabalho) {
        this.trabalho = trabalho;
    }
}
