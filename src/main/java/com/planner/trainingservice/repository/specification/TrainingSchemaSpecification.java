package com.planner.trainingservice.repository.specification;

import com.planner.trainingservice.model.entity.TrainingSchemaEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * Спецификации для взаимодействия с таблицей тренировочных программ
 */
public class TrainingSchemaSpecification {

    /**
     * Фильтрует тренировочные программы по id пользователя
     *
     * @param userId id пользователя
     * @return спецификация фильтрующая по id пользователя
     */
    public static Specification<TrainingSchemaEntity> byUserId(Long userId) {
        return (root, query, builder) -> builder
                .equal(root.get("user").get("id"), userId);
    }
}
