package com.utp.solicitude.service.impl;

import com.utp.solicitude.dto.SolicitudeDto;
import com.utp.solicitude.mapper.SolicitudeMapper;
import com.utp.solicitude.repository.SolicitudeRepository;
import com.utp.solicitude.repository.model.SolicitudeEntity;
import com.utp.solicitude.service.SolicitudeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SolicitudeServiceImpl implements SolicitudeService {
    private final SolicitudeRepository solicitudeRepository;

    @Override
    @Transactional
    public SolicitudeDto createSolicitude(SolicitudeDto solicitudeDto) {
        SolicitudeEntity entity = SolicitudeMapper.toEntity(solicitudeDto);
        return SolicitudeMapper.toDto(solicitudeRepository.save(entity));
    }

    @Override
    @Transactional
    public SolicitudeDto updateSolicitude(UUID id, SolicitudeDto solicitudeDto) {
        return solicitudeRepository.findById(id)
                .map(existingEntity -> {
                    existingEntity.setIdPerfil(solicitudeDto.getIdPerfil());
                    existingEntity.setDescription(solicitudeDto.getDescription());
                    existingEntity.setDate(solicitudeDto.getDate());
                    existingEntity.setTotalApplicants(solicitudeDto.getTotalApplicants());
                    existingEntity.setReference1(solicitudeDto.getReference1());
                    existingEntity.setReference2(solicitudeDto.getReference2());
                    existingEntity.setReference3(solicitudeDto.getReference3());
                    return SolicitudeMapper.toDto(solicitudeRepository.save(existingEntity));
                }).orElseThrow(() -> new RuntimeException("Solicitude not found"));
    }

    @Override
    public List<SolicitudeDto> getAllSolicitudes() {
        return solicitudeRepository.findAll().stream()
                .map(SolicitudeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudeDto getSolicitudeById(UUID id) {
        return solicitudeRepository.findById(id)
                .map(SolicitudeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Solicitude not found"));
    }

    @Override
    @Transactional
    public void deleteSolicitude(UUID id) {
        solicitudeRepository.deleteById(id);
    }
}
