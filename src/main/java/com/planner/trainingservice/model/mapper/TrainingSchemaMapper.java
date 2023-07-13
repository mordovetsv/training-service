package com.planner.trainingservice.model.mapper;

import com.planner.trainingservice.model.dto.Exercise;
import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;


@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class TrainingSchemaMapper {

    @Autowired
    private ExerciseMapper exerciseMapper;

    public TrainingSchemaEntity trainingSchemaToTrainingSchemaEntity(TrainingSchema trainingSchema) {
        TrainingSchemaEntity trainingSchemaEntity = new TrainingSchemaEntity();
        trainingSchemaEntity.setTrainingName(trainingSchema.getTrainingName());
        trainingSchemaEntity.setUser(new UserEntity(trainingSchema.getUserId()));
        for (Exercise exercise : trainingSchema.getExercises()) {
            trainingSchemaEntity.addExercise(this.exerciseMapper.exerciseToExerciseEntity(exercise));
        }
        return trainingSchemaEntity;
    }
}