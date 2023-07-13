package com.planner.trainingservice.service;

import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.repository.TrainingSchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface TrainingSchemaService {

    TrainingSchemaEntity create(TrainingSchema trainingSchema);
}
