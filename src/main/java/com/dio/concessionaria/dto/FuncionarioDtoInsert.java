package com.dio.concessionaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDtoInsert {

  @NotBlank(message = "CPF não pode ser vazio")
  @NotNull(message = "CPF não pode ser nulo")
  private String cpf; 
  @NotBlank(message = "Nome não pode ser vazio")
  @NotNull(message = "Nome não pode ser nulo")
  private String nome; 
  @NotBlank(message = "Telefone não pode ser vazio")
  @NotNull(message = "Telefone não pode ser nulo")
  private String telefone; 
  @NotBlank(message = "Número do endereço não pode ser vazio")
  @NotNull(message = "Número do endereço não pode ser nulo")
  private String numend;
  @NotBlank(message = "CEP não pode ser vazio")
  @NotNull(message = "CEP não pode ser nulo")
  private String cep;
  @Min(value = 0, message = "Salário não pode ser menor que 0")
  @NotNull(message = "Salário não pode ser nulo")
  private float salario;
  @NotBlank(message = "Matricula não pode ser vazio")
  @NotNull(message = "Matricula não pode ser nulo")
  private String matricula;
}
