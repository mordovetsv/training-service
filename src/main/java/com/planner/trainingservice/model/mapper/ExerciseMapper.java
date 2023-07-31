package com.planner.trainingservice.model.mapper;

import com.planner.trainingservice.model.dto.Exercise;
import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;


@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseMapper {

    @Mapping(target = "trainingSchema", ignore = true)
    @Mapping(target = "id", ignore = true)
    ExerciseEntity exerciseToExerciseEntity(Exercise exercise);

}
