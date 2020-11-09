/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deia_
 */
public class Produto_DAO {
    public static Connection conexao_BD;
    
    public Produto_DAO()
    {
        Produto_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    public void insert_Produto(Produto produto){
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Produto(nome_produto, id_vendedor, id_categoria, preco_produto, descricao_produto)" + 
                    " VALUES (?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, produto.getNome_produto());
           stat.setInt(2, produto.getId_vendedor());
           stat.setInt(3, produto.getId_categoria());
           stat.setFloat(4, produto.getPreco_produto());
           stat.setString(5, produto.getDescricao_produto());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       
    }
    public ObservableList<Produto> select_Produto()
    {
        try{
           
            ObservableList<Produto> Prod = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "SELECT * FROM Informacoes_Produto" 
            );
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
 
                Produto produto = new Produto();
                
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setId_vendedor(rs.getInt("id_vendedor"));
                produto.setVendedor_produto(rs.getString("login"));
                produto.setId_categoria(rs.getInt("id_categoria"));
                produto.setCategoria_produto(rs.getString("nome_categoria"));
                produto.setPreco_produto(rs.getFloat("preco_produto"));
                produto.setCarrinho(rs.getInt("carrinho"));
                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setFoto_1(rs.getString("foto_1"));
                
                
                Prod.add( produto );
                
            }
  
            stmt.executeQuery();
            
            return Prod;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
     public void update_fotos(int id, String foto_1, String foto_2, String foto_3)
    {
        String sql = null;
        
        if(foto_1 != null){
        
            sql = "UPDATE produto SET foto_1 = ? WHERE id_produto = ?";
            
            try{
            PreparedStatement stmt = conexao_BD.prepareStatement(sql);
            stmt.setString(1, foto_1);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
            
        
        }
            
        }
    
        
        public void update_produto(Produto produto){
            
            String sql = "UPDATE produto SET nome_produto = ?, preco_produto = ?, descricao_produto = ?, id_categoria = ? WHERE id_produto = ?";

            try{
                PreparedStatement stmt = conexao_BD.prepareStatement(sql);
                stmt.setString(1, produto.getNome_produto());
                stmt.setFloat(2, produto.getPreco_produto());
                stmt.setString(3, produto.getDescricao_produto());
                stmt.setInt(4, produto.getId_categoria());
                stmt.setInt(5, produto.getId_produto());
                stmt.execute();
                stmt.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        
        }
         public void deleta_Produto(int id_produto)
    {
        String sql_favoritos = "DELETE FROM carrinho WHERE id_produto = ?";
        String sql_produtos = "DELETE FROM produto WHERE id_produto = ?";
        
        try{
            PreparedStatement stmt = conexao_BD.prepareStatement(sql_favoritos);
            stmt.setInt( 1, id_produto );
            stmt.execute();
            
            stmt = conexao_BD.prepareStatement(sql_produtos);
            stmt.setInt(1, id_produto );
            stmt.execute();
            
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
   
}
