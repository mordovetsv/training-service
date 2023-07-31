package com.planner.trainingservice.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.aot.hint.annotation.Reflective;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public final class TrainingSchema implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String trainingName;

    private final List<Exercise> exercises;

    private final Long userId;

}
