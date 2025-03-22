package com.dio.concessionaria.controller;

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
import com.dio.concessionaria.dto.VendaDtoInsert;
import com.dio.concessionaria.service.VendaService;
import com.dio.concessionaria.util.ValidadorBindingResult;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/venda")
public class VendaController {

  
  @Autowired
  private VendaService vendaService;

  @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid VendaDtoInsert vDto, BindingResult bindingResult) {
        ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }

        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(vDto));
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> findById(@RequestParam String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.findByFuncionario(cpf));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

    @PutMapping("{cpf}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid VendaDtoInsert vDto, BindingResult bindingResult) {
      ValidadorBindingResult validadorBindingResult = new ValidadorBindingResult(bindingResult);
      if(validadorBindingResult.hasErrors()){
        return ResponseEntity.badRequest().body(validadorBindingResult.getErrors());
      }
      
      return ResponseEntity.ok(vendaService.update( id, vDto));
        
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
      vendaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        
    }

  
}
