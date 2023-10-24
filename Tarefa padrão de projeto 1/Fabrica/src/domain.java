import Car.Car;
import Factory.FactoryCar;
import Factory.FactorySuper;
import Factory.PopularFactory;

public class domain {
    public static void main(String[] args) {
        FactoryCar superCar = new FactorySuper();
        Car carS = superCar.criaCarro();
        carS.ligar();
        carS.mecanica();
        carS.tanke();
        carS.velocidade();

        System.out.println("*******************************");

        FactoryCar popularCar = new PopularFactory();
        Car carp = popularCar.criaCarro();
        carp.ligar();
        carp.mecanica();
        carp.tanke();
        carp.velocidade();
    }
}
