CREATE TABLE venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,         
    valor FLOAT NOT NULL,                           
    vdata DATE NOT NULL,                    
    funcionario VARCHAR(255) NOT NULL,          
    cliente VARCHAR(255) NOT NULL,              
    veiculo VARCHAR(255) NOT NULL,                              
    CONSTRAINT fk_funcionario FOREIGN KEY (funcionario) REFERENCES funcionario(cpf),          
    CONSTRAINT fk_cliente FOREIGN KEY (cliente) REFERENCES cliente(cpf),           
    CONSTRAINT fk_veiculo FOREIGN KEY (veiculo) REFERENCES veiculo(placa)                    
);