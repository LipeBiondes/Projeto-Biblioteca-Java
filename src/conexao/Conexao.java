package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alefe Filipe
 */
public class Conexao {

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca",
                    "root",
                    "12345678");
            System.out.println("SUCESSO!");
            Statement stmt = conn.createStatement();
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
//teste