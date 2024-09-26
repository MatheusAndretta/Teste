import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
/*
 * Top-Down (Recursiva):
 *
 * Estratégia: Resolve subproblemas de forma recursiva e armazena resultados em um mapa (memo) para evitar recomputações.
 *
 * Uso de Memória: Usa a pilha de chamadas da recursão e uma estrutura de dados para memoização.
 * 
 * Simplicidade: O código é mais fácil de entender, pois reflete diretamente a definição do problema.
 * 
 * O uso de BigInteger em ambas as abordagens permite calcular o fatorial de números acima de 100 sem problemas de overflow
 */

public class FatorialTopDown {

    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static BigInteger calcularFatorial(int n) {
        if (n < 0) {
            return BigInteger.valueOf(-1);
        } else if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        BigInteger resultado = BigInteger.valueOf(n).multiply(calcularFatorial(n - 1));
        memo.put(n, resultado);
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 7;
        System.out.println("Fatorial de " + numero + " é " + calcularFatorial(numero));
    }

}
