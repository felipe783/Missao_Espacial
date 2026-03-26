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

    @Column( name = "ID_EQUIPE_ASTRONAUTA")
    private int id_equipe_astronauta;

    public Astronauta(Long id_astronauta, int id_equipe_astronauta, String status_astronauta, double peso_astronauta, String nome_astronauta) {
        this.id_astronauta = id_astronauta;
        this.id_equipe_astronauta = id_equipe_astronauta;
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

    public String getNome_astronauta() {
        return nome_astronauta;
    }

    public void setNome_astronauta(String nome_astronauta) {
        this.nome_astronauta = nome_astronauta;
    }

    public double getPeso_astronauta() {
        return peso_astronauta;
    }

    public void setPeso_astronauta(double peso_astronauta) {
        this.peso_astronauta = peso_astronauta;
    }

    public String getStatus_astronauta() {
        return status_astronauta;
    }

    public void setStatus_astronauta(String status_astronauta) {
        this.status_astronauta = status_astronauta;
    }

    public int getId_equipe_astronauta() {
        return id_equipe_astronauta;
    }

    public void setId_equipe_astronauta(int id_equipe_astronauta) {
        this.id_equipe_astronauta = id_equipe_astronauta;
    }
}
