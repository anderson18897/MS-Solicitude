package com.utp.solicitude.service;

import com.utp.solicitude.dto.SolicitudeDto;
import java.util.List;
import java.util.UUID;

public interface SolicitudeService {
    SolicitudeDto createSolicitude(SolicitudeDto solicitudeDto);
    SolicitudeDto updateSolicitude(UUID id, SolicitudeDto solicitudeDto);
    List<SolicitudeDto> getAllSolicitudes();
    SolicitudeDto getSolicitudeById(UUID id);
    void deleteSolicitude(UUID id);
}
