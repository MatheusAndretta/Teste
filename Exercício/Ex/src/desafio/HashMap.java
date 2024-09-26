package desafio;

import java.util.LinkedList;

class HashNode<K, V> {
    K key; 
    V value; 
    HashNode<K, V> next; 
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashMap<K, V> {
    private LinkedList<HashNode<K, V>>[] table; 
    private int capacity; 
    private int size; 

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity]; 

        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>(); 
        }
    }

    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity; 
    }

    
    public void put(K key, V value) {
        int index = hash(key); 
        LinkedList<HashNode<K, V>> bucket = table[index];

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; 
                return;
            }
        }

        
        HashNode<K, V> newNode = new HashNode<>(key, value);
        bucket.add(newNode);
        size++;
    }

    
    public V get(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = table[index];

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value; 
            }
        }
        return null; 
    }

    
    public void remove(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = table[index];

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); 
                size--;
                return;
            }
        }
    }

    
    public int size() {
        return size;
    }

    
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            if (table[i].isEmpty()) {
                continue;
            }
            System.out.print("Índice " + i + ": ");
            for (HashNode<K, V> node : table[i]) {
                System.out.print("{" + node.key + "=" + node.value + "} -> ");
            }
            System.out.println("null");
        }
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(10); /* Um HashMap é ideal quando você precisa de: Acesso rápido a valores usando chaves.
                                                                    Um mapeamento flexível e dinâmico de chaves para valores. Eficiência em termos de tempo para operações comuns.*/ 
        map.put("um", 1);
        map.put("dois", 2);
        map.put("três", 3);
        map.put("quatro", 4);
        map.put("cinco", 5);

        System.out.println("Valor para 'três': " + map.get("três")); 
        map.remove("dois");
        System.out.println("Tamanho após remover 'dois': " + map.size()); 
        map.printMap();
    }
}
