package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.jdbc.ConnectionFactory;

public class ProdutoDAO implements IProdutoDAO{
    
 @Override
    public Integer cadastrar(Produto produto) throws SQLException{
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "insert into tb_produtos (id,nome,codigo,valor) values (nextval('sq_produtos'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getCodigo());
            stm.setDouble(3, produto.getValor());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_produtos where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
            }
            return produto;
        } catch (Exception e) {
            throw e;
        }finally{
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception{
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = delete();
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = sqlUpdate();
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getCodigo());
            stm.setDouble(3, produto.getValor());
            stm.setLong(4, produto.getId());
            return stm.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscartodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        List<Produto> lista = new ArrayList<>();
        try {
           connection = ConnectionFactory.getConnection();
           String sql = buscartodosBancoDados();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                Double valor = rs.getDouble("valor");
                produto.setId(id);
                produto.setNome(nome);
                produto.setCodigo(codigo);
                produto.setValor(valor);
                lista.add(produto);
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return lista;
    }

    private String buscartodosBancoDados(){
        return "select * from tb_produtos";
    }

    private String delete() {
        return "delete from tb_produtos where codigo = ?";
    }

    private String sqlUpdate() {
        StringBuilder builder = new StringBuilder();
        builder.append("update tb_produtos set nome = ?, codigo = ?, valor = ? where id = ?");
        return builder.toString();
    }

}
