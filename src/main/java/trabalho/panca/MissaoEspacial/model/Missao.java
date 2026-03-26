package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

//É onde você cria todos os objetos, cria pro codigo o "satelite"

@Entity //Toda a classe missão é uma entidade no banco de dados, vai ser persistida no Repository
@Table(name = "missao_tabela") //A tabela do Banco
public class Missao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_missao;
    private int id_satelite;
    private int id_foguete;
    private String nome_missao;
    private LocalDateTime datalancamento;
    private String status;

    public Missao(int id_missao, int id_satelite, String status, LocalDateTime datalancamento, String nome_missao, int id_foguete) { //Construtor da missão
        this.id_missao = id_missao;
        this.id_satelite = id_satelite;
        this.status = status;
        this.datalancamento = datalancamento;
        this.nome_missao = nome_missao;
        this.id_foguete = id_foguete;
    }

    public int getId_foguete() {
        return id_foguete;
    }

    public void setId_foguete(int id_foguete) {
        this.id_foguete = id_foguete;
    }

    public int getId_missao() {
        return id_missao;
    }

    public void setId_missao(int id_missao) {
        this.id_missao = id_missao;
    }

    public int getId_satelite() {
        return id_satelite;
    }

    public void setId_satelite(int id_satelite) {
        this.id_satelite = id_satelite;
    }

    public String getNome_missao() {
        return nome_missao;
    }

    public void setNome_missao(String nome_missao) {
        this.nome_missao = nome_missao;
    }

    public LocalDateTime getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDateTime datalancamento) {
        this.datalancamento = datalancamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

