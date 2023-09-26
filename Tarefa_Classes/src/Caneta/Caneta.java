package Caneta;

public class Caneta {
    private String nome;
    private String cor;
    private String marca;
    private boolean tampada;

    public Caneta(String nome, String cor, String marca) {
        this.nome = nome;
        this.cor = cor;
        this.marca = marca;
        this.tampada = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }
     // Metodo para dizer se a caneta esta ou não tampada
    public void destampada() {
        this.tampada = true;
    }
    // Metedo para verifica se a caneta esta tampada
    public void escrever() {
        if (isTampada()) {
            System.out.println("Escrevendo");
        } else {
            System.out.println("Verifique se a caneta esta sem tampa");
        }

    }

    @Override
    public String toString() {
        return "Caneta Nome:" + nome + ", Cor:" + cor + ", Marca:" + marca + ", Tampa:" + tampada;
    }
    
}
