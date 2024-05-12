package com.utp.solicitude.dto;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Builder
@Data
public class SolicitudeDto {
    private UUID id;
    private UUID idPerfil;
    private String description;
    private String date;
    private Integer totalApplicants;
    private String reference1;
    private String reference2;
    private String reference3;
}
