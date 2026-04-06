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

    @OneToOne //So pode ter uma Equipe Vinculada
    @JoinColumn(name = "ID_EQUIPE")
    private Equipe equipe;

    @ManyToOne //Mas pode
    @JoinColumn(name = "ID_FOGUETE")
    private Foguete foguete;

    @Column(name = "NOME_MISSAO")
    private String nomeMissao;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "STATUS")
    private String status;

    public Missao() {}

    public Missao(Long idMissao, String status, LocalDateTime dataLancamento, String nomeMissao, Foguete foguete, Equipe equipe, Satelite satelite) {
        this.idMissao = idMissao;
        this.status = status;
        this.dataLancamento = dataLancamento;
        this.nomeMissao = nomeMissao;
        this.foguete = foguete;
        this.equipe = equipe;
        this.satelite = satelite;
    }

    public Long getIdMissao() {
        return idMissao;
    }

    public void setIdMissao(Long idMissao) {
        this.idMissao = idMissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public Foguete getFoguete() {
        return foguete;
    }

    public void setFoguete(Foguete foguete) {
        this.foguete = foguete;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Satelite getSatelite() {
        return satelite;
    }

    public void setSatelite(Satelite satelite) {
        this.satelite = satelite;
    }
}

