package org.example.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionData{
    private static Connection connection;
    public static synchronized Connection getConnection() throws SQLException {
        /*
        Aqui basicamente ele cria a conexão ce não existir ou reutiliza
        o GetConnection() pega a conexão com o banco de dados
        "throws Exception" avisa pro Java que o metodo pode dar erro e ele meio q ignora os erros
        */
        if (connection == null || connection.isClosed()) { //Verifica se a conexão nunca foi criada ou foi fechada
            Dotenv dotenv = Dotenv.load();

            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            connection = DriverManager.getConnection(url, user, password); //Driver manager Procura o drive do banco(Mysql)
            /*
            Não da recursão na função por conta dela Chamar o DriverManager.getConnection(...) esse get é do drivermanager
            DriverManager é onde gerencia os drivers do DB
            O getConnection(url, user, senha) tentar fazer um conexão com o DB usando esse paramentros
            * */
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) { //So fecha ce a conexão existe e ta aberta
            connection.close();
        }
    }
}