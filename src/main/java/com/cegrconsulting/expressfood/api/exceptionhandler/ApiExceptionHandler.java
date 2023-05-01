package com.cegrconsulting.expressfood.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cegrconsulting.expressfood.domain.exception.EntidadeEmUsoException;
import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler { //Esta classe abstrata já trata por padrão diversas exceções

  @ExceptionHandler(EntidadeNaoEncontradaException.class)
  public ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e) {
    Problema problema = Problema.builder()
        .dataHora(LocalDateTime.now())
        .mensagem(e.getMessage())
        .build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
  }

  @ExceptionHandler(NegocioException.class)
  public ResponseEntity<?> tratarNegocioException(NegocioException e) {
    Problema problema = Problema.builder()
        .dataHora(LocalDateTime.now())
        .mensagem(e.getMessage())
        .build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
  }

  @ExceptionHandler(EntidadeEmUsoException.class)
  public ResponseEntity<?> tratarEntidadeEmUsoException(EntidadeEmUsoException e) {
    Problema problema = Problema.builder()
    .dataHora(LocalDateTime.now())
    .mensagem(e.getMessage())
    .build();

    return ResponseEntity.status(HttpStatus.CONFLICT).body(problema);
  }
  
}
