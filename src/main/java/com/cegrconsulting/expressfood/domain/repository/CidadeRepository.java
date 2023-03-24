package com.cegrconsulting.expressfood.domain.repository;

import java.util.List;

import com.cegrconsulting.expressfood.domain.model.Cidade;

public interface CidadeRepository {
  
  List<Cidade> todas();
  Cidade porId(Long id);
  Cidade adicionar(Cidade cidade);
  void remover(Cidade cidade);

}
