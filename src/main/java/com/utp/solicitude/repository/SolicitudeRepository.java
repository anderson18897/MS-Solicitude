package com.utp.solicitude.repository;

import com.utp.solicitude.repository.model.SolicitudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SolicitudeRepository extends JpaRepository<SolicitudeEntity, UUID> {
}
