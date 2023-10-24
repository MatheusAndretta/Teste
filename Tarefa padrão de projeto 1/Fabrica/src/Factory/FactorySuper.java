package Factory;

import Car.Car;
import Car.SuperCar;

public class FactorySuper implements FactoryCar{

    @Override
    public Car criaCarro() {
        return new SuperCar(null);
    }

    
    
}
