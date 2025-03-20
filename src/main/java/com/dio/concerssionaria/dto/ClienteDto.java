package com.dio.concerssionaria.dto;

import com.dio.concerssionaria.model.Cliente;

public class ClienteDto extends PessoaDto {
    
    public Cliente dtoToCliente(){
        Cliente c = new Cliente();
        c.setCpf(this.getCpf());
        c.setEndereco(this.getEndereco().dtoToEnd());
        c.setNome(this.getNome());
        c.setTelefone(this.getTelefone());
        c.setNumend(this.getNumend());
        return c;  
    }
}
