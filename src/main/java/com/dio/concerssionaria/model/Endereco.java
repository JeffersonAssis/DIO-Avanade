package com.dio.concerssionaria.model;

import com.dio.concerssionaria.dto.EnderecoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Endereco {

    @Id
    private String cep;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String localidade;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String numero;

    public EnderecoDto endToDto(){
        EnderecoDto endDto = new EnderecoDto();
        endDto.setCep(this.cep);
        endDto.setBairro(this.bairro);
        endDto.setLocalidade(this.localidade);
        endDto.setLogradouro(this.logradouro);
        endDto.setUf(this.uf);
        endDto.setNumero(this.numero);

        return endDto;
    }
}
