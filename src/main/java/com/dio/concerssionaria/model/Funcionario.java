package com.dio.concerssionaria.model;

import com.dio.concerssionaria.dto.FuncionarioDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa {

    private String matricula;
    private float salario;
    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    private Endereco endereco;

   public FuncionarioDto funcionarioDtoToDto(){
    FuncionarioDto funDto = new FuncionarioDto();
        funDto.setCpf(this.getCpf());
        funDto.setEndereco(this.getEndereco().endToDto());
        funDto.setNome(this.getNome());
        funDto.setTelefone(this.getTelefone());
        funDto.setNumend(this.getNumend());
        funDto.setMatricula(this.matricula);
        funDto.setSalario(this.salario);
        return funDto;  
    }

}
