package org.example.Missao;

import org.example.Data.ConnectionData;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mostrar_Missao {
    public static void MostrarMissao(){
        try{
            Connection conn = ConnectionData.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM missao");
            stmt.executeQuery();

            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
