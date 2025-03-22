package com.dio.concessionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concessionaria.dto.ClienteDto;
import com.dio.concessionaria.dto.ClienteDtoInsert;
import com.dio.concessionaria.dto.EnderecoDto;
import com.dio.concessionaria.exception.IllegalArgumentException;
import com.dio.concessionaria.exception.ObjectNotFoundException;
import com.dio.concessionaria.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public ClienteDto save(ClienteDtoInsert cDto){

        if(!clienteRepository.existsById(cDto.getCpf())){
            var c  = setCli(cDto);
            return clienteRepository.save(c.dtoToCliente()).clienteToDto();
        }        
        throw new IllegalArgumentException("Cliente já cadastrado");
    }

    public  ClienteDto findByCliente(String cpf){
        if(clienteRepository.existsById(cpf)){
        var c = clienteRepository.findById(cpf);
        if(c.isPresent())
            return c.get().clienteToDto();
        }
        throw new ObjectNotFoundException("Cliente não encontrado");
    }

    private ClienteDto setCli(ClienteDtoInsert cdto){
        ClienteDto c = new ClienteDto();
        EnderecoDto end = new EnderecoDto();
        c.setCpf(cdto.getCep());
        c.setNome(cdto.getNome());
        c.setNumend(cdto.getNumend());
        c.setTelefone(cdto.getTelefone());
        end = enderecoService.getCep(cdto.getCep());
        c.setEndereco(end);
        return c;
    }
}
