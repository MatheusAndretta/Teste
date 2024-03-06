import java.util.List;

public class Pessoas {
    
    private String nome;
    private int idade;
    private String sexo;

    public Pessoas() {
    }

    public Pessoas(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Pessoas> populaPessoas(){
        Pessoas pessoa1 = new Pessoas("Matheus",22,"Homen");
        Pessoas pessoa2 = new Pessoas("Marcia",18,"Mulher");
        Pessoas pessoa3 = new Pessoas("Paulo",26,"Homen");
        Pessoas pessoa4 = new Pessoas("Kelly",24,"Mulher");
        return List.of(pessoa1,pessoa2,pessoa3,pessoa4);
    }

    @Override
    public String toString() {
        return "nome " + nome + " idade" + idade + " sexo=" + sexo;
    }
    
}
