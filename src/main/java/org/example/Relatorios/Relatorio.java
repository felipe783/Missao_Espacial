package org.example.Relatorios;

import org.example.Data.*;

import java.sql.*;
import java.sql.PreparedStatement;

public class Relatorio {
    public static int Relatorios_Mostrar(int resposta){
        try{
            Connection conn = ConnectionData.getConnection();
            String colunaID=null;
            String sql = null;
            switch(resposta){ //Aqui ele vai trazer todos os Objetos da tabela com as variaveis ID, NOME
                case 1: //Satelite
                    sql = "SELECT ID_SATELITE, NOME, STATUS FROM satelite";
                    colunaID= "ID_SATELITE";
                    break;
                case 2: // Foguete
                    sql = "SELECT ID_FOGUETE, NOME, STATUS FROM foguete";
                    colunaID= "ID_FOGUETE";
                    break;
                case 3: //Equipes
                    sql = "SELECT ID_EQUIPE, NOME FROM equipe";
                    colunaID= "ID_EQUIPE";
                    break;
                case 4: // Membros
                    sql = "SELECT ID, NOME FROM astronautas";
                    colunaID= "ID";
                    break;
                case 5: // Missao
                    sql = "SELECT ID_MISSAO, NOME_MISSAO FROM missao";
                    colunaID= "ID_MISSAO";
                    break;
                default:
                    System.out.print("Opção Invalida");
                    return -1; //Vai evitar o sql null
            }
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //Executa a Query

            System.out.println("+----------------------+----------------------+");
            System.out.printf("| %-20s | %-20s |%n", "ID", "NOME");
            System.out.println("+----------------------+----------------------+");
            while(rs.next()){
                int id = rs.getInt(colunaID);
                String nome = rs.getString("NOME");
                System.out.printf("| %-20d | %-20s |%n", id, nome);
            }
            System.out.println("+----------------------+----------------------+");

            conn.close();
            return resposta;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
