package fifo;

public class FilaFiFo {

    private int[] fila;
    private int front;
    private int rear;
    private int size;
    private final int CAPACIDADE;

    public FilaFiFo(int capacidade) {
        this.CAPACIDADE = capacidade;
        this.fila = new int[capacidade];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * Complexidade de Tempo: O(1)
     * A operação é feita em tempo constante ao adicionar um elemento no final da
     * fila.
     * 
     * Complexidade de Espaço: O(1)
     * O espaço adicional utilizado é constante, pois apenas adicionamos um novo
     * valor.
     */
    public boolean enqueue(int valor) {
        if (size >= CAPACIDADE) {
            return false;
        }
        fila[rear] = valor;
        rear = (rear + 1) % CAPACIDADE;
        size++;
        return true;

    }

    /*
     * Complexidade de Tempo: O(1)
     * Remover o elemento da frente da fila é feito em tempo constante.
     * 
     * Complexidade de Espaço: O(1)
     * A operação não requer espaço adicional, apenas remove o valor da frente.
     */

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        int valor = fila[front];
        front = (front + 1) % CAPACIDADE;
        size--;
        return valor;
    }

    /*
     * Complexidade de Tempo: O(1)
     * Retornar o valor no final da fila é uma operação de tempo constante.
     * 
     * Complexidade de Espaço: O(1)
     * Não há uso adicional de espaço.
     */

    public Integer rear() {
        if (isEmpty()) {
            return null;

        }
        return fila[(rear - 1 + CAPACIDADE) % CAPACIDADE];
    }

    /*
     * Complexidade de Tempo: O(1)
     * Retornar o valor na frente da fila é feito em tempo constante.
     *
     * Complexidade de Espaço: O(1)
     * A operação não requer espaço adicional.
     */

    public Integer front() {
        if (isEmpty()) {
            return null;
        }
        return fila[front];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FilaFiFo fiFo = new FilaFiFo(5);
        fiFo.enqueue(1);
        fiFo.enqueue(2);
        fiFo.enqueue(3);
        fiFo.enqueue(4);
        fiFo.enqueue(5);
        System.out.println("Tenta colocar mais 1 na fila cheia: " + fiFo.enqueue(6));
        System.out.println("Frente: " + fiFo.front());
        System.out.println("Fim: " + fiFo.rear());

        while (!fiFo.isEmpty()) {
            System.out.println("Dequeue: " + fiFo.dequeue());
        }
    }
}
