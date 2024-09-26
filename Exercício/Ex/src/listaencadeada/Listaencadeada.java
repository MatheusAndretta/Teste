package listaencadeada;

class Node {
    int valor;
    Node next;

    public Node(int valor) {
        this.valor = valor;
        this.next = null;
    }

}

public class Listaencadeada {

    private Node head;
    private int size;

    public Listaencadeada() {
        this.head = null;
        this.size = 0;
    }

    /*
     * Complexidade de Tempo: O(n)
     * No pior caso, temos que percorrer toda a lista para encontrar o último nó
     * para adicionar o novo nó.
     * 
     * Complexidade de Espaço: O(1)
     * O espaço adicional utilizado é constante, pois apenas adicionamos um novo
     * valor.
     * 
     */

    public void push(Node node) {
        if (head == null) {
            head = node;

        } else {
            Node atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = node;

        }
        size++;
    }

    /*
     * Complexidade de Tempo: O(n)
     * Para remover o último nó, precisamos percorrer a lista até o penúltimo nó,
     * resultando em tempo linear.
     * 
     * Complexidade de Espaço: O(1)
     * A operação não requer espaço adicional, apenas remove o valor do final.
     */

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node atual = head;
        if (atual.next == null) {
            head = null;
            size--;
            return atual;
        }
        while (atual.next.next != null) {
            atual = atual.next;
        }

        Node toRemove = atual.next;
        atual.next = null;
        size--;
        return toRemove;

    }

    /*
     * Complexidade de Tempo: O(n)
     * Precisamos percorrer a lista até a posição indicada para inserir o novo nó,
     * resultando em tempo linear no pior caso.
     * 
     * Complexidade de Espaço: O(1)
     * O espaço adicional utilizado é constante, pois apenas inserimos um novo
     * valor.
     */

    public void insert(int index, Node node) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node atual = head;
            for (int i = 0; i < index; i++) {
                atual = atual.next;
            }
            node.next = atual.next;
            atual.next = node;
        }
        size++;
    }

    /*
     * Complexidade de Tempo: O(n)
     * Para remover um nó em uma posição arbitrária, é necessário percorrer a lista
     * até encontrar o nó anterior, resultando em tempo linear.
     * 
     * Complexidade de Espaço: O(1)
     * A operação não requer espaço adicional, apenas remove o valor na posição
     * indicada.
     * 
     */

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
        if (index == 0) {

            head = head.next;
        } else {
            Node atual = head;

            for (int i = 0; i < index - 1; i++) {
                atual = atual.next;
            }
            atual.next = atual.next.next;
        }
        size--;
    }

    /*
     * Complexidade de Tempo: O(n)
     * Precisamos percorrer a lista até o índice indicado para retornar o nó,
     * resultando em tempo linear.
     * 
     * Complexidade de Espaço: O(1)
     * Não há uso adicional de espaço.
     */
    public Node elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.next;
        }
        return atual;
    }

    public int size() {
        return size;
    }

    public void printList() {
        StringBuilder builder = new StringBuilder();
        Node atual = head;
        while (atual != null) {
            builder.append(atual.valor).append(" -> ");
            atual = atual.next;
        }
        builder.append("Null");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Listaencadeada lista = new Listaencadeada();
        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.push(new Node(40));

        System.out.println("Imprimindo a lista");
        lista.printList();

        System.out.println("Removendo o último nó");
        Node removerNode = lista.pop();
        System.out.println("Nó removido: " + (removerNode != null ? removerNode.valor : "Null"));

        System.out.println("Imprimindo a lista após a remoção");
        lista.printList();

        System.out.println("Inserindo um nó na posição 1");
        lista.insert(1, new Node(25));
        lista.printList();

        System.out.println("Removendo o nó na posição 2");
        lista.remove(2);
        lista.printList();

        System.out.println("Obtendo o elemento na posição 1");
        Node element = lista.elementAt(1);
        System.out.println("Elemento na posição 1: " + (element != null ? element.valor : "null"));

        System.out.println("Imprimindo o tamanho da lista");
        System.out.println("Tamanho da lista: " + lista.size());
    }

}
