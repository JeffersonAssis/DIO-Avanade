package com.dio.concessionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concessionaria.dto.ClienteDtoInsert;
import com.dio.concessionaria.service.ClienteService;
import com.dio.concessionaria.util.ValidadorBindingResult;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ClienteDtoInsert cDto, BindingResult bindingResult) {
        ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cDto));
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> findById(@RequestParam String cpf) {
       
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByCliente(cpf));
    }
}
