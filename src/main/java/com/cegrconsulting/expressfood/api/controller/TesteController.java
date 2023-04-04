package com.cegrconsulting.expressfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.cegrconsulting.expressfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

  @Autowired
  private CozinhaRepository cozinhaRepository;

  @GetMapping("/cozinhas/por-nome")
  public List<Cozinha> cozinhasPorNome(String nome) {
    return cozinhaRepository.consultarPorNome(nome);
  }
  
}
