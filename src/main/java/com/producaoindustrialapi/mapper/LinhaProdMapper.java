package com.producaoindustrialapi.mapper;

import com.producaoindustrialapi.dto.LinhaProdRequestDTO;
import com.producaoindustrialapi.dto.LinhaProdResponseDTO;
import com.producaoindustrialapi.model.LinhaProd;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LinhaProdMapper {

    LinhaProd toEntity(LinhaProdRequestDTO dto);

    LinhaProdResponseDTO toResponseDTO(LinhaProd entity);
}
