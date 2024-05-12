package com.utp.solicitude.controller;

import com.utp.solicitude.dto.SolicitudeDto;
import com.utp.solicitude.service.SolicitudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/solicitude")
public class SolicitudeController {
    private final SolicitudeService solicitudeService;

    @PostMapping
    public ResponseEntity<SolicitudeDto> createSolicitude(@RequestBody SolicitudeDto solicitudeDto) {
        return ResponseEntity.ok(solicitudeService.createSolicitude(solicitudeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudeDto> updateSolicitude(@PathVariable UUID id, @RequestBody SolicitudeDto solicitudeDto) {
        return ResponseEntity.ok(solicitudeService.updateSolicitude(id, solicitudeDto));
    }

    @GetMapping
    public ResponseEntity<List<SolicitudeDto>> getAllSolicitudes() {
        return ResponseEntity.ok(solicitudeService.getAllSolicitudes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudeDto> getSolicitudeById(@PathVariable UUID id) {
        return ResponseEntity.ok(solicitudeService.getSolicitudeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitude(@PathVariable UUID id) {
        solicitudeService.deleteSolicitude(id);
        return ResponseEntity.ok().build();
    }
}
