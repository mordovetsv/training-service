package com.planner.trainingservice.service;

import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.model.mapper.TrainingSchemaMapper;
import com.planner.trainingservice.repository.TrainingSchemaRepository;
import com.planner.trainingservice.repository.specification.TrainingSchemaSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интрфейса {@code TrainingSchemaService} по умолчанию
 */
@Service
@RequiredArgsConstructor
public class TrainingSchemaServiceImpl implements TrainingSchemaService {

    private final TrainingSchemaRepository trainingSchemaRepository;
    private final TrainingSchemaMapper trainingSchemaMapper;

    @Transactional
    @Override
    public TrainingSchemaEntity create(TrainingSchema trainingSchema) {
        TrainingSchemaEntity trainingSchemaEntity = this.trainingSchemaMapper.trainingSchemaToTrainingSchemaEntity(trainingSchema);
        return this.trainingSchemaRepository.save(trainingSchemaEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TrainingSchemaEntity> findAll(Long userId) {

        Specification<TrainingSchemaEntity> spec = Specification.where(null);
        if (userId != null) {
            spec = spec.and(TrainingSchemaSpecification.byUserId(userId));
        }
        return this.trainingSchemaRepository.findAll(spec);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TrainingSchemaEntity> findById(Long id) {
        return this.trainingSchemaRepository.findById(id);
    }

}
