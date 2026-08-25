ALTER TABLE filamentos
    ADD COLUMN IF NOT EXISTS tipo TEXT;

UPDATE filamentos
SET tipo = 'Não informado'
WHERE tipo IS NULL;

ALTER TABLE filamentos
    ALTER COLUMN tipo SET NOT NULL;

ALTER TABLE filamentos
    DROP COLUMN IF EXISTS custo;
