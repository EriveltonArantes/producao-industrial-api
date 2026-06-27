package com.producaoindustrialapi.service;

import com.producaoindustrialapi.dto.LinhaProdRequestDTO;
import com.producaoindustrialapi.dto.LinhaProdResponseDTO;
import com.producaoindustrialapi.exception.ResourceNotFoundException;
import com.producaoindustrialapi.mapper.LinhaProdMapper;
import com.producaoindustrialapi.model.LinhaProd;
import com.producaoindustrialapi.repository.LinhaProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LinhaProdService {

    @Autowired
    private LinhaProdRepository repository;

    @Autowired
    private LinhaProdMapper mapper;

    @Transactional(readOnly = true)
    public List<LinhaProdResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LinhaProdResponseDTO buscar(Long id) {
        LinhaProd entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("LinhaProd não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public LinhaProdResponseDTO criar(LinhaProdRequestDTO dto) {
        LinhaProd entity = mapper.toEntity(dto);
        LinhaProd salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public LinhaProdResponseDTO atualizar(Long id, LinhaProdRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("LinhaProd não encontrado com id: " + id);
        }
        LinhaProd entity = mapper.toEntity(dto);
        entity.setId(id);
        LinhaProd salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("LinhaProd não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
