package com.cegrconsulting.expressfood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

  PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
  MENSAGEM_IMCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
  RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
  ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
  ERRO_DE_NEGOCIO("/erro-negocio", "Violação de regra de negócio");

  private String title;
  private String uri;

  ProblemType(String path, String title) {
    this.uri = "https://algafood.com.br" + path;
    this.title = title;
  }
}
