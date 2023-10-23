package Factory;

public abstract class Car {
    private int horsePower;
    private String fuelSource;
    private String color;

    public Car(int horsePower, String fuelSource, String color) {
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void startEngine(){
        System.out.println(getClass().getSimpleName());
        System.out.println("O " + fuelSource + " o motor foi ligado e está pronto para utilizar " +  horsePower);
    }
    public void clean(){
        System.out.println("O carro foi limpo e o " +  color.toLowerCase() + " brilho de cor");
    }
    public void machanicCleck(){
        System.out.println("carro foi verificado pelo mecânico. Tudo parece bem!");
    }
    public void fuelCar(){
        System.out.println("carro está sendo abastecido " + fuelSource.toLowerCase());
    }
}
