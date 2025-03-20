CREATE TABLE cliente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(90) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    numend VARCHAR(20) NOT NULL,
    endereco INT,
    FOREIGN KEY (endereco) REFERENCES endereco(cep)
);

CREATE TABLE funcionario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(90) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    numend VARCHAR(20) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    endereco INT,
    FOREIGN KEY (endereco) REFERENCES endereco(cep)
);