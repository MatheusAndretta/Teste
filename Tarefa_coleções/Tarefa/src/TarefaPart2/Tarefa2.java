package TarefaPart2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tarefa2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite nomes com gênero sem espaço usando virgura (por exemplo, João-M,Maria-F): ");

        String ent = s.next();
        String[] nomesGeneros = ent.split(",");

        Map<String, List<String>> listaPorGenero = new HashMap<>();

        for (String nomeGenero : nomesGeneros) {
            String[] partes = nomeGenero.split("-");
            if (partes.length == 2) {
                String nome = partes[0];
                String genero = partes[1];

                if (genero.equals("M") || genero.equals("F")) {
                    listaPorGenero.computeIfAbsent(genero, a -> new ArrayList<>()).add(nome);

                } else {
                    System.out.println("Insira -M ou -F para genero" + genero);
                }

            } else {
                System.out.println("Formato errado usa exemplo: João-M ou Maria-F" + nomeGenero);
            }
        }
        System.out.println("Lista por Genero");
        for (Map.Entry<String, List<String>> entry : listaPorGenero.entrySet()) {
            String genero = entry.getKey();
            List<String> nomes = entry.getValue();

            System.out.println(genero + ": " + String.join(", ", nomes));

        }

        s.close();
    }

}
