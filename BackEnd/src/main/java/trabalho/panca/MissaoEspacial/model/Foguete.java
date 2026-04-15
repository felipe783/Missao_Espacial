package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FOGUETE_TABELA")
public class Foguete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FOGUETE")
    private Long id_foguete;

    @Column(name = "NOME_FOGUETE")
    private String nome_foguete;

    @Column(name = "STATUS_FOGUETE")
    private String status_foguete;

    @Column(name = "COMBUSTIVEL_FOGUETE")
    private double combustivel;

    @Column(name = "MASSA_TOTAL")
    private double massa_total;

    @Column(name = "CARGA_UTIL")
    private double carga_util;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDate datalancamento;//So date

    @Column(name = "FOGUETE_CRIADOEM")
    private LocalDateTime criadoem;

    public Foguete(String nome_foguete, String status_foguete, Long id_foguete, double combustivel, double massa_total, double carga_util, LocalDate datalancamento, LocalDateTime criadoem) {
        this.nome_foguete = nome_foguete;
        this.status_foguete = status_foguete;
        this.id_foguete = id_foguete;
        this.combustivel = combustivel;
        this.massa_total = massa_total;
        this.carga_util = carga_util;
        this.datalancamento = datalancamento;
        this.criadoem = criadoem;
    }

    public String getNome_foguete() {
        return nome_foguete;
    }

    public void setNome_foguete(String nome_foguete) {
        this.nome_foguete = nome_foguete;
    }

    public LocalDateTime getCriadoem() {
        return criadoem;
    }

    public void setCriadoem(LocalDateTime criadoem) {
        this.criadoem = criadoem;
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
    }

    public double getCarga_util() {
        return carga_util;
    }

    public void setCarga_util(double carga_util) {
        this.carga_util = carga_util;
    }

    public double getMassa_total() {
        return massa_total;
    }

    public void setMassa_total(double massa_total) {
        this.massa_total = massa_total;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public Long getId_foguete() {
        return id_foguete;
    }

    public void setId_foguete(Long id_foguete) {
        this.id_foguete = id_foguete;
    }

    public String getStatus_foguete() {
        return status_foguete;
    }

    public void setStatus_foguete(String status_foguete) {
        this.status_foguete = status_foguete;
    }
}
