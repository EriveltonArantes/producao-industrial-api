package com.producaoindustrialapi.controller;

import com.producaoindustrialapi.dto.OrdemProducaoRequestDTO;
import com.producaoindustrialapi.dto.OrdemProducaoResponseDTO;
import com.producaoindustrialapi.service.OrdemProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "OrdemProducao", description = "Gerenciamento de ordemproducaos")
@RestController
@RequestMapping("/api/ordemproducaos")
public class OrdemProducaoController {

    @Autowired
    private OrdemProducaoService service;

    @Operation(summary = "Listar todos os OrdemProducao")
    @GetMapping
    public List<OrdemProducaoResponseDTO> listar(@RequestParam(required = false) Long linhaProdId, @RequestParam(required = false) Long produtoIndustrialId) {
        List<OrdemProducaoResponseDTO> resultado = service.listar();
        if (linhaProdId != null) {
            resultado = resultado.stream().filter(item -> linhaProdId.equals(item.getLinhaProdId())).collect(java.util.stream.Collectors.toList());
        }
        if (produtoIndustrialId != null) {
            resultado = resultado.stream().filter(item -> produtoIndustrialId.equals(item.getProdutoIndustrialId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar OrdemProducao por ID")
    @GetMapping("/{id}")
    public OrdemProducaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar OrdemProducao")
    @PostMapping
    public ResponseEntity<OrdemProducaoResponseDTO> criar(@Valid @RequestBody OrdemProducaoRequestDTO ordemProducao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(ordemProducao));
    }

    @Operation(summary = "Atualizar OrdemProducao")
    @PutMapping("/{id}")
    public OrdemProducaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody OrdemProducaoRequestDTO ordemProducao) {
        return service.atualizar(id, ordemProducao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir OrdemProducao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
