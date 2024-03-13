package Teste;

import org.junit.Assert;
import org.junit.Test;

import BR.TesteCliente;



public class TesteClienteTest {

	@Test
	public void testeClasseCliente() {
		TesteCliente cli = new TesteCliente();
		cli.adicionarNome("Matheus");
		cli.adicionarNome1("Matheus");

		Assert.assertEquals("Matheus", cli.getNome());
	}
}
