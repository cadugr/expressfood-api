package com.cegrconsulting.expressfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegrconsulting.expressfood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

  //List<Cozinha> consultarPorNome(String nome);
  
}
