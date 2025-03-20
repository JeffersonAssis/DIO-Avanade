package com.dio.concerssionaria.dto;

import com.dio.concerssionaria.model.Veiculo;

import lombok.Data;

@Data
public class VeiculoDto {

    private String placa;
    private String cor;
    private String modelo;
    private int ano;
    private float vvalor;

    public Veiculo dtoToVeiculo(){

        Veiculo v = new Veiculo();

        v.setAno(this.ano);
        v.setCor(this.cor);
        v.setModelo(this.modelo);
        v.setPlaca(this.placa);
        v.setVvalor(this.vvalor);
        return v;
    }
}

