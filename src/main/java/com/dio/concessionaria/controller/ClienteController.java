package com.dio.concessionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concessionaria.dto.ClienteDto;
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

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ClienteDto> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("{cpf}")
    public ResponseEntity<?> update(@PathVariable String cpf, @RequestBody ClienteDtoInsert cDto) {
        return ResponseEntity.ok(clienteService.update(cpf, cDto));
        
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity<?> delete(@PathVariable String cpf) {
        clienteService.delete(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }
}
