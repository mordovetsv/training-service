package com.planner.trainingservice.service;

import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.model.mapper.TrainingSchemaMapper;
import com.planner.trainingservice.repository.TrainingSchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingSchemaServiceImpl implements TrainingSchemaService {

    private final TrainingSchemaRepository trainingSchemaRepository;
    private final TrainingSchemaMapper trainingSchemaMapper;

    @Override
    public TrainingSchemaEntity create(TrainingSchema trainingSchema) {
        TrainingSchemaEntity trainingSchemaEntity = this.trainingSchemaMapper.trainingSchemaToTrainingSchemaEntity(trainingSchema);
        return this.trainingSchemaRepository.save(trainingSchemaEntity);
    }
}
