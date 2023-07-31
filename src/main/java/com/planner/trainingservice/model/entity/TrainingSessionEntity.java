package com.planner.trainingservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name="USERS")
@Getter
@Setter
public class TrainingSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINING_SCHEMA_ID")
    private TrainingSchemaEntity trainingSchema;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRAINING_DATE")
    private Instant trainingDate;

}
