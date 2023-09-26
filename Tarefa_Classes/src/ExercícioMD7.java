import Caneta.Caneta;

public class ExercícioMD7 {
    public static void main(String[] args) throws Exception {
        Caneta caneta = new Caneta("Av", "azul", "bic");
        caneta.destampada();
        System.out.println(caneta.toString());
        caneta.escrever();
        
    }
}
