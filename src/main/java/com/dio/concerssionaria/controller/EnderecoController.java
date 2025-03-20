package com.dio.concerssionaria.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concerssionaria.dto.EnderocoDtoInsert;
import com.dio.concerssionaria.service.EnderecoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/end")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody EnderocoDtoInsert vDto){
        var end =  enderecoService.consultaCep(vDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(end);
    }

    @GetMapping("{cep}")
    public ResponseEntity<?> getMethodName(@RequestParam String cep) {
        var end = enderecoService.getCep(cep);
        if(Objects.nonNull(end))
        return ResponseEntity.status(HttpStatus.OK).body(end);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    

}
