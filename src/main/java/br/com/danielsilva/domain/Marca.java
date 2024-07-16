package br.com.danielsilva.domain;
import javax.persistence.*;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "marca_sq")
    @SequenceGenerator(name = "marca_sq",sequenceName = "sq_marca" , initialValue = 1 , allocationSize = 1)
    private Long id;

    @Column(name = "NAME" , length = 50 , nullable = false , unique = true)
    private String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


}
