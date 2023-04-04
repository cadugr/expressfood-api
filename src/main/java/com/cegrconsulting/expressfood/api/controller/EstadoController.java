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

import com.cegrconsulting.expressfood.domain.exception.EntidadeEmUsoException;
import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Estado;
import com.cegrconsulting.expressfood.domain.repository.EstadoRepository;
import com.cegrconsulting.expressfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoRepository estadoRepository;

  @Autowired
  private CadastroEstadoService cadastroEstado;

  @GetMapping
  public List<Estado> listar() {
    return estadoRepository.findAll();
  }

  @GetMapping("/{estadoId}")
  public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
    Optional<Estado> estado = estadoRepository.findById(estadoId);

    if(estado.isPresent()) {
      return ResponseEntity.ok().body(estado.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Estado adicionar(@RequestBody Estado estado) {
    return cadastroEstado.salvar(estado);
  }

  @PutMapping("/{estadoId}")
  public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId,
                  @RequestBody Estado estado) {
    Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);
    
    if(estadoAtual.isPresent()) {
      BeanUtils.copyProperties(estado, estadoAtual.get(), "id");
      Estado estadoSalvo = cadastroEstado.salvar(estadoAtual.get());
      return ResponseEntity.ok(estadoSalvo);
    }

    return ResponseEntity.notFound().build();

  }

  @DeleteMapping("/{estadoId}")
  public ResponseEntity<Estado> remover(@PathVariable Long estadoId) {
    try {
      cadastroEstado.excluir(estadoId);
      return ResponseEntity.noContent().build();
      
    } catch(EntidadeNaoEncontradaException e) {
      return ResponseEntity.notFound().build();

    } catch (EntidadeEmUsoException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
  
  }
  
}
