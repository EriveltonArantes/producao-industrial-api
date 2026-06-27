package com.producaoindustrialapi.controller;

import com.producaoindustrialapi.dto.RegistroProducaoRequestDTO;
import com.producaoindustrialapi.dto.RegistroProducaoResponseDTO;
import com.producaoindustrialapi.service.RegistroProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "RegistroProducao", description = "Gerenciamento de registroproducaos")
@RestController
@RequestMapping("/api/registroproducaos")
public class RegistroProducaoController {

    @Autowired
    private RegistroProducaoService service;

    @Operation(summary = "Listar todos os RegistroProducao")
    @GetMapping
    public List<RegistroProducaoResponseDTO> listar(@RequestParam(required = false) String turno, @RequestParam(required = false) Long ordemProducaoId) {
        List<RegistroProducaoResponseDTO> resultado = service.listar();
        if (turno != null && !turno.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTurno() != null &&
                item.getTurno().toLowerCase().contains(turno.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (ordemProducaoId != null) {
            resultado = resultado.stream().filter(item -> ordemProducaoId.equals(item.getOrdemProducaoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar RegistroProducao por ID")
    @GetMapping("/{id}")
    public RegistroProducaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar RegistroProducao")
    @PostMapping
    public ResponseEntity<RegistroProducaoResponseDTO> criar(@Valid @RequestBody RegistroProducaoRequestDTO registroProducao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(registroProducao));
    }

    @Operation(summary = "Atualizar RegistroProducao")
    @PutMapping("/{id}")
    public RegistroProducaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody RegistroProducaoRequestDTO registroProducao) {
        return service.atualizar(id, registroProducao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir RegistroProducao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
