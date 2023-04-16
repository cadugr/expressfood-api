package com.cegrconsulting.expressfood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CadastroRestauranteService cadastroRestaurante;

  @GetMapping
  public List<Restaurante> listar() {
    return restauranteRepository.findAll();
  }

  @GetMapping("/{restauranteId}")
  public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
    Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);

    if (restaurante.isPresent()) {
      return ResponseEntity.ok(restaurante.get());
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
    Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
    if (restauranteAtual.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id", "formasPagamento", "endereco", "dataCadastro");
    try {
      Restaurante restauranteSalvo = cadastroRestaurante.salvar(restauranteAtual.get());
      return ResponseEntity.ok().body(restauranteSalvo);
    } catch (EntidadeNaoEncontradaException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping("/{restauranteId}")
  public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos) {
    Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

    if (restauranteAtual.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    merge(campos, restauranteAtual.get());

    return atualizar(restauranteId, restauranteAtual.get());
  }

  private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {

    ObjectMapper objectMapper = new ObjectMapper();
    Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class); // necessário para já
                                                                                               // converter todos os
                                                                                               // valores. Se não
                                                                                               // fizermos, teremos
                                                                                               // erros de conversão

    dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
      Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
      field.setAccessible(true); // permite que possamos acessar o atributo privado fora da classe
      Object novoValor = ReflectionUtils.getField(field, restauranteOrigem); // Desta forma estamos buscando o campo que
                                                                             // desejamos dentro do objeto
                                                                             // restauranteOrigem

      ReflectionUtils.setField(field, restauranteDestino, novoValor);
    });
  }

}
