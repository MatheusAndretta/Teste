import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Pessoa.Pessoa;

public class Programa1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite nomes com sexo separados por , (Maria-F,Joao-M,)");
        String ent = s.nextLine();
        String[] nomeEgenero = ent.split(",");

        List<Pessoa> listaPorGenero = new ArrayList<>();
        for (String nomeGenero : nomeEgenero) {
            String[] partes = nomeGenero.split("-");
            if (partes.length == 2) {
                String nome = partes[0];
                String sexo = partes[1];

                if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
                    listaPorGenero.add(new Pessoa(nome, sexo));
                }
            }

        }

        s.close();
        List<Pessoa> masculina = new ArrayList<>();
        List<Pessoa> feminino = new ArrayList<>();

        for (Pessoa pessoa : listaPorGenero) {
            if (pessoa.getSexo().equalsIgnoreCase("M")) {
                masculina.add(pessoa);
            } else {
                feminino.add(pessoa);
            }

        }
        System.out.println("\nLista de nome Masculino ");
        for (Pessoa pessoa : masculina) {
            System.out.println(pessoa.getNome());
        }
        System.out.println("\nLista de nome feminino ");
        for (Pessoa pessoa : feminino) {
            System.out.println(pessoa.getNome());
        }

    }
}
