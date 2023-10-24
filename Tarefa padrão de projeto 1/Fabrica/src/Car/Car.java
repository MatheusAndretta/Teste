package Car;

public abstract class Car {
    
    private String modelo;

    public Car(String modelo) {
        this.modelo = modelo;
    }

    public abstract void ligar();
    public abstract void mecanica();
    public abstract void tanke();
    public abstract void velocidade();

    public String getModelo() {
        return modelo;
    }

    
}
