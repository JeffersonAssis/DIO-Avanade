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
import com.dio.concerssionaria.dto.FuncionarioDtoInsert;
import com.dio.concerssionaria.service.FuncionarioService;


@RestController
@RequestMapping("/fun")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FuncionarioDtoInsert fDto){
        var fun =  funcionarioService.save(fDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fun);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> getMethodName(@RequestParam String cpf) {
        var fun = funcionarioService.findByFuncionario(cpf);
        if(Objects.nonNull(fun))
        return ResponseEntity.status(HttpStatus.OK).body(fun);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
