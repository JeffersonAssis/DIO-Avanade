package com.dio.concerssionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concerssionaria.dto.EnderecoDto;
import com.dio.concerssionaria.dto.FuncionarioDto;
import com.dio.concerssionaria.dto.FuncionarioDtoInsert;
import com.dio.concerssionaria.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    public FuncionarioDto save(FuncionarioDtoInsert fDto){

        if(!funcionarioRepository.existsById(fDto.cpf())){
            var fun  = setFun(fDto);
            return funcionarioRepository.save(fun.funcionarioDtoToDto()).funcionarioDtoToDto();
        }        
        return null;
    }

    public  FuncionarioDto findByFuncionario(String cpf){
        if(funcionarioRepository.existsById(cpf)){
        var f = funcionarioRepository.findById(cpf);
        if(f.isPresent())
            return f.get().funcionarioDtoToDto();
        }
        return null;
    }

    private FuncionarioDto setFun(FuncionarioDtoInsert fdto){
        FuncionarioDto f = new FuncionarioDto();
        EnderecoDto end = new EnderecoDto();
        f.setCpf(fdto.cpf());
        f.setMatricula(fdto.matricula());
        f.setNome(fdto.nome());
        f.setNumend(fdto.numend());
        f.setSalario(fdto.salario());
        f.setTelefone(fdto.telefone());
        end = enderecoService.getCep(fdto.cep());
        f.setEndereco(end);
        return f;
    }

}
