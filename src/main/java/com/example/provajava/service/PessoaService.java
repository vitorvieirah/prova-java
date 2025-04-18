package com.example.provajava.service;

import com.example.provajava.controller.dto.PessoaDto;
import com.example.provajava.domain.Pessoa;
import com.example.provajava.domain.Trabalho;
import com.example.provajava.mapper.PessoaMapper;
import com.example.provajava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    private TrabalhoService trabalhoService;

    public PessoaService(TrabalhoService trabalhoService) {
        this.trabalhoService = trabalhoService;
    }

    public Pessoa cadastrar(PessoaDto novaPessoa) {
        Trabalho trabalho = trabalhoService.buscarPorId(novaPessoa.getTrabalho().getId());

        Pessoa pessoa = PessoaMapper.paraDomain(novaPessoa);

        pessoa.setTrabalho(trabalho);

        return repository.save(pessoa);
    }

    public Pessoa consultarPorId(Long id) {
        Optional<Pessoa> pessoaOptional = repository.findById(id);

        if(pessoaOptional.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrado pelo id.");
        }

        return pessoaOptional.get();
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Pessoa editar(PessoaDto pessoaAlterada, Long id) {
        Pessoa pessoa = PessoaMapper.paraDomain(pessoaAlterada);

        Pessoa pessoaExistente = this.consultarPorId(id);

        pessoaExistente.setDados(pessoa);

        return repository.save(pessoaExistente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
