import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoas> lista = new Pessoas().populaPessoas();

       Map<String, List<Pessoas>> mapM = lista.stream()
        .filter(pessoas -> pessoas.getSexo().equals("Mulher"))
        .collect(Collectors.groupingBy(Pessoas::getSexo));

        mapM.forEach((k,v) -> System.out.println(v));
    }
}
