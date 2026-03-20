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
            Connection conn = ConnectionData.getConnection();
            System.out.println("Digite o ID do Foguete:");
            int ID_Fog = input.nextInt();
            //--------Fog----------------
            String sql = "UPDATE foguete SET STATUS = ? WHERE ID_FOGUETE = ?"; //Aqui pega o Foguete desejado mas so no banco
            PreparedStatement stmt_Fog = conn.prepareStatement(sql);
            stmt_Fog.setString(1,"Em missão");
            stmt_Fog.setInt(2,ID_Fog);
            ResultSet rs_Fog = stmt_Fog.executeQuery();

            //--------Sat----------------
            System.out.println("Digite o ID do Foguete:");
            int ID_Sat = input.nextInt();
            PreparedStatement stmt_Sat = conn.prepareStatement("UPDATE  satelite SET STATUS= ? WHERE ID_SATELITE = ?");
            stmt_Fog.setString(1,"Em missao");
            stmt_Sat.setInt(2,ID_Sat);
            ResultSet rs_Sat = stmt_Sat.executeQuery();

            //Validar ce vai dar certo
            if(rs_Fog.next()){ //Encontrou um resultado
                double carga_util = rs_Fog.getFloat("CARGA_UTIL");
                double peso = rs_Sat.getFloat("MASSA");

                if(peso >= carga_util){
                    System.out.printf("\nO satelite %d não suporta o peso do satelite %d",ID_Fog,ID_Sat);
                }
                else{
                    System.out.print("Missão enviada");
                    /*
                    * Criar a missao na tabela da MISSAO mudar status Foguete e Sat para "em Missão" vincular astrounautas para a missão
                    * */
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}