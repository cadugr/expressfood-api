package com.cegrconsulting.expressfoodapi.di.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;
import com.cegrconsulting.expressfoodapi.di.notificacao.NivelUrgencia;
import com.cegrconsulting.expressfoodapi.di.notificacao.Notificador;
import com.cegrconsulting.expressfoodapi.di.notificacao.TipoDoNotificador;

//@Component
public class AtivacaoClienteService { //implements InitializingBean, DisposableBean{

	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;

	//@PostConstruct //não é uma anotação do Spring é da especificação JSR-250, mas o Spring a utiliza
	public void init() { //é chamado após o construtor e após fazer todas as injeções devidas
		System.out.println("INIT " + notificador);
	}

	//@PreDestroy //também não é uma anotação do Spring é da especificação JSR-250, mas o Spring a utiliza
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

	//Caso estejamos utilizando a interface InitializingBean:

	// @Override
	// public void afterPropertiesSet() throws Exception {
	// 	// TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'afterPropertiesSet'");
	// }

}
