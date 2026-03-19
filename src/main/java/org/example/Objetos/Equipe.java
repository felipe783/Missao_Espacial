package org.example.Objetos;

public class Equipe {

    private int ID;
    private String nome;
    private int qntMembros;

    public Equipe(int ID, String nome, int qntMembros){
        this.ID = ID;
        this.nome = nome;
        this.qntMembros = qntMembros;
    }

    @Override
    public String toString() {
        return "Equipe {" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", qntMembros=" + qntMembros +
                '}';
    }
}
