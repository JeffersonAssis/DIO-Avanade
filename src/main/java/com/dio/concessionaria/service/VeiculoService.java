package com.dio.concessionaria.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.concessionaria.dto.VeiculoDto;
import com.dio.concessionaria.exception.ObjectNotFoundException;
import com.dio.concessionaria.model.Veiculo;
import com.dio.concessionaria.repository.VeiculoRepository;


@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDto save(VeiculoDto vDto){
        if(!veiculoRepository.existsById(vDto.getPlaca())){
            return veiculoRepository.save(vDto.dtoToVeiculo()).veiculoToDto();
        } 
        throw new IllegalArgumentException("Veículo já cadastrado");
    }

    public List<VeiculoDto> findAll() {
    return veiculoRepository.findAll().stream()
                            .map(Veiculo::veiculoToDto)
                            .collect(Collectors.toList());
    }

public VeiculoDto findByPlaca(String placa) {
    if (veiculoRepository.existsById(placa)) {
        return veiculoRepository.findById(placa).get().veiculoToDto();
    }
    throw new ObjectNotFoundException("Veículo não encontrado");
}

public VeiculoDto update(String placa, VeiculoDto vDto) {
    if (veiculoRepository.existsById(placa)) {
        VeiculoDto existingVeiculo = veiculoRepository.findById(placa).get().veiculoToDto();
        existingVeiculo.setModelo(vDto.getModelo());
        existingVeiculo.setAno(vDto.getAno());
        existingVeiculo.setCor(vDto.getCor());
        existingVeiculo.setVvalor(vDto.getVvalor());
        veiculoRepository.save(existingVeiculo.dtoToVeiculo());
        return existingVeiculo;
    }
    throw new ObjectNotFoundException("Veículo não encontrado");
}

    public void delete(String placa) {
        if (veiculoRepository.existsById(placa)){
            var v = veiculoRepository.findById(placa);
            veiculoRepository.deleteById(placa);
        }else{
            throw new ObjectNotFoundException("Veículo não encontrado");
        }     
      
    } 
}
