/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Carrinho;
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
public class Carrinho_DAO {
     public static Connection conexao_BD;
  
    public Carrinho_DAO()
    {
        Carrinho_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    
    public ObservableList<Carrinho> select_Carrinho()
    {
        try{
           
            ObservableList<Carrinho> carr = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "SELECT * FROM carrinho" 
            );
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
 
                Carrinho car = new Carrinho();
                
                car.setId_usuario(rs.getInt("id_usuario"));
                car.setId_produto(rs.getInt("id_produto"));
                
                carr.add( car );
                
            }
  
            stmt.executeQuery();
            
            return carr;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void insere_carrinho(int id_usuario, int id_produto) throws SQLException{
        
        PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "INSERT INTO carrinho (id_usuario, id_produto) VALUES (?, ?)" 
        );
        
        try{
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_produto);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
           throw new RuntimeException(e);
        }
        
    }
     public void deleta_carrinho(int id_usuario, int id_produto) throws SQLException
    {
        PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "DELETE FROM carrinho WHERE id_usuario = ? AND id_produto = ?"
        );
        
        try{
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_produto);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
