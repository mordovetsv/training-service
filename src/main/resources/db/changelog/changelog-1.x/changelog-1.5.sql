-- changeset viktormordovets:4

SET search_path TO training_service;

-- 'training_schema_day_of_week' table
DROP TABLE IF EXISTS training_schema_day_of_week CASCADE;
CREATE TABLE training_schema_day_of_week (
	training_schema_id bigint NOT NULL REFERENCES training_schema(id) ON DELETE CASCADE,
	day_of_week varchar NOT NULL CHECK (day_of_week IN
	 ('MONDAY','TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'))

);
-- rollback DROP TABLE IF EXISTS training_schema_day_of_week CASCADE;
