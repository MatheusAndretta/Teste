package main.java.domain;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Acessorio_sq")
    @SequenceGenerator(name = "Acessorio_sq",sequenceName = "sq_Acessorio",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "codigo",length = 10,nullable = false,unique = true)
    private String codigo;

    @Column(name = "tipoAcessorio",length = 10,nullable = false)
    private String tipoAcessorio;

    @Column(name = "descricao",length = 50,nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "acessorio")
    private List<Carro> carros;

    

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

    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }


    
}
