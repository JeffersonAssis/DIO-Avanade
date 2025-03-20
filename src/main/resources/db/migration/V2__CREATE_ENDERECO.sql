CREATE TABLE endereco (
    cep VARCHAR(10) PRIMARY KEY,
    uf VARCHAR(2) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    localidade VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL
);