import Factory.Car;
import Factory.ContratosFactory;
import Factory.Customer;
import Factory.Factory;
import Factory.SemContratosFactory;

public class domain {
    public static void main(String[] args) throws Exception {
         Customer cliente = new Customer("A", false);
        Factory factory = getFactory(cliente);
        Car car = factory.create(cliente.getGradeRequest());
        car.startEngine();
    }

    private static Factory getFactory(Customer cliente) {
        if (cliente.hasCompanyContract()) {
            return new ContratosFactory();
        } else {
            return new SemContratosFactory();
        }
    }
}
