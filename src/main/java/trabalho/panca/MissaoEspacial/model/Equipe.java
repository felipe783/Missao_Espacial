package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="EQUIPE_TABELA")
public class Equipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPE")
    private Long id_equipe;

    @Column(name = "NOME_EQUIPE")
    private String nome_equipe;

    @Column(name = "QNTD_MEMBROS")
    private int qntMembros;

    @OneToMany(mappedBy = "equipe") //A equipe pode ter varios relacionados a ela
    private List<Astronauta> astronautas = new ArrayList<>();

    public Equipe(Long id_equipe, String nome_equipe, int qntMembros) {
        this.id_equipe = id_equipe;
        this.nome_equipe = nome_equipe;
        this.qntMembros = qntMembros;
    }

    public Long getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(Long id_equipe) {
        this.id_equipe = id_equipe;
    }

    public List<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(List<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public int getQntMembros() {
        return qntMembros;
    }

    public void setQntMembros(int qntMembros) {
        this.qntMembros = qntMembros;
    }

    public String getNome_equipe() {
        return nome_equipe;
    }

    public void setNome_equipe(String nome_equipe) {
        this.nome_equipe = nome_equipe;
    }
}

