package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="equipe_tabela")
public class Equipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nome_equipe;
    private int qntMembros;


    public Equipe(int ID, String nome, int qntMembros) {
        this.id = ID;
        this.nome_equipe = nome;
        this.qntMembros = qntMembros;
    }


    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getQntMembros() {
        return qntMembros;
    }

    public void setQntMembros(int qntMembros) {
        this.qntMembros = qntMembros;
    }

    public String getNome() {
        return nome_equipe;
    }

    public void setNome(String nome) {
        this.nome_equipe = nome;
    }
}

