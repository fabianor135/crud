package crud.dao;


import crud.java.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public void inserir(Produtos produto) {                      // cada ? corresponde a coluna
        String sql = "insert into produtos(nome,quantidade,valorUnitario) values (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, String.valueOf(produto.getQuantidade()));
            stmt.setString(3, String.valueOf(produto.getValorProduto()));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuário: " + ex.getMessage());
        }

    }
public ArrayList<Produtos> getAllProdutos() {
        String sql = "SELECT * FROM produtos";
        ArrayList<Produtos> produtos = new ArrayList<>();


        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {                
                int id_produto = rs.getInt("id");
                String nome = rs.getString("nome"); 
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("valorUnitario");
                


                Produtos produto = new Produtos(id_produto, nome, preco, quantidade);
                produtos.add(produto);
            }


        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Todos usuário: " + ex.getMessage());
        }


        return produtos;
    }
 public void excluir(int codigo) {
        String sql = "delete from produtos where id = ?";


        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuário: " + ex.getMessage());
        }
        
        
    }

}
