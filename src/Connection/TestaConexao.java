/*
 teste da conexão com o banco de dados
 */
package Connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Erivelton e Matheus Vinicius
 */
public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = new connection.ConexaoMySQL().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }

}
