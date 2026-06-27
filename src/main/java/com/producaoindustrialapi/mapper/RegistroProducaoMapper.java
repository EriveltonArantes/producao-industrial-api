package com.producaoindustrialapi.mapper;

import com.producaoindustrialapi.dto.RegistroProducaoRequestDTO;
import com.producaoindustrialapi.dto.RegistroProducaoResponseDTO;
import com.producaoindustrialapi.model.RegistroProducao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistroProducaoMapper {

    @Mapping(target = "ordemProducao", ignore = true)
    RegistroProducao toEntity(RegistroProducaoRequestDTO dto);

    @Mapping(target = "ordemProducaoId", source = "ordemProducao.id")
    RegistroProducaoResponseDTO toResponseDTO(RegistroProducao entity);
}
