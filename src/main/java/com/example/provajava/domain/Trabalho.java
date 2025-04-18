package com.example.provajava.domain;

import jakarta.persistence.*;

@Entity(name = "Trabalho")
@Table(name = "trabalhos")
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;

    public Trabalho(Long id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }

    public Trabalho() {}

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setDados(Trabalho trabalho) {
        this.endereco = trabalho.getEndereco();
    }
}
