package tooltip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {


 private static final String SCHEMA = "tooltip_com_imagens_db";

 private static final String URL =
         "jdbc:mysql://localhost:3306/" + SCHEMA +
         "?useSSL=false&useUnicode=true&characterEncoding=utf8" +
         "&serverTimezone=America/Sao_Paulo";

 private static final String URL_BASE =
         "jdbc:mysql://localhost:3306/" +
         "?useSSL=false&useUnicode=true&characterEncoding=utf8" +
         "&serverTimezone=America/Sao_Paulo";

 private static final String USUARIO = "root";

 private static final String SENHA   = "$aluno123db";

 static {

     try {

         Class.forName("com.mysql.cj.jdbc.Driver");

         criarBancoSeNaoExistir();

     } catch (Exception e) {

         e.printStackTrace();
         
     }
 }


 private static void criarBancoSeNaoExistir() throws SQLException {

     try (
         Connection con = DriverManager.getConnection(URL_BASE, USUARIO, SENHA);
         Statement st = con.createStatement() 		
     ) {

         st.executeUpdate(
             "CREATE DATABASE IF NOT EXISTS " + SCHEMA +
             " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci"
         );
         
     }
 }

 public static Connection obterConexao() throws SQLException {

     try {

         return DriverManager.getConnection(URL, USUARIO, SENHA);

     } catch (SQLException e) {

         throw new SQLException(
             "Falha ao conectar no MySQL. Verifique se o serviço MySQL80 está ativo.", e
         );
         
     }
 }

}