package com.dio.concerssionaria.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concerssionaria.dto.ClienteDto;
import com.dio.concerssionaria.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteDto cDto){
        var c =  clienteService.save(cDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> getMethodName(@RequestParam String cpf) {
        var c = clienteService.findByCliente(cpf);
        if(Objects.nonNull(c))
        return ResponseEntity.status(HttpStatus.OK).body(c);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
