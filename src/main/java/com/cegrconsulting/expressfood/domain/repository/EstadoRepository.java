package com.cegrconsulting.expressfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cegrconsulting.expressfood.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
  
}
