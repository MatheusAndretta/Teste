package TarefaPart1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tarefa1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite nomes com virgular: ");

        String frase = s.next();
        String[] partes = frase.split(",");

        List<String> lista = new ArrayList<>();

        for (String parte : partes) {
            lista.add(parte);
        }
        Collections.sort(lista);

        System.out.println("Nomes ordenados:");

        for (String nome : lista) {
            System.out.println(nome);
        }

        s.close();
    }

}
