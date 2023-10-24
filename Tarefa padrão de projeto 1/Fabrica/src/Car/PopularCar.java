package Car;

public class PopularCar extends Car {
    

    public PopularCar(String modelo) {
        super("Carro B");
    }

    @Override
    public void ligar() {
        System.out.println(getClass().getSimpleName());
        System.out.println("O carro esta ligando!. ");
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
        System.out.println("Este carro tem uma economia incrivel para viagens.");
    }
}
