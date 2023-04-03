package com.cegrconsulting.expressfood.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegrconsulting.expressfood.domain.exception.EntidadeNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;
import com.cegrconsulting.expressfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CadastroRestauranteService cadastroRestaurante;

  @GetMapping
  public List<Restaurante> listar() {
    return restauranteRepository.listar();
  }

  @GetMapping("/{restauranteId}")
  public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
    Restaurante restaurante = restauranteRepository.buscar(restauranteId);

    if(restaurante != null) {
      return ResponseEntity.ok(restaurante);
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
    try {
      restaurante = cadastroRestaurante.salvar(restaurante);

      return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    } catch (EntidadeNaoEncontradaException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    
  }

  @PutMapping("/{restauranteId}")
  public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, 
        @RequestBody Restaurante restaurante) {
    Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
    if(restauranteAtual == null) {
      return ResponseEntity.notFound().build();
    }        

    BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
    try {
      restauranteAtual = cadastroRestaurante.salvar(restauranteAtual);
      return ResponseEntity.ok().body(restauranteAtual);
    } catch (EntidadeNaoEncontradaException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping("/{restauranteId}")
  public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos) {
    Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
    
    if(restauranteAtual == null) {
      return ResponseEntity.notFound().build();
    }

    merge(campos, restauranteAtual);

    return atualizar(restauranteId, restauranteAtual);
  }

  private void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino) {
    camposOrigem.forEach((nomePropriedade, valorPropriedade) -> {
      System.out.println(nomePropriedade + " = " + valorPropriedade);
    });
  }
  
}
