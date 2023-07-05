-- changeset viktormordovets:2

SET search_path TO training_service;

-- 'users' table
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('common_id_seq'),
	first_name varchar NOT NULL,
	last_name varchar
);
-- rollback DROP TABLE IF EXISTS users CASCADE;
