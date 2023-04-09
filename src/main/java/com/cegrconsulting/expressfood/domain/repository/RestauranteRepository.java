package com.cegrconsulting.expressfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cegrconsulting.expressfood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

  List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
  @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
  List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
  //List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);
  Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome); //vai buscar o primeiro registro, mesmo que hajam outros.
  List<Restaurante> findTop2ByNomeContaining(String nome); //Usando o Top seguido de um número, estamos buscando os primeiros registros.  Neste caso, os dois primeiros.
  int countByCozinhaId(Long cozinhaId); //Utilizamos o count para contar a quantidade de registros.  Neste caso, desejamos saber a quantidade de restaurantes, dada uma cozinha

}
