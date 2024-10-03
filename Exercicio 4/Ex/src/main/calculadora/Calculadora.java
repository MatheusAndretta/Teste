package main.calculadora;

public class Calculadora {

    public static  int adicionar(int n1, int n2) {
        return n1 + n2;
    }

    public static int subtrair(int n1, int n2) {
        return n1 - n2;
    }

    public static int multiplicar(int n1, int n2) {
        return n1 * n2;
    }

    public static int dividir(int n1, int n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }

}
