package br.com.danielsilva.domain;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "carro_sq")
    @SequenceGenerator( name = "carro_sq" , sequenceName = "sq_carro" , initialValue = 1 ,allocationSize = 1)
    private Long id;

    @Column(name = "NAME" , length = 10 ,nullable = false , unique = true)
    private String name;

    @Column(name = "ANO" ,length = 50)
    private String ano;

    @Column(name = "PRICE",length = 50)
    private Long price;

    @OneToMany(mappedBy = "carro")
    private List<Acessorios> acessorios ;


    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }
}