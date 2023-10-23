package Factory;

public class ContratosFactory extends Factory {

    @Override
    Car retriveCar(String requestedGrade) {
        if("A".equals(requestedGrade)){
            return new CorolaCar(100,"cheio","Azul");
        }else{
            return new Citroen(80,"Meio tanke","Vemelhor");
        }
    }
    
}
