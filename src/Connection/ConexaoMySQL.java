package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Erivelton e Matheus Vinicius
 */

/*
 Conexão com o banco de dados
 */
public class ConexaoMySQL {

   private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/setadespatrimonio";
    private final static String USER = "root";
    private final static String PASSWORD = "";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }

    }

    public static void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection2(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection3(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection2(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
