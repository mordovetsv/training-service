package com.planner.trainingservice.model.dto;

import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Exercise {

    private final String exerciseName;

    private final Integer approachCount;

    private final Integer countForApproach;

    private final Integer ordinal;

}
