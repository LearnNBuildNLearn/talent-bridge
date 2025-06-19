-- Ensures the application table exists
CREATE TABLE IF NOT EXISTS application
(
    id           UUID PRIMARY KEY,
    status       VARCHAR(225)      NOT NULL,
    job_id       UUID,
    remarks      VARCHAR(225),
    created_on   DATE              NOT NULL,
    created_by   UUID              NOT NULL,
    modified_on  DATE              NOT NULL,
    modified_by  UUID              NOT NULL
);

-- Insert Values
INSERT INTO application (
    id,
    status,
    job_id,
    remarks,
    created_on,
    created_by,
    modified_on,
    modified_by
) VALUES (
             '123e4567-e89b-12d3-a456-426614174000',
             'PENDING',
             '987e6543-e21b-32d3-b456-426614174111',
             'Initial submission',
             '2025-06-19',
             '111e2222-e33b-44d3-b456-426614174222',
             '2025-06-19',
             '111e2222-e33b-44d3-b456-426614174222'
);