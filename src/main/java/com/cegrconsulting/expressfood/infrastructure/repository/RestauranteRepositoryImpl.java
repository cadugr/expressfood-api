package com.cegrconsulting.expressfood.infrastructure.repository;

import static com.cegrconsulting.expressfood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.cegrconsulting.expressfood.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepositoryQueries;

//É preciso que a classe tenha este sufixo, caso contrário não irá funcionar nosso repositório customizado
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

  @PersistenceContext
  private EntityManager manager;

  @Autowired
  @Lazy //Com essa anotação evitamos o problema de referência circular, pois estamos informando ao Spring para instanciar este tipo, somente quando for preciso, ou seja, quando formos utilizar o mesmo.
  private RestauranteRepository restauranteRepository;

  @Override
  public List<Restaurante> find(String nome, 
            BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();          
    CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class); //O CriteriaQuery é uma interface responsável por compor as cláusulas (where, from, group by, etc) das consultas.
    
    Root<Restaurante> root = criteria.from(Restaurante.class);
    var predicates = new ArrayList<Predicate>();          

    if(StringUtils.hasLength(nome)) {
      predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
    }

    if(taxaFreteInicial != null) {
      predicates.add(builder
                    .greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
    }

    if(taxaFreteFinal != null) {
      predicates.add(builder
                    .lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));              
    }  

    criteria.where(predicates.toArray(new Predicate[0]));

    TypedQuery<Restaurante> query =  manager.createQuery(criteria);
    return query.getResultList();
        
  }

  @Override
  public List<Restaurante> findComFreteGratis(String nome) {
    return restauranteRepository.findAll(comFreteGratis()
                  .and(comNomeSemelhante(nome)));
  }
  
}
