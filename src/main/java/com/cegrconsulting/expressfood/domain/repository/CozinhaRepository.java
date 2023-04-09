package com.cegrconsulting.expressfood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegrconsulting.expressfood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

  //Entre o find e o By, podemos inserir o que quisermos que não afeta o funcionamento
  List<Cozinha> findTodasByNomeContaining (String nome);
  Optional<Cozinha> findByNome(String nome);
  boolean existsByNome(String nome); //busca pelo nome exato e se existir, retorna true e se não existir, retorna false.
  
}
