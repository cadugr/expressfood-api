package com.cegrconsulting.expressfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cegrconsulting.expressfood.domain.model.Restaurante;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

  // Para associações que terminem com ToOne, basta o usarmos apenas o join, pois o Hibernate já faz o fetch de forma implícita.  Para coleções, precisamos fazer o fetch.
  // Coloquei o fetch para cozinha somente para deixar explícito, mas não é necessário.
  @Query("from Restaurante r join fetch r.cozinha")
  List<Restaurante> findAll();
  List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
  //@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
  List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
  //List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);
  Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome); //vai buscar o primeiro registro, mesmo que hajam outros.
  List<Restaurante> findTop2ByNomeContaining(String nome); //Usando o Top seguido de um número, estamos buscando os primeiros registros.  Neste caso, os dois primeiros.
  int countByCozinhaId(Long cozinhaId); //Utilizamos o count para contar a quantidade de registros.  Neste caso, desejamos saber a quantidade de restaurantes, dada uma cozinha
  //List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
