package com.dio.concessionaria.model;

import com.dio.concessionaria.dto.VeiculoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Veiculo {
    
    @Id
    private String placa;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private float vvalor;

    public VeiculoDto veiculoToDto(){
        VeiculoDto vDto = new  VeiculoDto();

        vDto.setAno(this.ano);
        vDto.setCor(this.cor);
        vDto.setModelo(this.modelo);
        vDto.setPlaca(this.placa);
        vDto.setVvalor(this.vvalor);
        return vDto;
    }

}
