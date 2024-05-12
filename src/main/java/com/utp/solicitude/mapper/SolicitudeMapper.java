package com.utp.solicitude.mapper;

import com.utp.solicitude.dto.SolicitudeDto;
import com.utp.solicitude.repository.model.SolicitudeEntity;

public class SolicitudeMapper {
    public static SolicitudeDto toDto(SolicitudeEntity entity) {
        return SolicitudeDto.builder()
                .id(entity.getId())
                .idPerfil(entity.getIdPerfil())
                .description(entity.getDescription())
                .date(entity.getDate())
                .totalApplicants(entity.getTotalApplicants())
                .reference1(entity.getReference1())
                .reference2(entity.getReference2())
                .reference3(entity.getReference3())
                .build();
    }

    public static SolicitudeEntity toEntity(SolicitudeDto dto) {
        return SolicitudeEntity.builder()
                .id(dto.getId())
                .idPerfil(dto.getIdPerfil())
                .description(dto.getDescription())
                .date(dto.getDate())
                .totalApplicants(dto.getTotalApplicants())
                .reference1(dto.getReference1())
                .reference2(dto.getReference2())
                .reference3(dto.getReference3())
                .build();
    }
}

