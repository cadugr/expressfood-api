package com.cegrconsulting.expressfood.domain.repository;

import java.util.List;

import com.cegrconsulting.expressfood.domain.model.Cozinha;

public interface CozinhaRepository {

  List<Cozinha> todas();
  Cozinha porId(Long id);
  Cozinha adicionar(Cozinha cozinha);
  void remover(Cozinha cozinha);
  
}
