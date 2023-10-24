package Factory;

import Car.Car;
import Car.PopularCar;

public class PopularFactory implements FactoryCar{

    @Override
    public Car criaCarro() {
        return new PopularCar(null);
    }
    
}
