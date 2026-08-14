package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//Lecture 25 - update audit columns using SpringData JPA Auditing
@Getter @Setter @ToString
public class BaseEntity {

    @CreatedDate //used for auditing purpose to store the created date of the entity
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy //used for auditing purpose to store the created by of the entity
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate //used for auditing purpose to store the last modified date of the entity
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy //used for auditing purpose to store the last modified by of the entity
    @Column(insertable = false)
    private String updatedBy;
}
