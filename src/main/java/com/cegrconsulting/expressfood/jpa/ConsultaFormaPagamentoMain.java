package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.FormaPagamento;
import com.cegrconsulting.expressfood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    FormaPagamentoRepository formasPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);
    
    List<FormaPagamento> todasFormasPagamentos = formasPagamentos.todas();

    for(FormaPagamento formaPagamento: todasFormasPagamentos) {
      System.out.printf("Forma Pagamento: %s\n", formaPagamento.getDescricao());
    }
  }
  
}
