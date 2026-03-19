package org.example.Relatorios;

import org.example.Data.ConnectionData;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pesquisar_ID {
    public static void Pesquisar(int resposta) {
        Scanner input = new Scanner(System.in);
        try{
            //Conexão com SQL
            Connection conn = ConnectionData.getConnection();
            String sql = null;

            //Input do usuario
            System.out.println("Digite o ID:");
            int ID = input.nextInt();

            switch(resposta){ //Aqui já filtra por ID no final eu apenas mostro o resultado
                case 1: //Satelite
                    sql = "SELECT * FROM satelite WHERE ID_SATELITE = ?";
                    break;
                case 2: // Foguete
                    sql = "SELECT * FROM foguete WHERE ID_FOGUETE = ?";
                    break;
                case 3: //Equipes
                    sql = "SELECT * FROM equipe WHERE ID_EQUIPÉ = ?";
                    break;
                case 4: // Membros
                    sql = "SELECT * FROM astronautas WHERE ID = ?";
                    break;
                case 5: // Missao
                    sql = "SELECT * FROM missao WHERE ID_MISSAO = ?";
                    break;
                default:
                    System.out.print("Opção Invalida");
                    return; //Vai evitar o sql null
            }
            //Executa a QUERY
            PreparedStatement stmt = conn.prepareStatement(sql); //Ta recebendo o comando
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery(); //Executa o comando,o resultSet é um tipagem onde ele recebe um resultado de um Query

            ResultSetMetaData meta = rs.getMetaData(); //Aqui eu to pegando a tabela que retornou pelo Switch
            int colunas = meta.getColumnCount(); //Descobre quantas colunas existem

            if (rs.next()) { // Move pro primeiro item da tabela que no caso seria o 1
                for (int i = 1; i <= colunas; i++) { //Percorre todas as colunas
                    String nomeColuna = meta.getColumnName(i); //Péga o nome da coluna
                    String valor = rs.getString(i); //Valor da coluna

                    System.out.println(nomeColuna + ": " + valor);
                }
            } else {
                System.out.println("Nenhum resultado encontrado 😰");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}