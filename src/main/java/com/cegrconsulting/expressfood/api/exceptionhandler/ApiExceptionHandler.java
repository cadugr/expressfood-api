package com.cegrconsulting.expressfood.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cegrconsulting.expressfood.domain.exception.EntidadeEmUsoException;
import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler { //Esta classe abstrata já trata por padrão diversas exceções

  @ExceptionHandler(EntidadeNaoEncontradaException.class)
  public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;
    String detail = ex.getMessage();

    Problem problem = createProblemBuilder(status, problemType, detail).build();
    // Problem problem = Problem.builder()
    //     .status(status.value())
    //     .type("https://expressfood.com.br/entidade-nao-encontrada")
    //     .title("Entidade não encontrada")
    //     .detail(ex.getMessage())
    //     .build();

    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(EntidadeEmUsoException.class)
  public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException ex, WebRequest request) {
    
    HttpStatus status = HttpStatus.CONFLICT;
    ProblemType problemType = ProblemType.ENTIDADE_EM_USO;
    String detail = ex.getMessage();

    Problem problem = createProblemBuilder(status, problemType, detail).build();
    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(NegocioException.class)
  public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request) {
    
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ProblemType problemType = ProblemType.ERRO_DE_NEGOCIO;
    String detail = ex.getMessage();

    Problem problem = createProblemBuilder(status, problemType, detail).build();
    return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    if(body == null) {
      body = Problem.builder()
      .title(status.getReasonPhrase())
      .status(status.value())
      .build();
    } else if (body instanceof String) {
      body = Problem.builder()
      .title((String) body)
      .status(status.value())
      .build();
    }    
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
        ProblemType problemType, String detail) {
        return Problem.builder()
            .status(status.value())
            .type(problemType.getUri())
            .title(problemType.getTitle())
            .detail(detail);  
  }
  
}
