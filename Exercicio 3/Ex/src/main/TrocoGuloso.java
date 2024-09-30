package main;

import java.util.Arrays;

public class TrocoGuloso {

    public static void calcularTroco(int quantia, int[] moedas) {
        Arrays.sort(moedas);

        int[] maiorMoeda = new int[moedas.length];
        for (int i = 0; i < moedas.length; i++) {
            maiorMoeda[i] = moedas[moedas.length - 1 - i];
        }

        int[] troco =new int[maiorMoeda.length];

        for(int i =0; i< maiorMoeda.length; i++){
            while (quantia >= maiorMoeda[i]) {
                quantia -= maiorMoeda[i];
                troco[i]++;
            }
        }



        if (quantia == 0) {
            System.out.println("Troco dado:");
            for (int i = 0; i < troco.length; i++) {
                if (troco[i] > 0) {
                    System.out.println(maiorMoeda[i] + " : " + troco[i] + " moedas");
                }
            }
        } else {
            System.out.println("Não é possivel dar troco exato");
        }

    }

    public static void main(String[] args) {
        int quantia = 18;
        int[] moedas = { 5, 2, 1 };

        calcularTroco(quantia, moedas);
    }

}
