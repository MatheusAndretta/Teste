package Car;

public class SuperCar extends Car {

    public SuperCar(String modelo) {
        super("Carro A");
        
    }

    @Override
    public void ligar() {
        System.out.println(getClass().getSimpleName());
        System.out.println("O carro esta ligando! ");
    }

    @Override
    public void mecanica() {
        System.out.println("O mecanico verificou o carro e esta tudo em ordem. ");
    }

    @Override
    public void tanke() {
        System.out.println("Abastecendo o carro. ");
    }

    @Override
    public void velocidade() {
        System.out.println("Este carro chega as incrives 300KMh. Cuidado!!");
    }
    
}
