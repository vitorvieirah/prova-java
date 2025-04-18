package com.example.provajava.controller;

import com.example.provajava.controller.dto.PessoaDto;
import com.example.provajava.domain.Pessoa;
import com.example.provajava.mapper.PessoaMapper;
import com.example.provajava.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody PessoaDto novaPessoa) {
        PessoaDto resultado = PessoaMapper.paraDto(service.cadastrar(novaPessoa));

        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/pessoas/{id}")
                        .buildAndExpand(resultado.getId())
                        .toUri()
        ).body(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id) {
        PessoaDto resultado = PessoaMapper.paraDto(service.consultarPorId(id));
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> listar() {
        List<PessoaDto> resultado = service.listar().stream().map(PessoaMapper::paraDto).toList();
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> editar(@RequestBody PessoaDto pessoaAlterada, @PathVariable Long id) {
        PessoaDto resultado = PessoaMapper.paraDto(service.editar(pessoaAlterada, id));
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
