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
            boolean valido = false;
            while(!valido) {
                Connection conn = ConnectionData.getConnection();
                String sql = null;

                System.out.println("Digite o Nome da Missão");
                String nomeM = input.nextLine();

                System.out.println("Digite o ID do Foguete:");
                int ID_Fog = input.nextInt();

                //--------Sat----------------
                System.out.println("Digite o ID do Satelite:");
                int ID_Sat = input.nextInt();
                input.nextLine(); // limpa o ENTER pra não buggar o próximo nextLine()

                //Validar ce vai dar certo
                String sqlFog = "SELECT CARGA_UTIL FROM foguete WHERE ID_FOGUETE = ?";
                PreparedStatement stmt_Fog = conn.prepareStatement(sqlFog); //Deixar Pré Preaprado
                stmt_Fog.setInt(1, ID_Fog); //Primeiro "Seta" os valores
                ResultSet rs_Fog = stmt_Fog.executeQuery(); // Depois roda

                String sqlSat = "SELECT MASSA FROM satelite WHERE ID_SATELITE = ?";
                PreparedStatement stmt_Sat = conn.prepareStatement(sqlSat);
                stmt_Sat.setInt(1, ID_Sat);
                ResultSet rs_Sat = stmt_Sat.executeQuery();

                if (rs_Fog.next() && rs_Sat.next()) { //Encontrou um resultado
                    double carga_util = rs_Fog.getDouble("CARGA_UTIL");
                    double peso = rs_Sat.getDouble("MASSA");

                    if (peso >= carga_util) {
                        System.out.printf("\nO satelite %d não suporta o peso do foguete %d\n", ID_Sat, ID_Fog);
                    }
                    else{
                        valido = true;

                        sql = "INSERT INTO missao(ID_SATELITE,ID_FOGUETE,NOME_MISSAO,STATUS) VALUES(?,?,?,?)";
                        PreparedStatement stmt_missao = conn.prepareStatement(sql);
                        //----Add valores
                        stmt_missao.setInt(1, ID_Sat);
                        stmt_missao.setInt(2, ID_Fog);
                        stmt_missao.setString(3, nomeM);
                        stmt_missao.setString(4, "Missao em Orbita");

                        stmt_missao.executeUpdate();

                        //Aqui pega o Foguete desejado mas so no banco e "Seta" para em missão
                        PreparedStatement update_Fog = conn.prepareStatement("UPDATE foguete SET DATA_LANCAMENTO = NOW(),STATUS = ? WHERE ID_FOGUETE = ?");
                        update_Fog.setString(1, "Em missão");
                        update_Fog.setInt(2, ID_Fog);
                        update_Fog.executeUpdate();

                        PreparedStatement update_Sat = conn.prepareStatement(
                                "UPDATE satelite SET DATA_LANCAMENTO = NOW(), STATUS = ? WHERE ID_SATELITE = ?"
                        );
                        update_Sat.setString(1, "Em missao");
                        update_Sat.setInt(2, ID_Sat);
                        update_Sat.executeUpdate();

                        System.out.print("Missão enviada 🚀🔥");

                        /*
                         * Criar a missao na tabela da MISSAO mudar status Foguete e Sat para "em Missão" vincular astrounautas para a missão
                         * */
                    }
                }
                else {
                    System.out.println("ID do foguete ou satélite não encontrado.");
                }
                conn.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}