-- changeset viktormordovets:3

SET search_path TO training_service;

-- 'training_schema' table
DROP TABLE IF EXISTS training_schema CASCADE;
CREATE TABLE training_schema (
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	users_id bigint NOT NULL REFERENCES users(id)  ON DELETE CASCADE,
	training_name varchar NOT NULL UNIQUE

);
-- rollback DROP TABLE IF EXISTS training_schema CASCADE;
