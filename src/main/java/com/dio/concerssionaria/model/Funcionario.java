package com.dio.concerssionaria.model;

import com.dio.concerssionaria.dto.FuncionarioDto;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa {

    private String matricula;
    private float salario;

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
