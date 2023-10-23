package Factory;

public class SemContratosFactory extends Factory{

    @Override
    Car retriveCar(String requestedGrade) {
        if("A".equals(requestedGrade)){
            return new Brasilia(100,"cheio","Verde");
        }else{
            return new Fusca(80,"Meio tanke","Rosa");
        }
    }
    
}
