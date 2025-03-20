package com.dio.concerssionaria.model;

import com.dio.concerssionaria.dto.ClienteDto;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    
    public ClienteDto clienteToDto(){
        ClienteDto cDto = new ClienteDto();
        cDto.setCpf(this.getCpf());
        cDto.setEndereco(this.getEndereco().endToDto());
        cDto.setNome(this.getNome());
        cDto.setTelefone(this.getTelefone());
        cDto.setNumend(this.getNumend());
        return cDto;  
    }
}
