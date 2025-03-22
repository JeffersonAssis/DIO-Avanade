package com.dio.concessionaria.exception;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionEntity {

   @JsonFormat(pattern = "HH:mm - dd/MM/yyyy")
    private LocalDateTime timetesmp;
    private String mensagem;
    private int status;
    private String path;
}
