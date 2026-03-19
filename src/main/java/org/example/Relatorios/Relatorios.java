package org.example.Relatorios;

import org.example.Data.ConnectionData;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;

public class Relatorios {
    public static int Relatorios_Mostrar(){
        try{
            Connection conn = ConnectionData.getConnection();
            int resposta = Opcao.Mostrar_Opcao(); // Mostra as opções
            String sql = null;
            switch(resposta){ //Aqui ele vai trazer todos os Objetos da tabela com as variaveis ID, NOME
                case 1: //Satelite
                    sql = "SELECT ID, NOME FROM satelite";
                    break;
                case 2: // Foguete
                    sql = "SELECT ID, NOME FROM foguete";
                    break;
                case 3: //Equipes
                    sql = "SELECT ID, NOME FROM equipe";
                    break;
                case 4: // Membros
                    sql = "SELECT ID, NOME FROM astronautas";
                    break;
                case 5: // Missao
                    sql = "SELECT ID, NOME FROM missao";
                    break;
                default:
                    System.out.print("Opção Invalida");
                    return -1; //Vai evitar o sql null
            }
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //Executa a Query

            while(rs.next()){ //Anda linha a linha da tabela
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                System.out.println("ID:" + id + "\nNome:" + nome);
            }
            return resposta;
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
