package com.dio.concessionaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.concessionaria.dto.VeiculoDto;
import com.dio.concessionaria.repository.VeiculoRepository;


@Service
public class VeiculoService {

   

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDto save(VeiculoDto vDto){
        if(!veiculoRepository.existsByPlaca(vDto.getPlaca())){
            return veiculoRepository.save(vDto.dtoToVeiculo()).veiculoToDto();
        } 
        throw new IllegalArgumentException("Veículo já cadastrado");
    }
}
