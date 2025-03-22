package com.dio.concessionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concessionaria.dto.EnderecoDto;
import com.dio.concessionaria.dto.FuncionarioDto;
import com.dio.concessionaria.dto.FuncionarioDtoInsert;
import com.dio.concessionaria.exception.IllegalArgumentException;
import com.dio.concessionaria.exception.ObjectNotFoundException;
import com.dio.concessionaria.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    public FuncionarioDto save(FuncionarioDtoInsert fDto){

        if(!funcionarioRepository.existsById(fDto.getCpf())){
            var fun  = setFun(fDto);
            return funcionarioRepository.save(fun.funcionarioDtoToDto()).funcionarioDtoToDto();
        }        
        throw new IllegalArgumentException("Funcionário já cadastrado");
    }

    public  FuncionarioDto findByFuncionario(String cpf){
        if(funcionarioRepository.existsById(cpf)){
        var f = funcionarioRepository.findById(cpf);
        if(f.isPresent())
            return f.get().funcionarioDtoToDto();
        }
        throw new ObjectNotFoundException("Funcionário não encontrado");
    }

    private FuncionarioDto setFun(FuncionarioDtoInsert fdto){
        FuncionarioDto f = new FuncionarioDto();
        EnderecoDto end = new EnderecoDto();
        f.setCpf(fdto.getCpf());
        f.setMatricula(fdto.getMatricula());
        f.setNome(fdto.getNome());
        f.setNumend(fdto.getNumend());
        f.setSalario(fdto.getSalario());
        f.setTelefone(fdto.getTelefone());
        end = enderecoService.getCep(fdto.getCep());
        f.setEndereco(end);
        return f;
    }

}
