package com.cegrconsulting.expressfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cegrconsulting.expressfood.domain.exception.EntidadeEmUsoException;
import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.cegrconsulting.expressfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
  
  private static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser removida, pois está em uso";
  private static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com código %d";

  @Autowired
  private CozinhaRepository cozinhaRepository;

  public Cozinha salvar(Cozinha cozinha) {
    return cozinhaRepository.save(cozinha);
  }

  public void excluir(Long cozinhaId) {
    try {
      cozinhaRepository.deleteById(cozinhaId);
    } catch(EmptyResultDataAccessException e) {
      //Esta classe veio a partir do Spring 5.
      // Contudo, utilizar esta exceção que foi criada para manipular a resposta http em uma classe de domínio, não é o ideal.
      // throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
      //         String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
      throw new EntidadeNaoEncontradaException(
        String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)
      );
    } 
    catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
        String.format(MSG_COZINHA_EM_USO, cozinhaId)
      );
    }
  }

  public Cozinha buscarOuFalhar(Long cozinhaId) {
    return cozinhaRepository.findById(cozinhaId)
        .orElseThrow(()-> new EntidadeNaoEncontradaException(
          String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
  }

}
