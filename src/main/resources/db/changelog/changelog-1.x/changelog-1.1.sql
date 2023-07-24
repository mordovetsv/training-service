-- changeset viktormordovets:1.1

SET search_path TO training_service;

-- Single sequence for all 'id' columns
DROP SEQUENCE IF EXISTS common_id_seq CASCADE;
CREATE SEQUENCE common_id_seq
	AS bigint
	MINVALUE 1
	START 1
	INCREMENT BY 1
	CACHE 1;
-- rollback DROP SEQUENCE IF EXISTS common_id_seq CASCADE;