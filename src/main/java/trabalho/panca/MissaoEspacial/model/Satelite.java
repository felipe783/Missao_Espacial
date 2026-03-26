package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SATELITE_TABELA")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SATELITE")
    private Long id_satelite;

    @Column(name = "NOME_SATELITE")
    private String nome_satelite;

    @Column(name = "STATUS_SATELITE")
    private String status_satelite;

    @Column(name = "MASSA_SATELITE")
    private double massa_satelite;

    @Column(name = "VELO_ORBITAL")
    private double velo_orbital;

    @Column(name = "SATELITE_CRIADOEM")
    private LocalDateTime criadoem;

    @Column(name = "DATA_LACAMENTO_SAT")
    private LocalDate datalancamento;

    public Satelite(Long id_satelite, double velo_orbital, String nome_satelite, String status_satelite, double massa_satelite, LocalDate datalancamento, LocalDateTime criadoem) {
        this.id_satelite = id_satelite;
        this.velo_orbital = velo_orbital;
        this.nome_satelite = nome_satelite;
        this.status_satelite = status_satelite;
        this.massa_satelite = massa_satelite;
        this.datalancamento = datalancamento;
        this.criadoem = criadoem;
    }

    public Long getId_satelite() {
        return id_satelite;
    }

    public void setId_satelite(Long id_satelite) {
        this.id_satelite = id_satelite;
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
    }

    public LocalDateTime getCriadoem() {
        return criadoem;
    }

    public void setCriadoem(LocalDateTime criadoem) {
        this.criadoem = criadoem;
    }

    public double getVelo_orbital() {
        return velo_orbital;
    }

    public void setVelo_orbital(double velo_orbital) {
        this.velo_orbital = velo_orbital;
    }

    public double getMassa_satelite() {
        return massa_satelite;
    }

    public void setMassa_satelite(double massa_satelite) {
        this.massa_satelite = massa_satelite;
    }

    public String getNome_satelite() {
        return nome_satelite;
    }

    public void setNome_satelite(String nome_satelite) {
        this.nome_satelite = nome_satelite;
    }

    public String getStatus_satelite() {
        return status_satelite;
    }

    public void setStatus_satelite(String status_satelite) {
        this.status_satelite = status_satelite;
    }
}
