package org.example.Objetos;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Satelite {
    private int ID;
    private String nome;
    private String status;
    private double massa;
    private double velo_orbital;
    private LocalDateTime criadoem;
    private LocalDate datalancamento;


    public Satelite(int ID,String nome, double massa, double velo_orbital, LocalDate datalancamento,String status, LocalDateTime criadoem){
        this.ID= ID;
        this.nome = nome;
        this.massa= massa;
        this.velo_orbital = velo_orbital;
        this.datalancamento=datalancamento;
        this.status = status;
        this.criadoem=criadoem;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtfDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return "Foguete {" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", Massa=" + massa +
                ", velo_orbital=" + velo_orbital +
                ", status=" + status +
                ", criadoem=" + (criadoem != null ? criadoem.format(dtfDateTime) : "N/A") +
                ", datalancamento=" + (datalancamento != null ? datalancamento.format(dtfDate) : "N/A") +
                '}';
    }
}
