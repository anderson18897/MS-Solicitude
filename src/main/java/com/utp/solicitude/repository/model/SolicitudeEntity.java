package com.utp.solicitude.repository.model;

import com.utp.solicitude.repository.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "solicitud")
public class SolicitudeEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -3224272046158834811L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "id_perfil")
    private UUID idPerfil;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "total_applicants")
    private Integer totalApplicants;

    @Column(name = "reference_1")
    private String reference1;

    @Column(name = "reference_2")
    private String reference2;

    @Column(name = "reference_3")
    private String reference3;
}
