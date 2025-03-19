package com.dio.concerssionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concerssionaria.dto.VeiculoDto;
import com.dio.concerssionaria.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDto save(VeiculoDto vDto) {
      if(!veiculoRepository.existsByPlaca(vDto.getPlaca())){
        return veiculoRepository.save(vDto.dtoToVeiculo()).veiculoToDto();
      }
      return null;
    }

}
