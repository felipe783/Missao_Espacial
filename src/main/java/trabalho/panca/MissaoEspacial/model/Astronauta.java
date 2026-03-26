package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;


@Entity
@Table(name = "ASTRONAUTA_TABELA")
public class Astronauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASTRONAUTA")
    private Long id_astronauta;

    @Column(name = "NOME_ASTRONAUTA")
    private String nome_astronauta;

    @Column(name = "PESO_ASTRONAUTA")
    private double peso_astronauta;

    @Column(name = "STATUS_ASTRONAUTA")
    private String status_astronauta;

    @ManyToOne
    @JoinColumn( name = "ID_EQUIPE_ASTRONAUTA", referencedColumnName = "ID_EQUIPE" )
    private Equipe equipe;

    public Astronauta(Long id_astronauta, Equipe equipe, String status_astronauta, double peso_astronauta, String nome_astronauta) {
        this.id_astronauta = id_astronauta;
        this.equipe = equipe;
        this.status_astronauta = status_astronauta;
        this.peso_astronauta = peso_astronauta;
        this.nome_astronauta = nome_astronauta;
    }

    public Long getId_astronauta() {
        return id_astronauta;
    }

    public void setId_astronauta(Long id_astronauta) {
        this.id_astronauta = id_astronauta;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getStatus_astronauta() {
        return status_astronauta;
    }

    public void setStatus_astronauta(String status_astronauta) {
        this.status_astronauta = status_astronauta;
    }

    public double getPeso_astronauta() {
        return peso_astronauta;
    }

    public void setPeso_astronauta(double peso_astronauta) {
        this.peso_astronauta = peso_astronauta;
    }

    public String getNome_astronauta() {
        return nome_astronauta;
    }

    public void setNome_astronauta(String nome_astronauta) {
        this.nome_astronauta = nome_astronauta;
    }
}
