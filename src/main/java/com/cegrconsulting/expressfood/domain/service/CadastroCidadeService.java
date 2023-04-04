package com.cegrconsulting.expressfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Cidade;
import com.cegrconsulting.expressfood.domain.model.Estado;
import com.cegrconsulting.expressfood.domain.repository.CidadeRepository;
import com.cegrconsulting.expressfood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

  @Autowired
  private CidadeRepository cidadeRepository;

  @Autowired
  private EstadoRepository estadoRepository;

  public Cidade salvar(Cidade cidade) {
    Long estadoId = cidade.getEstado().getId();
    Estado estado = estadoRepository.findById(estadoId)
        .orElseThrow(() -> new EntidadeNaoEncontradaException(
          String.format("Não existe cadastro de estado com código %d", estadoId)));

    cidade.setEstado(estado);
    return cidadeRepository.save(cidade);
  }

  public void excluir(Long cidadeId) {
    try {
      cidadeRepository.deleteById(cidadeId);
    } catch(EmptyResultDataAccessException e) {
      throw new EntidadeNaoEncontradaException(
        String.format("Não existe um cadastro de cidade com código %d", cidadeId)
      );
    } 
  }
  
}
