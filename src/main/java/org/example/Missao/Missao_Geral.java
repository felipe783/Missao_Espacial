package org.example.Missao;

import org.example.Data.ConnectionData;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Missao_Geral {
    public static Scanner input = new Scanner(System.in);
    public static void Mostrar_SatFog() {
        try {
            Connection conn = ConnectionData.getConnection(); //Conexão SQL

            // SATÉLITES
            PreparedStatement stmtSat = conn.prepareStatement("SELECT * FROM satelite");
            ResultSet rsSat = stmtSat.executeQuery();

            System.out.println("+----------------------+----------------------+");
            System.out.printf("| %-20s | %-20s |%n", "ID_SATELITE", "NOME");
            System.out.println("+----------------------+----------------------+");

            while(rsSat.next()){ // Ir linha por linha mostrar a tabela
                int id = rsSat.getInt("ID_SATELITE");
                String nome = rsSat.getString("NOME");
                System.out.printf("| %-20d | %-20s |%n", id, nome);
            }
            System.out.println("+----------------------+----------------------+\n");

            //FOGUETES
            PreparedStatement stmtFoguete = conn.prepareStatement("SELECT * FROM foguete");
            ResultSet rsFog = stmtFoguete.executeQuery();

            System.out.println("+----------------------+----------------------+");
            System.out.printf("| %-20s | %-20s |%n", "ID_FOGUETE", "NOME");
            System.out.println("+----------------------+----------------------+");

            while(rsFog.next()){
                int id = rsFog.getInt("ID_FOGUETE");
                String nome = rsFog.getString("NOME");
                System.out.printf("| %-20d | %-20s |%n", id, nome);
            }
            System.out.println("+----------------------+----------------------+\n");

            //Fecha recursos
            rsSat.close();
            stmtSat.close();
            rsFog.close();
            stmtFoguete.close();
            conn.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void Cadastrar_Missao(){
        try{
            System.out.println("Digite o ID do Foguete:");
            int ID_Fog = input.nextInt();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}