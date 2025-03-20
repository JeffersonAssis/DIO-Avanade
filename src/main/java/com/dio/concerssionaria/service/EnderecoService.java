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
        if(!enderecoRepository.existsById(dtoInsert.cep())){
        var endDto = consultaCep.viaCep(dtoInsert.cep());
         if(endDto.isPresent()){
                save(endDto.get());
                return endDto.get();
        }
               
        return endDto.get();
    }
      var end = enderecoRepository.findById(dtoInsert.cep());
      return end.get().endToDto() ;
    }

    public void save(EnderecoDto enderecoDto){
      enderecoRepository.save(enderecoDto.dtoToEnd());
            
    }

    public EnderecoDto getCep(String cep){
        EnderocoDtoInsert e = new EnderocoDtoInsert(cep);
        EnderecoDto end = consultaCep(e);
        return  end;
    }
}
