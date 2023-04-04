package com.cegrconsulting.expressfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cegrconsulting.expressfood.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
  
}
