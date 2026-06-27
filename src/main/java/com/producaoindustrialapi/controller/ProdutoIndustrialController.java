package com.producaoindustrialapi.controller;

import com.producaoindustrialapi.dto.ProdutoIndustrialRequestDTO;
import com.producaoindustrialapi.dto.ProdutoIndustrialResponseDTO;
import com.producaoindustrialapi.service.ProdutoIndustrialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "ProdutoIndustrial", description = "Gerenciamento de produtoindustrials")
@RestController
@RequestMapping("/api/produtoindustrials")
public class ProdutoIndustrialController {

    @Autowired
    private ProdutoIndustrialService service;

    @Operation(summary = "Listar todos os ProdutoIndustrial")
    @GetMapping
    public List<ProdutoIndustrialResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<ProdutoIndustrialResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar ProdutoIndustrial por ID")
    @GetMapping("/{id}")
    public ProdutoIndustrialResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar ProdutoIndustrial")
    @PostMapping
    public ResponseEntity<ProdutoIndustrialResponseDTO> criar(@Valid @RequestBody ProdutoIndustrialRequestDTO produtoIndustrial) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(produtoIndustrial));
    }

    @Operation(summary = "Atualizar ProdutoIndustrial")
    @PutMapping("/{id}")
    public ProdutoIndustrialResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoIndustrialRequestDTO produtoIndustrial) {
        return service.atualizar(id, produtoIndustrial);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir ProdutoIndustrial")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
