package com.example.provajava.domain;

import jakarta.persistence.*;

@Entity(name = "Pessoa")
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @ManyToOne
    private Trabalho trabalho;

    public Pessoa(Long id, String nome, String cpf, Trabalho trabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.trabalho = trabalho;
    }

    public Pessoa() {}

    public Trabalho getTrabalho() {
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

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public void setDados(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
    }
}
