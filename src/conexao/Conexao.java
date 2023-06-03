package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {

    //cria uma constante com endereco do BD/Schema
    private static String url = "jdbc:mysql://localhost:3306/livraria";
    //cria uma constante um ser do BD (Banco de Dados)
    private static String user = "root";
    //cria uma constante com senha do BD (Banco de Dados)
    private static String pass = "";

    public static Connection getConexao() throws SQLException {
        //inicia conexão nula, ainda não estabelecida
        Connection c = null;
        //tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            //caso haja erro na conexão
            throw new SQLException("Erro ao conectar!"
                    + ex.getMessage());
        }
        return c;
    }
}
