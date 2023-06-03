package dao;

import Model.Cliente;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public void cadastrarClienteDAO(Cliente cVO) {
//busca conecão com o BD
        try {
            Connection con = Conexao.getConexao();
            String sql;
            sql = "insert into clientes values (null, ?,?, null, ?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getNomeCliente());
            pst.setString(2, cVO.getCpf());
            pst.setString(3, cVO.getEndereco());
            pst.setString(4, cVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }

    }

    public ArrayList<Cliente> getClientesDAO() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from clientes";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idcliente"));
                c.setCpf(rs.getString("cpf"));
                c.setNomeCliente(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return clientes;
    }

    public Cliente getClienteByDoc(String cpf) {
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from clientes where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            c.setIdCliente(rs.getInt("idcliente"));
            c.setCpf(rs.getString("cpf"));
            c.setNomeCliente(rs.getString("nome"));
            c.setEndereco(rs.getString("endereço"));
            c.setTelefone(rs.getString("telefone"));
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar CPF!\n"
                    + ex.getMessage());
        }
        return c;
    }

    public void deletarClienteDAO(String cpf) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from clientes where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar CPF!\n"
                    + ex.getMessage());
        }
    }

    public void atualizarClienteByDoo(Cliente cVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update clientes set nome = ?, endereco = ?,telefone = ? " + "where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getNomeCliente());
            pst.setString(2, cVO.getEndereco());
            pst.setString(3, cVO.getTelefone());
            pst.setString(4, cVO.getCpf());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar CPF:\n" + ex.getMessage());
        }
    }
}
