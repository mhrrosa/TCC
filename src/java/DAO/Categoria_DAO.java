package DAO;


import Jdbc.Connection_Factory;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author <Gabriel Mello de Oliveira
 */

public class Categoria_DAO {
    
    public static Connection conexao_BD;
  
    public Categoria_DAO()
    {
        Categoria_DAO.conexao_BD = Connection_Factory.getConnection();
    }
    
    public ObservableList<Categoria> select_Categoria()
    {
        try{
           
            ObservableList<Categoria> Categorias = FXCollections.observableArrayList();
            PreparedStatement stmt = Categoria_DAO.conexao_BD.prepareStatement(
                "SELECT * FROM categoria" 
            );
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Categoria categ = new Categoria();
                
                categ.setId_categoria(rs.getInt("id_categoria"));
                
                categ.setNome_categoria(rs.getString("nome_categoria"));
                
                Categorias.add( categ );
                
            }
  
            stmt.executeQuery();
            
            return Categorias;
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
}

