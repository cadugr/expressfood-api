package com.cegrconsulting.expressfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cegrconsulting.expressfood.domain.model.FormaPagamento;
import com.cegrconsulting.expressfood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<FormaPagamento> todas() {
    return manager.createQuery("from FormaPagamento", FormaPagamento.class)
      .getResultList();
  }

  @Override
  public FormaPagamento porId(Long id) {
    return manager.find(FormaPagamento.class, id);
  }

  @Transactional
  @Override
  public FormaPagamento adicionar(FormaPagamento formaPagamento) {
    return manager.merge(formaPagamento);
  }

  @Transactional
  @Override
  public void remover(FormaPagamento formaPagamento) {
    formaPagamento = porId(formaPagamento.getId());
    manager.remove(formaPagamento);
  }
  
}
