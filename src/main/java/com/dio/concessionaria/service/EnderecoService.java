package com.dio.concessionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.concessionaria.dto.EnderecoDto;
import com.dio.concessionaria.dto.EnderocoDtoInsert;
import com.dio.concessionaria.exception.IllegalArgumentException;
import com.dio.concessionaria.exception.ObjectNotFoundException;
import com.dio.concessionaria.repository.EnderecoRepository;

import feign.FeignException;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ConsultaCep consultaCep;

    public EnderecoDto consultaCep(EnderocoDtoInsert dtoInsert) {
      String cep = dtoInsert.getCep();
      if (!cep.matches("\\d{8}")  && !enderecoRepository.existsById(cep) ) {
          throw new IllegalArgumentException("CEP inválido: " + cep);
      }
            try {
              var endDto = consultaCep.viaCep(cep);
              if(endDto.get().getCep() == null){
                  throw new ObjectNotFoundException("CEP não encontrado: " + cep);
              }
                if (endDto.isPresent()) {
                  save(endDto.get());
                  return endDto.get();
              }
          } catch (FeignException.NotFound | FeignException.InternalServerError e) {
              throw new ObjectNotFoundException("CEP não encontrado: " + cep);
          } catch (FeignException.BadRequest e) {
              throw new IllegalArgumentException("Erro ao buscar o CEP: " + cep);
          }

      var end = enderecoRepository.findById(cep);
      return end.get().endToDto();
}
    public void save(EnderecoDto enderecoDto){
      enderecoRepository.save(enderecoDto.dtoToEnd());
            
    }

    public EnderecoDto getCep(String cep){
        EnderocoDtoInsert e = new EnderocoDtoInsert();
        e.setCep(cep);
        EnderecoDto end = consultaCep(e);
        return  end;
    }
}
