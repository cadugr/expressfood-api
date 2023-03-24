package com.cegrconsulting.expressfood.domain.repository;

import java.util.List;

import com.cegrconsulting.expressfood.domain.model.Restaurante;

public interface RestauranteRepository {
  
  List<Restaurante> todos();
  Restaurante porId(Long id);
  Restaurante adicionar(Restaurante restaurante);
  void remover(Restaurante restaurante);

}
