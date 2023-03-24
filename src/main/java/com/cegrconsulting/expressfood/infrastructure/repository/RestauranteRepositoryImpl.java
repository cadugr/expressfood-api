package com.cegrconsulting.expressfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> todos() {
    return manager.createQuery("from Restaurante", Restaurante.class)
    		.getResultList();
          
  }

  @Override
  public Restaurante porId(Long id) {
    return manager.find(Restaurante.class, id);
  }

  @Override
  @Transactional
  public Restaurante adicionar(Restaurante restaurante) {
    return manager.merge(restaurante);
  }

  @Override
  @Transactional
  public void remover(Restaurante restaurante) {
    restaurante = porId(restaurante.getId());
    manager.remove(restaurante);
  }
  
}
