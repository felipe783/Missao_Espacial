package org.example.Data;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection; //Criar conexão com SQL
import java.sql.DriverManager; //Conexçao JDBC

public class ConnectionData {

    private static Connection connection; //Cria a variavel do tipo Connection

    public static Connection getConnection() throws Exception{
        /*
        Aqui basicamente ele cria a conexão ce não existir ou reutiliza
        o GetConnection() pega a conexão com o banco de dados
        "throws Exception" avisa pro Java que o metodo pode dar erro e ele meio q ignora os erros
        */
        if (connection == null || connection.isClosed()) { //Verifica ce conectou ou se a conexão foi fechada
            //Carrega a ENV e puxa as variaveis
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            connection = DriverManager.getConnection(url, user, password);
            /*
            Não da recursão na função por conta dela Chamar o DriverManager.getConnection(...) esse get é do drivermanager
            DriverManager é onde gerencia os drivers do DB
            O getConnection(url, user, senha) tentar fazer um conexão com o DB usando esse paramentros
            * */
        }

        return connection;
    }
}
