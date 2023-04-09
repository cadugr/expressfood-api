package com.cegrconsulting.expressfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepositoryQueries;

//É preciso que a classe tenha este sufixo, caso contrário não irá funcionar nosso repositório customizado
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> find(String nome, 
            BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
    var jpql = "from Restaurante where nome " 
        + "like :nome and taxaFrete between :taxaInicial and :taxaFinal";

    return manager.createQuery(jpql, Restaurante.class)
              .setParameter("nome", "%" + nome + "%")
              .setParameter("taxaInicial", taxaFreteInicial)
              .setParameter("taxaFinal", taxaFreteFinal)
              .getResultList();
        
  }
  
}
