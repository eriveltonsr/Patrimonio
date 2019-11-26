package DAO;

import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bean.Setores;
import javax.swing.JOptionPane;
/**
 *
 * @author Erivelton e Matheus Vinicius
 */
public class SetoresDao {   
    
    public List<Setores> carregar(){

        Connection con = ConexaoMySQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Setores> setores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from setores");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Setores setor = new Setores();
                setor.setSetor_cod(rs.getInt("setor_cod"));
                setor.setSetor_numero(rs.getInt("setor_numero"));
                setor.setSetor_nome(rs.getString("setor_nome"));
                setores.add(setor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       finally {
            ConexaoMySQL.closeConnection3(con, stmt, rs);
        }
        
        return setores;   
        
    }    
}
