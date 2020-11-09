/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Estado;
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
public class Estado_DAO {
     public static Connection conexao_BD;
    
    public static ResultSet r;
    
    public static PreparedStatement st;
    
    public Estado_DAO()
    {
        Estado_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    
    public ObservableList<Estado> select_Estado()
    {
        try{
           
            ObservableList<Estado> Estados = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "SELECT * FROM estado" 
                );
            
            ResultSet rs = stmt.executeQuery();
            
            r = rs;
            st = stmt;
            
            while(rs.next()){
 
                Estado estado = new Estado();
                
                
                estado.setId_estado(rs.getInt("id_estado"));
                        
                estado.setNome_estado(rs.getString("nome_estado"));
                
                Estados.add( estado );
                
            }
  
            stmt.executeQuery();
            
            return Estados;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
}

