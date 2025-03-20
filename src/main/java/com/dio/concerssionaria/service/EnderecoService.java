package com.dio.concerssionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concerssionaria.dto.EnderecoDto;
import com.dio.concerssionaria.dto.EnderocoDtoInsert;
import com.dio.concerssionaria.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ConsultaCep consultaCep;

    public EnderecoDto consultaCep(EnderocoDtoInsert dtoInsert){
        EnderecoDto endDto = consultaCep.viaCep(dtoInsert.getCep()).get();
        endDto.setNumero(dtoInsert.getNumero());
        if(endDto.getCep().isEmpty()){
            return null;
        }
        save(endDto);
        return endDto;
    }

    public EnderecoDto save(EnderecoDto enderecoDto){
        var end =  enderecoRepository.save(enderecoDto.dtoToEnd());
        return end.endToDto();          
    }

    public EnderecoDto getCep(String cep){
        return  enderecoRepository.findById(cep).get().endToDto();
    }
}
