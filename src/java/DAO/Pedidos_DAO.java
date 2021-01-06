/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Pedido;
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
public class Pedidos_DAO {
     public static Connection conexao_BD;
  
    public Pedidos_DAO()
    {
        Pedidos_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    
    public ObservableList<Pedido> select_Pedidos()
    {
        try{
           
            ObservableList<Pedido> pedi = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "SELECT * FROM pedidos" 
            );
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
 
                Pedido ped = new Pedido();
                
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setId_usuario(rs.getInt("id_usuario"));
                ped.setId_produto(rs.getInt("id_produto"));
                ped.setTipo(rs.getString("tipo"));
                
                pedi.add( ped );
                
            }
  
            stmt.executeQuery();
            stmt.close(); 
            return pedi;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void insere_pedidos(int id_usuario, int id_produto, String tipo) throws SQLException{
        
        PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "INSERT INTO pedidos (id_usuario, id_produto, tipo) VALUES (?, ?,?)" 
        );
        
        try{
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, id_produto);
            stmt.setString(3, tipo);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
           throw new RuntimeException(e);
        }
        
    }
     public void deleta_pedidos(int id_usuario, int id_produto) throws SQLException
    {
        PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "DELETE FROM pedidos WHERE id_usuario = ? AND id_produto = ?"
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
