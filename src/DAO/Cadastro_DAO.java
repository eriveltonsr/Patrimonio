/*
 Cadastro de itens de patrimonio
 */
package DAO;

import Bean.Itens;
import Bean.Setores;
import connection.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erivelton e Matheus Vinicius
 */
public class Cadastro_DAO {

    private Connection connection;

    int Patrimonio;
    String nome_setor_receber;
    String nome_setor_envio;
    String descricao;
    Date date_saida_setor;

    public Cadastro_DAO() {
        this.connection = new ConexaoMySQL().getConnection();
    }
    // cadastra itens
    public void cadastra(Itens itens) {
        String sql = "INSERT INTO item (nome_item, patrimonio_numero, setor_envio, setor_recebido) values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            
            stmt.setString(1, itens.getNome_item());
            stmt.setInt(2, itens.getPatrimonio_numero());
            stmt.setString(3, itens.getSetor_envio());
            stmt.setString(4, itens.getSetor_recebido());
            stmt.executeUpdate();
            
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }    
    
    
     // atualiza  usuario   
    public void update(Itens itens) {
        Connection con = ConexaoMySQL.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update item set nome_item=? ,patrimonio_numero=?,setor_envio=?,setor_recebido=? where id=?");
            stmt.setString(1, itens.getNome_item());
            stmt.setInt(2, itens.getPatrimonio_numero());
            stmt.setString(3, itens.getSetor_envio());
            stmt.setString(4, itens.getSetor_recebido());
            stmt.setInt(5,itens.getId());
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);

        } finally {
            ConexaoMySQL.closeConnection2(con, stmt);
        }

    }
    //apaga um registro
    public void delete(Itens itens) {
        Connection con = ConexaoMySQL.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from item where id=?");
            
            stmt.setInt(1,itens.getId());
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro" + ex);

        } finally {
            ConexaoMySQL.closeConnection2(con, stmt);
        }

    }
    
    public List<Itens> carregar(){

        Connection con = ConexaoMySQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Itens> itens = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from item");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Itens item = new Itens();
                item.setPatrimonio_numero(rs.getInt("patrimonio_numero"));
                item.setSetor_envio(rs.getString("setor_envio"));
                item.setSetor_recebido(rs.getString("setor_recebido"));
                item.setNome_item(rs.getString("nome_item"));
                item.setData_hora(rs.getDate("data_hora"));
                item.setId(rs.getInt("id"));               
                itens.add(item);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       finally {
            ConexaoMySQL.closeConnection3(con, stmt, rs);
        }
        
        return itens;
    }
}
