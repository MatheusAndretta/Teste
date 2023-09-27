import java.util.Scanner;

public class Programa1 {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Olá, Digite sua nota:");
        int n1 = s.nextInt();
        System.out.println("Olá, Digite sua nota:");
        int n2 = s.nextInt();
        System.out.println("Olá, Digite sua nota:");
        int n3 = s.nextInt();
        System.out.println("Olá, Digite sua nota:");
        int n4 = s.nextInt();
        int nota = (n1 + n2 + n3 + n4) / 4;
        if (nota >= 7) {
            System.out.println("Você foi aprovado");
            System.out.println("Sua media foi: " + nota);
        } else if (nota >= 5) {
            System.out.println("você esta de recuperação");
            System.out.println("Sua media foi: " + nota);
            System.out.println("Você precisa de uma media 7 para ser aprovado!");

        } else {
            System.out.println("Infelismente você esta reprovado");
            System.out.println("Sua media foi: " + nota);
            System.out.println("Você precisa de uma media 7 para ser aprovado!");

        }

        s.close();
    }
}
