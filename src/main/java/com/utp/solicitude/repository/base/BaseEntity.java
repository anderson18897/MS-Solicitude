package com.utp.solicitude.repository.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import static com.utp.solicitude.common.Constant.DEFAULT_USER;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -5058739834477626692L;

    @Column(name = "state")
    private Boolean state;

    @CreatedBy
    @Column(name = "creation_user")
    private String creationUser;

    @CreatedDate
    @Column(name = "creation_date", nullable = false, updatable = false)
    private OffsetDateTime creationDate;

    @LastModifiedBy
    @Column(name = "update_user")
    private String updateUser;

    @LastModifiedDate
    @Column(name = "update_date")
    private OffsetDateTime updateDate;

    @PrePersist
    public void prePersist() {
        ZoneId zoneId = ZoneId.of("America/Lima");
        OffsetDateTime now = OffsetDateTime.now(zoneId);

        if (state == null) {
            state = Boolean.TRUE;
        }

        if (creationUser == null || creationUser.isEmpty()) {
            creationUser = DEFAULT_USER;
        }
        if (updateUser == null || updateUser.isEmpty()) {
            updateUser = DEFAULT_USER;
        }
        if (creationDate == null) {
            creationDate = now;
        }
        if (updateDate == null) {
            updateDate = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        ZoneId zoneId = ZoneId.of("America/Lima");
        OffsetDateTime now = OffsetDateTime.now(zoneId);

        if (updateUser == null || updateUser.isEmpty()) {
            updateUser = DEFAULT_USER;
        }

        updateDate = now;
    }
}
