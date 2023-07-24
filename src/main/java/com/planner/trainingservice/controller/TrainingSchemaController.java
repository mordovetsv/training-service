package com.planner.trainingservice.controller;

import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.service.TrainingSchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для доступа к программам тренировок
 */
@RestController
@RequestMapping("/trainingSchemas")
@RequiredArgsConstructor
public class TrainingSchemaController {
    private final TrainingSchemaService trainingSchemaService;

    /**
     * Сохраняет новую программу тренировок в БД
     *
     * @param trainingSchema новая программа тренировок
     * @return пустое {@code ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TrainingSchema trainingSchema){
        this.trainingSchemaService.create(trainingSchema);
        return ResponseEntity.noContent().build();
    }

    /**
     * Выдает список всех тренировочных программ
     *
     * @return {@code ResponseEntity} со статусом 200 и телом ответа содержащим список всех тренировочных программ
     */
    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(name = "userId", required = false) Long userId){
        List<TrainingSchemaEntity> trainingSchemas = this.trainingSchemaService.findAll(userId);
        return ResponseEntity.ok(trainingSchemas);
    }

    /**
     * Выдает тренировочную программу {@code id}
     *
     * @return {@code ResponseEntity} со статусом 200 и телом ответа содержащим тренировочную программу
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Optional<TrainingSchemaEntity> trainingSchema = this.trainingSchemaService.findById(id);
        if(trainingSchema.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(trainingSchema.get());
        }
    }

}
