package com.dio.concerssionaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.concerssionaria.dto.VeiculoDto;
import com.dio.concerssionaria.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;
    

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VeiculoDto vDto){
        var veiculo =  veiculoService.save(vDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

}
