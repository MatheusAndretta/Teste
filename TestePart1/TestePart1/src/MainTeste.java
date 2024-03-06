


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class MainTeste {
    @Test
    public void testeJunit(){
        List<Pessoas> lista = new Pessoas().populaPessoas();

       Map<String, List<Pessoas>> mapM = lista.stream()
        .filter(pessoas -> pessoas.getSexo().equals("Mulher"))
        .collect(Collectors.groupingBy(Pessoas::getSexo));

       List<Pessoas> listaDeMulheres = lista.stream()
        .filter(pessoas -> pessoas.getSexo().equals("Mulher"))
        .collect(Collectors.toList());

        Assert.assertEquals(listaDeMulheres, mapM.get("Mulher"));

    }
}
