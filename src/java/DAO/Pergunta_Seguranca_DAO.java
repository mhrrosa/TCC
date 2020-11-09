/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Pergunta_Seguranca;
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
public class Pergunta_Seguranca_DAO {
     public static Connection conexao_BD;
    
    public static ResultSet r;
    
    public static PreparedStatement st;
    
    public Pergunta_Seguranca_DAO()
    {
        Pergunta_Seguranca_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    
    public ObservableList<Pergunta_Seguranca> select_Pergunta_Seguranca()
    {
        try{
           
            ObservableList<Pergunta_Seguranca> Perguntas_Seguranca = FXCollections.observableArrayList();
            PreparedStatement stmt = this.conexao_BD.prepareStatement(
                "SELECT * FROM pergunta_seguranca" 
                );
            
            ResultSet rs = stmt.executeQuery();
            
            r = rs;
            st = stmt;
            
            while(rs.next()){
 
                Pergunta_Seguranca ps = new Pergunta_Seguranca();
                
                ps.setPergunta_seguranca(rs.getString("pergunta_seguranca"));

                ps.setId_pergunta_seguranca(rs.getInt("id_pergunta_seguranca"));
                
                Perguntas_Seguranca.add( ps );
                
            }
  
            stmt.executeQuery();
            
            return Perguntas_Seguranca;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
}

