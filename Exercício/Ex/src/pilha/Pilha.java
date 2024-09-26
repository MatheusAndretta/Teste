package pilha;

public class Pilha {

    private int[] pilha;

    private int posicaoPilha;

    private final int CAPACIDADE;

    public Pilha(int capacidade) {
        this.CAPACIDADE = capacidade;
        this.posicaoPilha = -1;
        this.pilha = new int[CAPACIDADE];
        
    }

    public boolean isEmpty() {
        return this.posicaoPilha == -1;
    }

    public int size() {
        return this.posicaoPilha + 1;
    }
    /* Complexidade de Tempo: O(1)
     * A operação é feita em tempo constante, pois apenas adicionamos o elemento no topo da pilha e atualizamos a posição. 
     * Não há necessidade de percorrer a estrutura.
     * 
     * Complexidade de Espaço: O(1)
     * O espaço adicional utilizado é constante, pois apenas adicionamos um novo valor.
     */
    public boolean push(int valor) {
        if (this.posicaoPilha > this.CAPACIDADE) {
            return false;
        }
        this.pilha[++posicaoPilha] = valor;
        return true;
    }

    /*
     * Complexidade de Tempo: O(1)
     * A operação remove o elemento do topo da pilha e atualiza a posição, tudo em tempo constante.
     * 
     * Complexidade de Espaço: O(1)
     * A operação não requer espaço adicional, pois apenas remove o valor no topo.
     */

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public Integer top() {
        if (this.isEmpty()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public static void main(String[] args) {
        Pilha p = new Pilha(5);
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        print("size");
        System.out.println("Valor Total: "+p.size());
        print("top");
        System.out.println("1º da pilha: " + p.top());
        print("pop");
        System.out.println("Remove o 1º: "+p.pop());
        System.out.println("New size: "+p.size());
        print("isEmpty");
        System.out.println("Retorna false se estive cheia: " + p.isEmpty());
        while (!p.isEmpty()) {
            p.pop();
        }
        print("isEmpty");
        System.out.println("Retorna true se estive vazia: " + p.isEmpty());
        

    }

    private static void print(String string) {
        System.out.println("+++++ " + string + " +++++");
    }

}
