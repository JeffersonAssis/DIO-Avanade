package com.dio.concessionaria.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dio.concessionaria.dto.EnderecoDto;

@FeignClient(name="viacep", url = "https://viacep.com.br/ws")
public interface ConsultaCep {

    @GetMapping("/{cep}/json")
    Optional<EnderecoDto> viaCep(@PathVariable String cep);
}