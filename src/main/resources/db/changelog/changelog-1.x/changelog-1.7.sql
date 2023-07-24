-- changeset viktormordovets:7

SET search_path TO training_service;

-- 'training_session_exercise' table
DROP TABLE IF EXISTS training_session_exercise CASCADE;
CREATE TABLE training_session_exercise (
    id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	training_session_id bigint NOT NULL REFERENCES training_session(id) ON DELETE CASCADE,
	approach_number integer NOT NULL,
	exercise_count integer NOT NULL,
	training_schema_exercise_id bigint NOT NULL REFERENCES training_schema_exercise(id)  ON DELETE CASCADE

);
-- rollback DROP TABLE IF EXISTS training_session_exercise CASCADE;
