package com.cegrconsulting.expressfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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

    CriteriaBuilder builder = manager.getCriteriaBuilder();          
    CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class); //O CriteriaQuery é uma interface responsável por compor as cláusulas (where, from, group by, etc) das consultas.
    
    criteria.from(Restaurante.class);

    TypedQuery<Restaurante> query =  manager.createQuery(criteria);
    return query.getResultList();
        
  }
  
}
