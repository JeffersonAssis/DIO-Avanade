package com.dio.concessionaria.util;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

public class ValidadorBindingResult {

  private final BindingResult bindingResult;

  public ValidadorBindingResult( BindingResult bindingResult){
    this.bindingResult = bindingResult;
  }
  
  public boolean hasErrors(){
    return bindingResult.hasErrors();
  }

  public List<String> getErrors(){
    return bindingResult.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
  }
}
