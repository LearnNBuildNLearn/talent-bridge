-- Ensures the application table exists
CREATE TABLE IF NOT EXISTS application
(
    id           UUID PRIMARY KEY,
    status       VARCHAR(225)      NOT NULL,
    job_id       UUID              NOT NULL,
    remarks      VARCHAR(225)      NOT NULL,
    created_on   DATE              NOT NULL,
    created_by   UUID              NOT NULL,
    modified_on  DATE,
    modified_by  UUID
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
)
SELECT * FROM (
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789001'::UUID, 'PENDING', 'b1e45678-1111-4a4d-bbbb-123456789011'::UUID, 'Initial submission', '2025-06-15'::DATE, 'c1e45678-1111-4a4d-cccc-123456789021'::UUID, '2025-06-16'::DATE, 'c1e45678-1111-4a4d-cccc-123456789021'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789002'::UUID, 'APPROVED', 'b1e45678-1111-4a4d-bbbb-123456789012'::UUID, 'Approved after review', '2025-06-14'::DATE, 'c1e45678-1111-4a4d-cccc-123456789022'::UUID, '2025-06-16'::DATE, 'c1e45678-1111-4a4d-cccc-123456789022'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789003'::UUID, 'REJECTED', 'b1e45678-1111-4a4d-bbbb-123456789013'::UUID, 'Missing experience', '2025-06-13'::DATE, 'c1e45678-1111-4a4d-cccc-123456789023'::UUID, '2025-06-14'::DATE, 'c1e45678-1111-4a4d-cccc-123456789023'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789004'::UUID, 'IN_REVIEW', 'b1e45678-1111-4a4d-bbbb-123456789014'::UUID, 'Under HR review', '2025-06-12'::DATE, 'c1e45678-1111-4a4d-cccc-123456789024'::UUID, '2025-06-13'::DATE, 'c1e45678-1111-4a4d-cccc-123456789024'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789005'::UUID, 'WITHDRAWN', 'b1e45678-1111-4a4d-bbbb-123456789015'::UUID, 'Withdrawn by applicant', '2025-06-11'::DATE, 'c1e45678-1111-4a4d-cccc-123456789025'::UUID, '2025-06-12'::DATE, 'c1e45678-1111-4a4d-cccc-123456789025'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789006'::UUID, 'PENDING', 'b1e45678-1111-4a4d-bbbb-123456789016'::UUID, 'Resume not attached', '2025-06-10'::DATE, 'c1e45678-1111-4a4d-cccc-123456789026'::UUID, '2025-06-11'::DATE, 'c1e45678-1111-4a4d-cccc-123456789026'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789007'::UUID, 'IN_REVIEW', 'b1e45678-1111-4a4d-bbbb-123456789017'::UUID, 'Awaiting client feedback', '2025-06-09'::DATE, 'c1e45678-1111-4a4d-cccc-123456789027'::UUID, '2025-06-10'::DATE, 'c1e45678-1111-4a4d-cccc-123456789027'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789008'::UUID, 'REJECTED', 'b1e45678-1111-4a4d-bbbb-123456789018'::UUID, 'Job closed', '2025-06-08'::DATE, 'c1e45678-1111-4a4d-cccc-123456789028'::UUID, '2025-06-09'::DATE, 'c1e45678-1111-4a4d-cccc-123456789028'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789009'::UUID, 'APPROVED', 'b1e45678-1111-4a4d-bbbb-123456789019'::UUID, 'Confirmed via call', '2025-06-07'::DATE, 'c1e45678-1111-4a4d-cccc-123456789029'::UUID, '2025-06-08'::DATE, 'c1e45678-1111-4a4d-cccc-123456789029'::UUID
                  UNION ALL
                  SELECT 'a1e45678-1111-4a4d-aaaa-123456789010'::UUID, 'PENDING', 'b1e45678-1111-4a4d-bbbb-123456789020'::UUID, 'Application in queue', '2025-06-06'::DATE, 'c1e45678-1111-4a4d-cccc-123456789030'::UUID, '2025-06-07'::DATE, 'c1e45678-1111-4a4d-cccc-123456789030'::UUID
              ) AS data
WHERE NOT EXISTS (
    SELECT 1 FROM application
);