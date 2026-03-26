package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

//É onde você cria todos os objetos, cria pro codigo o "satelite"

@Entity //Toda a classe missão é uma entidade no banco de dados, vai ser persistida no Repository
@Table(name = "MISSAO_TABELA") //A tabela do Banco
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MISSAO")
    private Long idMissao;

    @ManyToOne
    @JoinColumn(name = "ID_SATELITE")
    private Satelite satelite;

    @ManyToOne
    @JoinColumn(name = "ID_FOGUETE")
    private Foguete foguete;

    @Column(name = "NOME_MISSAO")
    private String nomeMissao;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "STATUS")
    private String status;

    public Missao() {}

    public Long getIdMissao() {
        return idMissao;
    }

    public Missao(Long idMissao, String status, LocalDateTime dataLancamento, String nomeMissao, Foguete foguete, Satelite satelite) {
        this.idMissao = idMissao;
        this.status = status;
        this.dataLancamento = dataLancamento;
        this.nomeMissao = nomeMissao;
        this.foguete = foguete;
        this.satelite = satelite;
    }

    public void setIdMissao(Long idMissao) {
        this.idMissao = idMissao;
    }

    public Satelite getSatelite() {
        return satelite;
    }

    public void setSatelite(Satelite satelite) {
        this.satelite = satelite;
    }

    public Foguete getFoguete() {
        return foguete;
    }

    public void setFoguete(Foguete foguete) {
        this.foguete = foguete;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

