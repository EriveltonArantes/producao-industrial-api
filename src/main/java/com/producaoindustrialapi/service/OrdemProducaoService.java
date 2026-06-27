package com.producaoindustrialapi.service;

import com.producaoindustrialapi.dto.OrdemProducaoRequestDTO;
import com.producaoindustrialapi.dto.OrdemProducaoResponseDTO;
import com.producaoindustrialapi.exception.ResourceNotFoundException;
import com.producaoindustrialapi.mapper.OrdemProducaoMapper;
import com.producaoindustrialapi.model.OrdemProducao;
import com.producaoindustrialapi.repository.OrdemProducaoRepository;
import com.producaoindustrialapi.repository.LinhaProdRepository;
import com.producaoindustrialapi.model.LinhaProd;
import com.producaoindustrialapi.repository.ProdutoIndustrialRepository;
import com.producaoindustrialapi.model.ProdutoIndustrial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrdemProducaoService {

    @Autowired
    private OrdemProducaoRepository repository;

    @Autowired
    private OrdemProducaoMapper mapper;

    @Autowired
    private LinhaProdRepository linhaProdRepository;

    @Autowired
    private ProdutoIndustrialRepository produtoIndustrialRepository;

    @Transactional(readOnly = true)
    public List<OrdemProducaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrdemProducaoResponseDTO buscar(Long id) {
        OrdemProducao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OrdemProducao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public OrdemProducaoResponseDTO criar(OrdemProducaoRequestDTO dto) {
        OrdemProducao entity = mapper.toEntity(dto);
        LinhaProd linhaProd = linhaProdRepository.findById(dto.getLinhaProdId())
            .orElseThrow(() -> new ResourceNotFoundException("LinhaProd não encontrado com id: " + dto.getLinhaProdId()));
        entity.setLinhaProd(linhaProd);
        ProdutoIndustrial produtoIndustrial = produtoIndustrialRepository.findById(dto.getProdutoIndustrialId())
            .orElseThrow(() -> new ResourceNotFoundException("ProdutoIndustrial não encontrado com id: " + dto.getProdutoIndustrialId()));
        entity.setProdutoIndustrial(produtoIndustrial);
        OrdemProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public OrdemProducaoResponseDTO atualizar(Long id, OrdemProducaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("OrdemProducao não encontrado com id: " + id);
        }
        OrdemProducao entity = mapper.toEntity(dto);
        entity.setId(id);
        LinhaProd linhaProd = linhaProdRepository.findById(dto.getLinhaProdId())
            .orElseThrow(() -> new ResourceNotFoundException("LinhaProd não encontrado com id: " + dto.getLinhaProdId()));
        entity.setLinhaProd(linhaProd);
        ProdutoIndustrial produtoIndustrial = produtoIndustrialRepository.findById(dto.getProdutoIndustrialId())
            .orElseThrow(() -> new ResourceNotFoundException("ProdutoIndustrial não encontrado com id: " + dto.getProdutoIndustrialId()));
        entity.setProdutoIndustrial(produtoIndustrial);
        OrdemProducao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("OrdemProducao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
