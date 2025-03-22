package com.dio.concessionaria.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VendaDtoInsert {


    @NotNull(message = "Valor não pode ser nulo")
    private float valor;
    @NotNull(message = "Data não pode ser nula")
    private LocalDate vdata;
    @NotBlank(message = "CPF do funcionário não pode ser vazio")
    @NotNull(message = "CPF do funcionário não pode ser nulo")
    private String idFuncionario;
    @NotBlank(message = "CPF do cliente não pode ser vazio")
    @NotNull(message = "CPF do cliente não pode ser nulo")
    private String idCliente;
    @NotBlank(message = "Placa do veículo não pode ser vazia")
    @NotNull(message = "Placa do veículo não pode ser nula")
    private String placaVeiculo;

  }