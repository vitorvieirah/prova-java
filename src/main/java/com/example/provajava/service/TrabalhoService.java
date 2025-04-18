package com.example.provajava.service;

import com.example.provajava.controller.dto.TrabalhoDto;
import com.example.provajava.domain.Trabalho;
import com.example.provajava.mapper.TrabalhoMapper;
import com.example.provajava.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repository;

    public Trabalho cadastrar(TrabalhoDto novoTrabalho) {
        Trabalho trabalho = TrabalhoMapper.paraDomain(novoTrabalho);

        return repository.save(trabalho);
    }

    public Trabalho buscarPorId(Long id) {
        Optional<Trabalho> trabalho = repository.findById(id);

        if(trabalho.isEmpty()) {
            throw new RuntimeException("Trabalho não encontrado pelo id.");
        }

        return trabalho.get();
    }

    public List<Trabalho> listar() {
        return repository.findAll();
    }

    public Trabalho editar(TrabalhoDto trabalhoAlterado, Long id) {
        Trabalho trabalho = TrabalhoMapper.paraDomain(trabalhoAlterado);

        Trabalho trabalhoExistente = this.buscarPorId(id);

        trabalhoExistente.setDados(trabalho);

        return repository.save(trabalhoExistente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
