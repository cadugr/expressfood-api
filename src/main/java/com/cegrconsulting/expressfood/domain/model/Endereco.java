package com.cegrconsulting.expressfood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable //Significas que não é uma entidade e sim uma classe imcorporável.  Todos os atributos dela irão refletir na tabela que representa a entidade que recebe essa classe.
public class Endereco {
 
  @Column(name = "endereco_cep")
  private String cep;
  @Column(name = "endereco_logradouro")
  private String logradouro;
  @Column(name = "endereco_numero")
  private String numero;
  @Column(name = "endereco_complemento")
  private String complemento;
  @Column(name = "endereco_bairro")
  private String bairro;
  @ManyToOne
  @JoinColumn(name = "endereco_cidade_id")
  private Cidade cidade;

}
