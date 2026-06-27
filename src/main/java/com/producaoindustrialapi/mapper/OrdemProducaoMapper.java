package com.producaoindustrialapi.mapper;

import com.producaoindustrialapi.dto.OrdemProducaoRequestDTO;
import com.producaoindustrialapi.dto.OrdemProducaoResponseDTO;
import com.producaoindustrialapi.model.OrdemProducao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdemProducaoMapper {

    @Mapping(target = "linhaProd", ignore = true)
    @Mapping(target = "produtoIndustrial", ignore = true)
    OrdemProducao toEntity(OrdemProducaoRequestDTO dto);

    @Mapping(target = "linhaProdId", source = "linhaProd.id")
    @Mapping(target = "produtoIndustrialId", source = "produtoIndustrial.id")
    OrdemProducaoResponseDTO toResponseDTO(OrdemProducao entity);
}
