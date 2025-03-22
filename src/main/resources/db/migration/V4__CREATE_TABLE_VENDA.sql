CREATE TABLE venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,         
    valor FLOAT NOT NULL,                           
    vdata VARCHAR(255) NOT NULL,                    
    cpf_funcionario VARCHAR(255) NOT NULL,          
    cpf_cliente VARCHAR(255) NOT NULL,              
    veiculo_id BIGINT,                              
    CONSTRAINT fk_funcionario FOREIGN KEY (cpf_funcionario) REFERENCES funcionario(cpf),          
    CONSTRAINT fk_cliente FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),           
    CONSTRAINT fk_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculo(id)                    
);