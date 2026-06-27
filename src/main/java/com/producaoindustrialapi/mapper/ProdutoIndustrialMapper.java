package com.producaoindustrialapi.mapper;

import com.producaoindustrialapi.dto.ProdutoIndustrialRequestDTO;
import com.producaoindustrialapi.dto.ProdutoIndustrialResponseDTO;
import com.producaoindustrialapi.model.ProdutoIndustrial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoIndustrialMapper {

    ProdutoIndustrial toEntity(ProdutoIndustrialRequestDTO dto);

    ProdutoIndustrialResponseDTO toResponseDTO(ProdutoIndustrial entity);
}
