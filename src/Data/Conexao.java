package Data;

import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "root";
    private static final String Senha = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, Senha);
    }
}
