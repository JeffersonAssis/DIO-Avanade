package com.dio.concessionaria.dto;

import lombok.Data;

@Data
public class PessoaDto {

    
    private String cpf;

    private String nome;
 
    private String telefone;
   
    private String numend;
    
    private EnderecoDto endereco;
}
