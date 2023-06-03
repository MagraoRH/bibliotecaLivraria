package dao;

import Model.Editora;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditoraDAO {

    public void cadastrarEditoraDAO(Editora eVO) {
//busca conecão com o BD
        try {
            Connection con = Conexao.getConexao();
            String sql;
            sql = "insert into editoras values (null, ?,?,?, ?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, eVO.getnomeEditora());
            pst.setString(2, eVO.getcnpj());
            pst.setString(3, eVO.Getendereco());
            pst.setString(4, eVO.Gettelefone());
            pst.setString(5, eVO.getgerente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }

    }

    public ArrayList<Editora> getEditorasDAO() {
        ArrayList<Editora> editoras = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from editoras";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Editora e = new Editora();
                e.setIdEditora(rs.getInt("ideditora"));
                e.setCnpj(rs.getString("cnpj"));
                e.setEndereco(rs.getString("endereco"));
                e.setGerente(rs.getString("gerente"));
                e.setNomeEditora(rs.getString("nomeEditora"));
                e.setTelefone(rs.getString("telefone"));
                editoras.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return editoras;
    }

    public Editora getEditoraByDoc(String cnpj) {
        Editora e = new Editora();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from editoras where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdEditora(rs.getInt("ideditora"));
                e.setCnpj(rs.getString("cnpj"));
                e.setEndereco(rs.getString("endereco"));
                e.setGerente(rs.getString("gerente"));
                e.setNomeEditora(rs.getString("nomeEditora"));
                e.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar CNPJ!\n"
                    + ex.getMessage());
        }
        return e;
    }

    public void deletarEditoraDAO(String cnpj) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from editoras where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar CNPJ!\n"
                    + ex.getMessage());
        }
    }

    public void atualizarEditoraByDoo(Editora eVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update editoras set nomeEditora = ?, endereco = ?,telefone = ?, gerente = ? " + "where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, eVO.getnomeEditora());
            pst.setString(5, eVO.getcnpj());
            pst.setString(2, eVO.Getendereco());
            pst.setString(3, eVO.Gettelefone());
            pst.setString(4, eVO.getgerente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar CNPJ:\n" + ex.getMessage());
        }
    }
}
