package com.producaoindustrialapi.service;

import com.producaoindustrialapi.dto.RegistroProducaoRequestDTO;
import com.producaoindustrialapi.dto.RegistroProducaoResponseDTO;
import com.producaoindustrialapi.exception.ResourceNotFoundException;
import com.producaoindustrialapi.mapper.RegistroProducaoMapper;
import com.producaoindustrialapi.model.RegistroProducao;
import com.producaoindustrialapi.repository.RegistroProducaoRepository;
import com.producaoindustrialapi.repository.OrdemProducaoRepository;
import com.producaoindustrialapi.model.OrdemProducao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroProducaoService {

    @Autowired
    private RegistroProducaoRepository repository;

    @Autowired
    private RegistroProducaoMapper mapper;

    @Autowired
    private OrdemProducaoRepository ordemProducaoRepository;

    @Transactional(readOnly = true)
    public List<RegistroProducaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RegistroProducaoResponseDTO buscar(Long id) {
        RegistroProducao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("RegistroProducao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public RegistroProducaoResponseDTO criar(RegistroProducaoRequestDTO dto) {
        RegistroProducao entity = mapper.toEntity(dto);
        OrdemProducao ordemProducao = ordemProducaoRepository.findById(dto.getOrdemProducaoId())
            .orElseThrow(() -> new ResourceNotFoundException("OrdemProducao não encontrado com id: " + dto.getOrdemProducaoId()));
        entity.setOrdemProducao(ordemProducao);
        RegistroProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public RegistroProducaoResponseDTO atualizar(Long id, RegistroProducaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RegistroProducao não encontrado com id: " + id);
        }
        RegistroProducao entity = mapper.toEntity(dto);
        entity.setId(id);
        OrdemProducao ordemProducao = ordemProducaoRepository.findById(dto.getOrdemProducaoId())
            .orElseThrow(() -> new ResourceNotFoundException("OrdemProducao não encontrado com id: " + dto.getOrdemProducaoId()));
        entity.setOrdemProducao(ordemProducao);
        RegistroProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("RegistroProducao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
