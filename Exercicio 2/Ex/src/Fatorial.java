import java.math.BigInteger;
import java.util.Scanner;

public class Fatorial {

    public static long calcularFatorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            long resultado = 1;
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        }
    }

    /*
     * A implementação atende ao objetivo de calcular o fatorial de números grandes
     * de maneira eficiente e legível,
     * utilizando BigInteger para evitar problemas de overflow e mantendo a lógica
     * recursiva
     * 
     */
    public static BigInteger calcularFatorialBig(int n) {
        if (n < 0) {
            return BigInteger.valueOf(-1);
        } else if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(calcularFatorialBig(n - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int numero = scanner.nextInt();

        long fatorial = calcularFatorial(numero);
        if (fatorial == -1) {
            System.out.println("Fatorial não definido para números negativos.");
        } else {
            System.out.println("O fatorial de " + numero + " é " + fatorial);
        }
        System.out.println("Digite um número: ");
        int numero2 = scanner.nextInt();
        BigInteger fatorialbig = calcularFatorialBig(numero2);
        if (fatorialbig.equals(BigInteger.valueOf(-1))) {
            System.out.println("Fatorial não definido para números negativos.");
        } else {
            System.out.println("O fatorial de " + numero2 + " é " + fatorialbig);
        }
        scanner.close();
    }
}
