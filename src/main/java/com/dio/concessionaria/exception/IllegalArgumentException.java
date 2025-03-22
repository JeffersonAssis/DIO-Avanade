package com.dio.concessionaria.exception;

public class IllegalArgumentException extends RuntimeException{
  
  public IllegalArgumentException(String mensagem){
    super(mensagem);
  }
}
