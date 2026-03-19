package org.example.Testar_Conexao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            Dotenv dotenv = Dotenv.load(); //Carrega a ENV

            String url = dotenv.get("DB_URL"); //Aqui ele pega as variaveis da ENV
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            Connection conn = DriverManager.getConnection(url, user, password); //Ele tenta conexão para ver se está OK

            if (conn != null) { //Se conectar entra
                System.out.println("✅ Conectado ao banco de dados!");
            }

            conn.close(); //Fecha a conn

        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar no banco!");
            e.printStackTrace();
        }

    }
}