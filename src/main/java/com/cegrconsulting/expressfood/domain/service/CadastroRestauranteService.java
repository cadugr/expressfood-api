package com.cegrconsulting.expressfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

  private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe cadastro de restaurante com código %d";

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CadastroCozinhaService cadastroCozinha;

  public Restaurante salvar(Restaurante restaurante) {
    Long cozinhaId = restaurante.getCozinha().getId();
    Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

    restaurante.setCozinha(cozinha);
    return restauranteRepository.save(restaurante);
  }

  public Restaurante buscarOuFalhar(Long restauranteId) {
    return restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new EntidadeNaoEncontradaException(
          String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
  }
  
}
