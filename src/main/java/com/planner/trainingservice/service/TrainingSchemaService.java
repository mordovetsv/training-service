package com.planner.trainingservice.service;

import com.planner.trainingservice.model.dto.Exercise;
import com.planner.trainingservice.model.dto.TrainingSchema;
import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import com.planner.trainingservice.repository.TrainingSchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для взаимодецствия с таблицей программ тренировок
 */
public interface TrainingSchemaService {

    /**
     * Создает новую тренировочную программу
     *
     * @param trainingSchema
     * @return
     */
    TrainingSchemaEntity create(TrainingSchema trainingSchema);

    /**
     * Выдает список всех тренировочных программ
     *
     * @param userId id пользователя
     * @return список всех тренировочных схем
     */
    List<TrainingSchemaEntity> findAll(Long userId);

    /**
     * Выдает тренировочную программу по id
     *
     * @return тренировочнаяя программа
     */
    Optional<TrainingSchemaEntity> findById(Long id);

}
