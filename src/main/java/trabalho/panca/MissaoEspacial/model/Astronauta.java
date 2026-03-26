package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tabela_astronauta")
public class Astronauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_astronauta;
    private String nome_astronauta;
    private double peso_astronauta;
    private String status_astronauta;
    private int id_equipe_astronauta;

    public Astronauta(int id_astronauta, int id_equipe_astronauta, String status_astronauta, double peso_astronauta, String nome_astronauta) {
        this.id_astronauta = id_astronauta;
        this.id_equipe_astronauta = id_equipe_astronauta;
        this.status_astronauta = status_astronauta;
        this.peso_astronauta = peso_astronauta;
        this.nome_astronauta = nome_astronauta;
    }

    public int getId_astronauta() {
        return id_astronauta;
    }

    public void setId_astronauta(int id_astronauta) {
        this.id_astronauta = id_astronauta;
    }

    public int getId_equipe_astronauta() {
        return id_equipe_astronauta;
    }

    public void setId_equipe_astronauta(int id_equipe_astronauta) {
        this.id_equipe_astronauta = id_equipe_astronauta;
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
