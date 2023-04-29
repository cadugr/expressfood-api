package com.cegrconsulting.expressfood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Cidade;
import com.cegrconsulting.expressfood.domain.repository.CidadeRepository;
import com.cegrconsulting.expressfood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

  @Autowired
  private CidadeRepository cidadeRepository;

  @Autowired
  private CadastroCidadeService cadastroCidade;

  @GetMapping
  public List<Cidade> listar() {
    return cidadeRepository.findAll();
  }

  @GetMapping("/{cidadeId}")
  public Cidade buscar(@PathVariable Long cidadeId) {
    return cadastroCidade.buscarOuFalhar(cidadeId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cidade adicionar(@RequestBody Cidade cidade) {
    return cadastroCidade.salvar(cidade);    
  }

  @PutMapping("/{cidadeId}")
  public Cidade atualizar(@PathVariable Long cidadeId, 
        @RequestBody Cidade cidade) {
    Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);

    BeanUtils.copyProperties(cidade, cidadeAtual, "id");
    return cadastroCidade.salvar(cidadeAtual);
    
  }

  @DeleteMapping("/{cidadeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Long cidadeId) {
    cadastroCidade.excluir(cidadeId);
  }
  
}
