ALTER TABLE pedido
    ADD COLUMN IF NOT EXISTS nome TEXT,
    ADD COLUMN IF NOT EXISTS descricao TEXT,
    ADD COLUMN IF NOT EXISTS categoria TEXT,
    ADD COLUMN IF NOT EXISTS material TEXT,
    ADD COLUMN IF NOT EXISTS cor TEXT,
    ADD COLUMN IF NOT EXISTS prazo_producao INT,
    ADD COLUMN IF NOT EXISTS quantidade INT,
    ADD COLUMN IF NOT EXISTS valor_unitario DECIMAL(9,2);

UPDATE pedido
SET
    nome = COALESCE(nome, 'Não informado'),
    descricao = COALESCE(descricao, 'Não informado'),
    categoria = COALESCE(categoria, 'Não informado'),
    material = COALESCE(material, 'Não informado'),
    cor = COALESCE(cor, 'Não informado'),
    prazo_producao = COALESCE(prazo_producao, 0),
    quantidade = COALESCE(quantidade, 1),
    valor_unitario = COALESCE(valor_unitario, 0.00);

ALTER TABLE pedido
    ALTER COLUMN nome SET NOT NULL,
    ALTER COLUMN descricao SET NOT NULL,
    ALTER COLUMN categoria SET NOT NULL,
    ALTER COLUMN material SET NOT NULL,
    ALTER COLUMN cor SET NOT NULL,
    ALTER COLUMN prazo_producao SET NOT NULL,
    ALTER COLUMN quantidade SET NOT NULL,
    ALTER COLUMN valor_unitario SET NOT NULL;
