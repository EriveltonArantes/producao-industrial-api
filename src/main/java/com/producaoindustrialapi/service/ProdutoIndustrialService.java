package com.producaoindustrialapi.service;

import com.producaoindustrialapi.dto.ProdutoIndustrialRequestDTO;
import com.producaoindustrialapi.dto.ProdutoIndustrialResponseDTO;
import com.producaoindustrialapi.exception.ResourceNotFoundException;
import com.producaoindustrialapi.mapper.ProdutoIndustrialMapper;
import com.producaoindustrialapi.model.ProdutoIndustrial;
import com.producaoindustrialapi.repository.ProdutoIndustrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProdutoIndustrialService {

    @Autowired
    private ProdutoIndustrialRepository repository;

    @Autowired
    private ProdutoIndustrialMapper mapper;

    @Transactional(readOnly = true)
    public List<ProdutoIndustrialResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoIndustrialResponseDTO buscar(Long id) {
        ProdutoIndustrial entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ProdutoIndustrial não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProdutoIndustrialResponseDTO criar(ProdutoIndustrialRequestDTO dto) {
        ProdutoIndustrial entity = mapper.toEntity(dto);
        ProdutoIndustrial salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProdutoIndustrialResponseDTO atualizar(Long id, ProdutoIndustrialRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProdutoIndustrial não encontrado com id: " + id);
        }
        ProdutoIndustrial entity = mapper.toEntity(dto);
        entity.setId(id);
        ProdutoIndustrial salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProdutoIndustrial não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
