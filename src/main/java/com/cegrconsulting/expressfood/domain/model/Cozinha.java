package com.cegrconsulting.expressfood.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cegrconsulting.expressfood.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

  @NotNull(groups = Groups.CozinhaId.class)
	@EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String nome;

  @JsonIgnore
  @OneToMany(mappedBy = "cozinha") //A entidade restaurante é a dona do relacionamento, pois a tabela restaurante possui o id da cozinha
  //Relacionamentos bidirecionais sem necessidade, são considerados uma má prática
  private List<Restaurante> restaurantes = new ArrayList<>();

}
