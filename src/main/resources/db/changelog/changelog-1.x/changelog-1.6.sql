-- changeset viktormordovets:6

SET search_path TO training_service;

-- 'training_session' table
DROP TABLE IF EXISTS training_session CASCADE;
CREATE TABLE training_session (
    id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	training_schema_id bigint NOT NULL REFERENCES training_schema(id)  ON DELETE CASCADE,
	training_date date NOT NULL

);
-- rollback DROP TABLE IF EXISTS training_session CASCADE;
