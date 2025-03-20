package com.dio.concerssionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concerssionaria.dto.ClienteDto;
import com.dio.concerssionaria.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto save(ClienteDto cDto){
        if(!clienteRepository.existsById(cDto.getCpf())){
            return clienteRepository.save(cDto.dtoToCliente()).clienteToDto();
        }        
        return null;
    }

    public  ClienteDto findByCliente(String cpf){
        if(!clienteRepository.existsById(cpf)){
        var c = clienteRepository.findById(cpf).get();
        return c.clienteToDto();
        }
        return null;
    }
}
