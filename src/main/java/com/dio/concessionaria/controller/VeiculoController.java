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
import org.springframework.web.bind.annotation.RestController;

import com.dio.concessionaria.dto.VeiculoDto;
import com.dio.concessionaria.service.VeiculoService;
import com.dio.concessionaria.util.ValidadorBindingResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;
    

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid VeiculoDto vDto, BindingResult bindingResult) {
         ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(vDto));
    }
    
    @GetMapping("{placa}")
    public ResponseEntity<?> findByPlaca(@PathVariable String placa) {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findByPlaca(placa));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDto>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @PutMapping("{placa}")
    public ResponseEntity<?> update(@PathVariable String placa, @RequestBody VeiculoDto vDto, BindingResult bindingResult) {
        ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
        if(validadorBindingResult.hasErrors()){
          return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
        }
        return ResponseEntity.ok(veiculoService.update(placa, vDto));
        
    }

    @DeleteMapping("{placa}")
    public ResponseEntity<?> delete(@PathVariable String placa) {
             veiculoService.delete(placa);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    
    }
}
