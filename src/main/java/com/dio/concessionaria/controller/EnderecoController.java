package com.dio.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concessionaria.dto.EnderocoDtoInsert;
import com.dio.concessionaria.service.EnderecoService;
import com.dio.concessionaria.util.ValidadorBindingResult;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/end")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid EnderocoDtoInsert vDto, BindingResult bindingResult) {
        ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.consultaCep(vDto));
    }

    @GetMapping("{cep}")
    public ResponseEntity<?> getMethodName(@RequestParam String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getCep(cep));
    }
    

}
