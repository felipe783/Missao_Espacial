package org.example.Objetos;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Foguete {

    private String nome;
    private String status;
    private int ID;
    private double combustivel;
    private double massa_total;
    private double carga_util;
    private LocalDate datalancamento; //So date
    private LocalDateTime criadoem; //Timestamp

    public Foguete(int ID,String nome, double massa_total, double carga_util, double combustivel, LocalDate datalancamento,String status, LocalDateTime criadoem){
        this.ID= ID;
        this.nome = nome;
        this.massa_total= massa_total;
        this.carga_util = carga_util;
        this.combustivel = combustivel;
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
                ", status='" + status + '\'' +
                ", combustivel=" + combustivel +
                ", massa_total=" + massa_total +
                ", carga_util=" + carga_util +
                ", datalancamento=" + (datalancamento != null ? datalancamento.format(dtfDate) : "N/A") +
                ", criadoem=" + (criadoem != null ? criadoem.format(dtfDateTime) : "N/A") +
                '}';
    }
}