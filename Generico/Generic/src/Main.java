import java.util.ArrayList;
import java.util.List;

import Marcas.Audi;
import Marcas.Carro;
import Marcas.Ford;
import Marcas.Honda;

public class Main {
    public static void main(String[] args)  {

        List<Carro> carro = new ArrayList<>();

        Carro honda = new Honda();
        Carro ford = new Ford();
        Carro audi = new Audi();

        carro.add(audi);
        carro.add(ford);
        carro.add(honda);

        for (Carro carro2 : carro) {
            System.out.println(carro2);
        }
        
        
    }
}
