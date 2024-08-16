package main.java.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Carro_seq")
    @SequenceGenerator(name = "Carro_seq",sequenceName = "sq_Carro",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "codigo",length = 10,nullable = false,unique = true)
    private String codigo;

    @Column(name = "nome",length = 50,nullable = false)
    private String nome;

    @Column(name = "cor",length = 15,nullable = false)
    private String cor;

    @Column(name = "descricao",length = 50,nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "carro")
    private List<Marca> marcas;

    @ManyToOne
    @JoinColumn(name = "id_acessorio",foreignKey = @ForeignKey(name = "fk_acessorio_Carro"),referencedColumnName = "id",nullable = false)
    private Acessorio acessorio;

   
    
    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

 




    
    


}
