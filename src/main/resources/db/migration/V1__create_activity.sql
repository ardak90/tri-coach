CREATE TABLE activities(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sport VARCHAR(30) NOT NULL,
    start_time TIMESTAMPTZ NOT NULL,
    duration_seconds INTEGER NOT NULL,
    distance_meters DOUBLE PRECISION,
    avg_heart_rate INTEGER,
    file_hash VARCHAR(64) NOT NULL,
    CONSTRAINT ck_activities_file_hash CHECK (file_hash ~ '^[0-9a-f]{64}$'),
    CONSTRAINT uq_activities_file_hash UNIQUE (file_hash),
    CONSTRAINT ck_activities_distance_meters CHECK (distance_meters >= 0),
    CONSTRAINT ck_activities_duration_seconds CHECK (duration_seconds > 0),
    CONSTRAINT ck_activities_avg_heart_rate CHECK (avg_heart_rate > 0 AND avg_heart_rate < 250)
);