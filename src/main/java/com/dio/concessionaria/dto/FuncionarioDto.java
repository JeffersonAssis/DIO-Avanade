package com.dio.concessionaria.dto;

import com.dio.concessionaria.model.Funcionario;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class FuncionarioDto extends PessoaDto {

    private String matricula;
    private float salario;

    public Funcionario funcionarioDtoToDto(){
        Funcionario fun = new Funcionario();
            fun.setCpf(this.getCpf());
            fun.setEndereco(this.getEndereco().dtoToEnd());
            fun.setNome(this.getNome());
            fun.setTelefone(this.getTelefone());
            fun.setNumend(this.getNumend());
            fun.setMatricula(this.matricula);
            fun.setSalario(this.salario);
            return fun;  
        }
}
