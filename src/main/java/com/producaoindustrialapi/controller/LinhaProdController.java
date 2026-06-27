package com.producaoindustrialapi.controller;

import com.producaoindustrialapi.dto.LinhaProdRequestDTO;
import com.producaoindustrialapi.dto.LinhaProdResponseDTO;
import com.producaoindustrialapi.service.LinhaProdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "LinhaProd", description = "Gerenciamento de linhaprods")
@RestController
@RequestMapping("/api/linhaprods")
public class LinhaProdController {

    @Autowired
    private LinhaProdService service;

    @Operation(summary = "Listar todos os LinhaProd")
    @GetMapping
    public List<LinhaProdResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<LinhaProdResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar LinhaProd por ID")
    @GetMapping("/{id}")
    public LinhaProdResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar LinhaProd")
    @PostMapping
    public ResponseEntity<LinhaProdResponseDTO> criar(@Valid @RequestBody LinhaProdRequestDTO linhaProd) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(linhaProd));
    }

    @Operation(summary = "Atualizar LinhaProd")
    @PutMapping("/{id}")
    public LinhaProdResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody LinhaProdRequestDTO linhaProd) {
        return service.atualizar(id, linhaProd);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir LinhaProd")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
