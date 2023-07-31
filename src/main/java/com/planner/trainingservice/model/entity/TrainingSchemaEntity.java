package com.planner.trainingservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TRAINING_SCHEMA")
@NamedEntityGraph(
        name = "trainingSchema.withExercisesAndUser",
        attributeNodes =  {
                @NamedAttributeNode("exercises"),
                @NamedAttributeNode("user")
        })
@Setter
public class TrainingSchemaEntity {
    public static final String ENTITY_GRAPH_WITH_EXERCISES_AND_USER =  "trainingSchema.withExercisesAndUser";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    private Long id;

    @Column(name = "TRAINING_NAME")
    @Getter
    private String trainingName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID")
    @Getter
    private UserEntity user;

    @OneToMany(mappedBy = "trainingSchema", cascade = CascadeType.PERSIST)
    private Set<ExerciseEntity> exercises = new HashSet<>();

    public void addExercise(ExerciseEntity exercise){
        exercise.setTrainingSchema(this);
        this.exercises.add(exercise);
    }

    public  void removeExercise(ExerciseEntity exercise){
        if( !exercise.getTrainingSchema().equals(this) ){
            throw  new IllegalArgumentException("Данный ExerciseEntity не ссылается на эту TrainingSchemaEntity");
        }
        exercises.remove(exercise);
        exercise.setTrainingSchema(null);
    }
}
