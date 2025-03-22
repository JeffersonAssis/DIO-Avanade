package com.dio.concessionaria.dto;


import com.dio.concessionaria.model.Veiculo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VeiculoDto {

    @NotBlank(message = "Placa não pode ser vazia")
    @NotNull(message = "Placa não pode ser nula")
    @Size(min = 7, max = 7, message = "Placa deve ter 7 caracteres")
    private String placa;
    @NotBlank(message = "Cor não pode ser vazia")
    @NotNull(message = "Cor não pode ser nula")
    private String cor;
    @NotBlank(message = "Modelo não pode ser vazio")
    @NotNull(message = "Modelo não pode ser nulo")
    private String modelo;
    @NotNull(message = "Ano não pode ser nulo")
    @Min(value = 1000, message = "Ano tem que ser informado por 4 dígitos")
    private int ano;
    @NotNull(message = "Valor não pode ser nulo")
    @Min(value = 0, message = "Valor não pode ser menor que 0")
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

