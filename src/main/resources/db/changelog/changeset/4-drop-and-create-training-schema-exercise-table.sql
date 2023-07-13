-- changeset viktormordovets:4

SET search_path TO training_service;

-- 'training_schema_exercise' table
DROP TABLE IF EXISTS training_schema_exercise CASCADE;
CREATE TABLE training_schema_exercise (
    id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
    training_schema_id bigint NOT NULL REFERENCES training_schema(id) ON DELETE CASCADE,
    exercise_name varchar NOT NULL,
    ordinal integer NOT NULL,
    approach_count integer NOT NULL,
    count_for_approach integer NOT NULL,
    UNIQUE (ordinal, training_schema_id)

);
-- rollback DROP TABLE IF EXISTS training_schema_exercise CASCADE;
