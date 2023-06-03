package dao;

import Model.Livro;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroDAO {

    public void cadastrarLivroDAO(Livro lVO) {
//busca conecão com o BD
        try {
            Connection con = Conexao.getConexao();
            String sql;
            sql = "insert into livros values (null,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getAssunto());
            pst.setString(2, lVO.getAutor());
            pst.setString(3, lVO.getIsbn());
            pst.setString(4, lVO.getNomeLivro());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }

    }

    public ArrayList<Livro> getLivrosDAO() {
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from livros";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Livro l = new Livro();
                l.setIdLivro(rs.getInt("idLivro"));
                l.setIsbn(rs.getString("isbn"));
                l.setAssunto(rs.getString("assunto"));
                l.setAutor(rs.getString("autor"));
                l.setNomeLivro(rs.getString("nomeLivro"));
                livros.add(l);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return livros;
    }

    public Livro getLivroByDoc(String isbn) {
        Livro l = new Livro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from livros where isbn = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, isbn);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l.setIdLivro(rs.getInt("ideditora"));
                l.setIdLivro(rs.getInt("idLivro"));
                l.setIsbn(rs.getString("isbn"));
                l.setAssunto(rs.getString("assunto"));
                l.setAutor(rs.getString("autor"));
                l.setNomeLivro(rs.getString("nomeLivro"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar ISBN!\n"
                    + ex.getMessage());
        }
        return l;
    }

    public void deletarLivroDAO(String isbn) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from livros where isbn = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, isbn);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar ISBN!\n"
                    + ex.getMessage());
        }
    }

    public void atualizarLivroByDoo(Livro lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update livros set estoque = ?, preco = ?, autor = ?, assunto = ? , NomeLivro = ? , Isbn = ?" + "where isbn = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, lVO.getEstoque());
            pst.setFloat(2, lVO.getPreco());
            pst.setString(3, lVO.getAutor());
            pst.setString(4, lVO.getAssunto());
            pst.setString(4, lVO.getNomeLivro());
            pst.setString(4, lVO.getIsbn());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar ISBN:\n" + ex.getMessage());
        }
    }
}
