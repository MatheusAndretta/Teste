package br.com.matheus.primeiroprojetospring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.matheus.domain.Cliente;
import br.com.matheus.domain.Produto;
import br.com.matheus.repository.IClienteRepository;
import br.com.matheus.repository.IProdutoRepository;


@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.matheus.repository")
@EntityScan("br.com.matheus.*")
@ComponentScan(basePackages = "br.com.matheus")
public class PrimeiroprojetospringApplication implements CommandLineRunner{


	private static final Logger log = LoggerFactory.getLogger(PrimeiroprojetospringApplication.class);

	@Autowired
	private IClienteRepository repository;

	@Autowired
	private IProdutoRepository repositoryProd;


	public static void main(String[] args) {
		SpringApplication.run(PrimeiroprojetospringApplication.class, args);
	}

	@Override
	public void run(String... args){
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		Produto produto = createProduto();
		repository.save(cliente);
		repositoryProd.save(produto);
		
		
	}

	private Produto createProduto() {
		return Produto.builder()
		.nome("Teste")
		.desc("Teste Teste")
		.valor(1418.89D)
		.build();
	}

	private Cliente createCliente() {
		return Cliente.builder()
		.cidade("SC")
		.cpf(12312312310L)
		.email("Teste@teste.com")
		.end("end")
		.estado("SC")
		.nome("Matheus")
		.numero(102030)
		.tel(10203040L)
		.build();

	}
}
