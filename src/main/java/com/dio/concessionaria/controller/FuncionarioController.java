package com.dio.concessionaria.controller;

import java.util.Objects;

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
import com.dio.concessionaria.dto.FuncionarioDtoInsert;
import com.dio.concessionaria.service.FuncionarioService;
import com.dio.concessionaria.util.ValidadorBindingResult;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/fun")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid FuncionarioDtoInsert fDto, BindingResult bindingResult) {
       ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(fDto));
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> getMethodName(@RequestParam String cpf) {
        var fun = funcionarioService.findByFuncionario(cpf);
        if(Objects.nonNull(fun))
        return ResponseEntity.status(HttpStatus.OK).body(fun);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
