package com.planner.trainingservice.controller;

import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.service.TrainingSchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainingSchemas")
@RequiredArgsConstructor
public class TrainingSchemaController {
    private final TrainingSchemaService trainingSchemaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TrainingSchema trainingSchema){
        this.trainingSchemaService.create(trainingSchema);
        return ResponseEntity.noContent().build();
    }


}
