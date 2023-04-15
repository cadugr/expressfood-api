package com.cegrconsulting.expressfood.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //Com esta anotação estamos dizendo ao Spring para não instanciar um objeto deste tipo
//Estamos utilizando Generics aqui para criar nosso repositório customizado
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID>{

  Optional<T> buscarPrimeiro();
  
}
