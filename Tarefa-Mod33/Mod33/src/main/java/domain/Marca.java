package main.java.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Marca_seq")
    @SequenceGenerator(name = "Marca_seq",sequenceName = "seq_Marca",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "codigo",length = 10,nullable = false,unique = true)
    private String codigo;


    @Column(name = "nome",length = 50,nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_carro_fk",foreignKey = @ForeignKey(name = "fk_carro_marca"),referencedColumnName = "id", nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_acessorio_fk",foreignKey = @ForeignKey(name = "fk_acessorio_marca"),referencedColumnName = "id", nullable = false)
    private Acessorio acessorio;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }





    
}
