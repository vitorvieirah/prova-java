package com.example.provajava.controller;

import com.example.provajava.controller.dto.TrabalhoDto;
import com.example.provajava.mapper.TrabalhoMapper;
import com.example.provajava.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;


    @PostMapping
    public ResponseEntity<TrabalhoDto> cadastrar(@RequestBody TrabalhoDto novoTrabalho) {
        TrabalhoDto resultado = TrabalhoMapper.paraDto(service.cadastrar(novoTrabalho));

        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/trabalhos/{id}")
                        .buildAndExpand(resultado.getId())
                        .toUri()
        ).body(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDto> buscarPorId(@PathVariable Long id) {
        TrabalhoDto resultado = TrabalhoMapper.paraDto(service.buscarPorId(id));

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<TrabalhoDto>> listar() {
        List<TrabalhoDto> resultado = service.listar().stream().map(TrabalhoMapper::paraDto).toList();
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDto> editar(@RequestBody TrabalhoDto trabalhoAlterado, @PathVariable Long id) {
        TrabalhoDto resultado = TrabalhoMapper.paraDto(service.editar(trabalhoAlterado, id));

        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
