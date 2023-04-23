package com.cegrconsulting.expressfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta é uma forma elegante de customizarmos o código de status retornado para o erro, porém, não permite, por exemplo customizarmos o corpo da resposta, no máximo a mensagem
@ResponseStatus(code = HttpStatus.NOT_FOUND) //reason = "Entidade não encontrada!")
public class EntidadeNaoEncontradaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EntidadeNaoEncontradaException(String mensagem) {
    super(mensagem);
  }
  
}
