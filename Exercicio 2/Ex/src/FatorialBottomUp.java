import java.math.BigInteger;

/*
 *   
 *  Bottom-Up (Iterativa):
 *  Estratégia: Resolve todos os subproblemas de forma iterativa, construindo uma tabela a partir dos casos base até o valor desejado.
 *
 *  Uso de Memória: Usa um array para armazenar todos os resultados intermediários, evitando a necessidade de chamadas de função recursivas.
 *
 *  Eficiência: Pode ser mais eficiente em termos de uso de memória para problemas com muitos subproblemas, já que não envolve o overhead de chamadas de função.
 *
 *  O uso de BigInteger em ambas as abordagens permite calcular o fatorial de números acima de 100 sem problemas de overflow
 * 
 */

public class FatorialBottomUp {
    public static BigInteger calcularFatorial(int n) {
        if (n < 0) {
            return BigInteger.valueOf(-1);
        }

        BigInteger[] fatorial = new BigInteger[n + 1];
        fatorial[0] = BigInteger.ONE; // 0! = 1
        fatorial[1] = BigInteger.ONE; // 1! = 1

        for (int i = 2; i <= n; i++) {
            fatorial[i] = BigInteger.valueOf(i).multiply(fatorial[i - 1]);
        }

        return fatorial[n];
    }

    public static void main(String[] args) {
        int numero = 7;
        System.out.println("Fatorial de " + numero + " é " + calcularFatorial(numero));
    }
}
