package com.g3c1.temi.global.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = ZonedDateTime.now();
    }
}
