CREATE TABLE loja_de_compras (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT
);

CREATE TABLE filamentos (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    marca TEXT NOT NULL,
    cor TEXT NOT NULL,
    peso INT NOT NULL,
    valor DECIMAL(9,2) NOT NULL,
    data_compra TIMESTAMP NOT NULL,
    id_loja INT,
    FOREIGN KEY (id_loja) REFERENCES loja_de_compras(id)
);

CREATE TABLE equipamento (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT,
    valor DECIMAL(9,2),
    descricao TEXT
);

CREATE TABLE pecas (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT,
    id_filamento INT,
    id_equipamento INT,
    data_inicial TIMESTAMP,
    data_final TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (id_filamento) REFERENCES filamentos(id),
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id)
);

CREATE TABLE status (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT
);

CREATE TABLE financeiro (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_pecas INT,
    valor_custo DECIMAL(9,2),
    valor_final DECIMAL(9,2),
    id_status INT,
    quantidade INT,
    FOREIGN KEY (id_status) REFERENCES status(id),
    FOREIGN KEY (id_pecas) REFERENCES pecas(id)
);

CREATE TABLE cliente (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT NOT NULL,
    telefone TEXT,
    email TEXT
);

CREATE TABLE status_pagamento (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome TEXT
);

CREATE TABLE pedido (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_financeiro INT,
    id_cliente INT,
    status_pagamento INT,
    FOREIGN KEY (id_financeiro) REFERENCES financeiro(id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (status_pagamento) REFERENCES status_pagamento(id)
);
