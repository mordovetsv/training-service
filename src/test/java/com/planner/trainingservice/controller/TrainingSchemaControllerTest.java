package com.planner.trainingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planner.trainingservice.TrainingServiceApplication;
import com.planner.trainingservice.model.dto.Exercise;
import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.service.TrainingSchemaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TrainingServiceApplication.class)
@DisplayName("TrainingSchemaController")
@Tag("controller")
@Tag("trainingSchema")
@AutoConfigureMockMvc
class TrainingSchemaControllerTest {

    @MockBean
    private TrainingSchemaService trainingSchemaService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("create() - normal return")
    @Test
    void create_normalReturn() throws Exception {
        TrainingSchema trainingSchema = new TrainingSchema("name", new ArrayList<Exercise>(), 1L);
        TrainingSchemaEntity trainingSchemaEntity = new TrainingSchemaEntity();
        when(this.trainingSchemaService.create(trainingSchema)).thenReturn(trainingSchemaEntity);
        this.mockMvc.perform(post("/trainingSchemas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsBytes(trainingSchema)))
                .andExpectAll(status().isNoContent());

    }

    @DisplayName("findAll() - normal return")
    @Test
    void findAll_normalReturn() throws Exception {
        List<TrainingSchemaEntity> trainingSchemas = Collections.emptyList();
        when(this.trainingSchemaService.findAll(null)).thenReturn(trainingSchemas);
        this.mockMvc.perform(get("/trainingSchemas")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().bytes(this.objectMapper.writeValueAsBytes(trainingSchemas)));

    }

//    @DisplayName("findById() - normal return")
//    @Test
//    void findById_notFoundReturn() throws Exception {
//        Optional<TrainingSchemaEntity> trainingSchema = Optional.empty();
//        when(this.trainingSchemaService.findById(1L)).thenReturn(trainingSchema);
//        this.mockMvc.perform(get("/trainingSchemas/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpectAll(
//                        status().isNotFound());
//
//    }

}


