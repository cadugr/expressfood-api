package com.cegrconsulting.expressfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> listar() {
    return manager.createQuery("from Restaurante", Restaurante.class)
    		.getResultList();
          
  }

  @Override
  public Restaurante buscar(Long id) {
    return manager.find(Restaurante.class, id);
  }

  @Override
  @Transactional
  public Restaurante salvar(Restaurante restaurante) {
    return manager.merge(restaurante);
  }

  @Override
  @Transactional
  public void remover(Restaurante restaurante) {
    restaurante = buscar(restaurante.getId());
    manager.remove(restaurante);
  }
  
}
