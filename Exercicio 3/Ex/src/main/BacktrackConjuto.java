package main;

import java.util.ArrayList;
import java.util.List;

public class BacktrackConjuto {

    private static void encontrarSubConjuntos(List<Integer> S, int n, int start, List<Integer> subSet, List<List<Integer>> resultado){

        if (subSet.size() == n) {
            resultado.add(new ArrayList<>(subSet));
            return;
        }

        if (start >= S.size()) {
            return;
        }

        for (int i = start; i < S.size(); i++) {
            subSet.add(S.get(i));
        encontrarSubConjuntos(S, n, i + 1, subSet, resultado);

        subSet.remove(subSet.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<Integer> S = List.of(1,2,3,4);
        int n = 2;

        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        encontrarSubConjuntos(S, n, 0, subSet, resultado);

        for (List<Integer> subSets : resultado) {
            System.out.println(subSets);
        }

    }


}
