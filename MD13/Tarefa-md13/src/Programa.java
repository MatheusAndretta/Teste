import Pessoa.Pessoa;
import Pessoa.PessoaFisica.PessoaFisica;
import Pessoa.PessoaJuridica.PessoaJuridica;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa = new PessoaFisica(123456789L);
        pessoa.setNome("Paulo");
        System.out.println(pessoa.toString());

        System.out.println("\n*********************************\n");

        Pessoa pessoa2 = new PessoaJuridica(4321123451L);
        pessoa2.setNome("Matheus");
        System.out.println(pessoa2.toString());

    }
}
