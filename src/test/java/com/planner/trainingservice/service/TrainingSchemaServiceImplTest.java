package com.planner.trainingservice.service;

import com.planner.trainingservice.TrainingServiceApplication;
import com.planner.trainingservice.controller.HomeController;
import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.model.entity.UserEntity;
import com.planner.trainingservice.model.mapper.TrainingSchemaMapper;
import com.planner.trainingservice.repository.TrainingSchemaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = TrainingServiceApplication.class)
@DisplayName("TrainingSchemaServiceImpl")
@Tag("service")
class TrainingSchemaServiceImplTest {
    @Autowired
    private TrainingSchemaServiceImpl trainingSchemaService;

    @MockBean
    private TrainingSchemaRepository trainingSchemaRepository;

    @MockBean
    private TrainingSchemaMapper trainingSchemaMapper;


    @DisplayName("create() - normal return")
    @Test
    void create_normalReturn() {
        TrainingSchema trainingSchema = new TrainingSchema("name", new ArrayList<>(), 1L);
        TrainingSchemaEntity trainingSchemaEntity = new TrainingSchemaEntity();
        when(this.trainingSchemaMapper.trainingSchemaToTrainingSchemaEntity(trainingSchema))
                .thenReturn(trainingSchemaEntity);

        when(this.trainingSchemaRepository.save(trainingSchemaEntity))
                .thenReturn(trainingSchemaEntity);
        assertEquals(this.trainingSchemaService.create(trainingSchema), trainingSchemaEntity);
    }

    @DisplayName("findAll() - normal return")
    @Test
    void findAll_normalReturn() {
        List<TrainingSchemaEntity> trainingSchemas = Collections.emptyList();
        when(this.trainingSchemaRepository.findAll())
                .thenReturn(trainingSchemas);
        assertEquals(this.trainingSchemaService.findAll(null),
                trainingSchemas);
    }

    @DisplayName("findById() - normal return")
    @Test
    void findById_normalReturn() {
        Optional<TrainingSchemaEntity> trainingSchema =  Optional.empty();
        Long id = 1L;
        when(this.trainingSchemaRepository.findById(id))
                .thenReturn(trainingSchema);
        assertEquals(this.trainingSchemaService.findById(id),
                trainingSchema);
    }

}