package com.dio.concerssionaria.model;

import com.dio.concerssionaria.dto.ClienteDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Cliente extends Pessoa {
    

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    private Endereco endereco;
    
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
