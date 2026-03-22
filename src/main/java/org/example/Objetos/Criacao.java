package org.example.Objetos;
import org.example.Data.ConnectionData;

import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Criacao{
    public static Scanner input = new Scanner(System.in);


    public static void criar_satelite(){
        System.out.println("Nome:");
        String nome = input.nextLine();

        System.out.println("Massa total:");
        double massa = input.nextDouble();

        System.out.println("Velocidade Orbital:");
        double velo_orbital = input.nextDouble();

        try{
            Connection conn = ConnectionData.getConnection();
            String sql = "INSERT INTO satelite(NOME,MASSA,VELOCIDADE_ORBITAL) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setDouble(2,massa);
            stmt.setDouble(3,velo_orbital);
            stmt.executeUpdate();

            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void criar_foguete(){
        System.out.println("Nome:");
        String nome = input.nextLine();

        System.out.println("Massa total:");
        double massa_total = input.nextDouble();

        System.out.println("Carga util:");
        double carga = input.nextDouble();

        System.out.println("Combustivel Máx:");
        double combustivel = input.nextDouble();

        try{
            Connection conn = ConnectionData.getConnection(); //Cria conexão com o SQL com a função no Arquivo Connection
            String sql = "INSERT INTO foguete (NOME,MASSA_TOTAL,CARGA_UTIL,COMBUSTIVEL) VALUES (?, ?, ?, ?)";
            //Esses "?" São que os valores irão ser preenchidos depois
            PreparedStatement  stmt = conn.prepareStatement(sql);
            /*
            Esse statement cria um objeto onde eu posso tacar comandos pro SQL
            E to passando o sql que é o comando inteiro
            * */
            stmt.setString(1, nome);
            stmt.setDouble(2, massa_total);
            stmt.setDouble(3, carga);
            stmt.setDouble(4, combustivel);
            stmt.executeUpdate(); // Aqui ele lança pro Sql

            conn.close();
        }
        catch(Exception e){
            e.printStackTrace(); //Ele imprime o ERRO todo e o caminho do codigo
        }
    }
    public static void Mostrar(){
        while(true){ //Inputs
            System.out.println("Qual deseja criar?");
            int resposta = input.nextInt();
            input.nextLine();
            if (resposta==3){
                System.out.println("Encerrando programa de criação...");
                System.exit(0);
                break;
            }
            else{
                if(resposta==1){ //Satelite
                    Criacao.criar_satelite();
                }
                else{ //Foguete
                    Criacao.criar_foguete();
                }
            }
        }
    }
}
