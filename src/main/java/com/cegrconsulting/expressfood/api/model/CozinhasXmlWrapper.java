package com.cegrconsulting.expressfood.api.model;

import java.util.List;

import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "cozinhas") //poderíamos utilizar a anotação JsonRootName, daria na mesma
@Data
public class CozinhasXmlWrapper {

  @JacksonXmlProperty(localName = "cozinha")
  @JacksonXmlElementWrapper(useWrapping = false)
  @NonNull //Os construtores gerados pela anotação @Data só são feitos para propriedades com esta anotação. 
  private List<Cozinha> cozinhas;
  
}
