package com.planner.trainingservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TRAINING_SCHEMA_EXERCISE")
@Getter
@Setter
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EXERCISE_NAME")
    private  String exerciseName;

    @Column(name = "APPROACH_COUNT")
    private Integer approachCount;

    @Column(name = "COUNT_FOR_APPROACH")
    private Integer countForApproach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINING_SCHEMA_ID")
    private TrainingSchemaEntity trainingSchema;

    @Column(name = "ordinal")
    private Integer ordinal;

}
