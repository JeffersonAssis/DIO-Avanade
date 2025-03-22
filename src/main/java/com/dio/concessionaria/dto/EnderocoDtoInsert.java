package com.dio.concessionaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderocoDtoInsert {
  @NotBlank(message = "CEP não pode ser vazio")
  @NotNull(message = "CEP não pode ser nulo")
  private String cep;
}
