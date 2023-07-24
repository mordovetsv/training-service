package com.planner.trainingservice.repository;

import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

import static com.planner.trainingservice.model.entity.TrainingSchemaEntity.ENTITY_GRAPH_WITH_EXERCISES_AND_USER;

public interface TrainingSchemaRepository extends JpaRepository<TrainingSchemaEntity, Long>, JpaSpecificationExecutor<TrainingSchemaEntity> {

    @EntityGraph(ENTITY_GRAPH_WITH_EXERCISES_AND_USER)
    @Override
    List<TrainingSchemaEntity> findAll(Specification<TrainingSchemaEntity> spec);

    @EntityGraph(ENTITY_GRAPH_WITH_EXERCISES_AND_USER)
    @Override
    Optional<TrainingSchemaEntity> findById(Long id);

}


