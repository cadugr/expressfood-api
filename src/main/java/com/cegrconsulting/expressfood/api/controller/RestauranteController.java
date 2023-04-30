package com.cegrconsulting.expressfood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cegrconsulting.expressfood.domain.exception.CozinhaNaoEncontradaException;
import com.cegrconsulting.expressfood.domain.exception.NegocioException;
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
  public Restaurante buscar(@PathVariable Long restauranteId) {
    return cadastroRestaurante.buscarOuFalhar(restauranteId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Restaurante adicionar(@RequestBody Restaurante restaurante) {
    try {
      return cadastroRestaurante.salvar(restaurante);
    } catch (CozinhaNaoEncontradaException e) {
      throw new NegocioException(e.getMessage(), e);
    }  
  }

  @PutMapping("/{restauranteId}")
  public Restaurante atualizar(@PathVariable Long restauranteId,
      @RequestBody Restaurante restaurante) {
    try {
      Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);  
      BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro");
      return cadastroRestaurante.salvar(restauranteAtual);
    } catch (CozinhaNaoEncontradaException e) {
      throw new NegocioException(e.getMessage(), e);
    }
    
  }

  @PatchMapping("/{restauranteId}")
  public Restaurante atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos) {
    Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

    merge(campos, restauranteAtual);

    return atualizar(restauranteId, restauranteAtual);
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
