package com.cegrconsulting.expressfood.domain.repository;

import java.util.List;

import com.cegrconsulting.expressfood.domain.model.Cozinha;

public interface CozinhaRepository {

  List<Cozinha> listar();
  Cozinha porId(Long id);
  Cozinha adicionar(Cozinha cozinha);
  void remover(Cozinha cozinha);
  
}
