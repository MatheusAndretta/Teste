package br.com.ebac.padrao_estrangulamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ebac.padrao_estrangulamento.repositorios")
@EnableFeignClients(basePackages = "br.com.ebac.padrao_estrangulamento.feign")
public class PadraoEstrangulamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadraoEstrangulamentoApplication.class, args);
	}

}
