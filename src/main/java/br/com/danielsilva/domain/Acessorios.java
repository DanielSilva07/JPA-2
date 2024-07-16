package br.com.danielsilva.domain;
import javax.persistence.*;

@Entity
@Table(name = "TB_ACESSORIOS")
public class Acessorios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "acessorios_sq")
    @SequenceGenerator(name = "acessorios_sq",sequenceName = "sq_acessorios" , initialValue = 1 , allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION" , length = 50 , unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_carro_fk",
        foreignKey = @ForeignKey( name = "fk_carro_acessorios"),
        referencedColumnName = "id", nullable = false)
    private Carro carro;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
