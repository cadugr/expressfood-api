package com.cegrconsulting.expressfoodapi.di.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	@Value("${notificador.email.host-servidor}")
	private String host;

	@Value("${notificador.email.porta-servidor}")
	private Integer porta;

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.println("host: " + host);
		System.out.println("porta: " + porta);

		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
