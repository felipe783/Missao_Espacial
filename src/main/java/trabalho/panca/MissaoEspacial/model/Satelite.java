package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "satelite_tabela")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome_satelite;
    private String status_satelite;
    private double massa_satelite;
    private double velo_orbital;
    private LocalDateTime criadoem;
    private LocalDate datalancamento;

    public Satelite(LocalDate datalancamento, LocalDateTime criadoem, double velo_orbital, double massa_satelite, String status_satelite, int id, String nome_satelite) {
        this.datalancamento = datalancamento;
        this.criadoem = criadoem;
        this.velo_orbital = velo_orbital;
        this.massa_satelite = massa_satelite;
        this.status_satelite = status_satelite;
        this.id = id;
        this.nome_satelite = nome_satelite;
    }

    public int getid_satelite(){
        return id;
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

    public double getMassa_satelite() {
        return massa_satelite;
    }

    public void setMassa_satelite(double massa_satelite) {
        this.massa_satelite = massa_satelite;
    }

    public double getVelo_orbital() {
        return velo_orbital;
    }

    public void setVelo_orbital(double velo_orbital) {
        this.velo_orbital = velo_orbital;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
