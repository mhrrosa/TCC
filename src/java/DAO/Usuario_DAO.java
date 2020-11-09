/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Jdbc.Connection_Factory;
import Model.Usuario;
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
public class Usuario_DAO {
     public static Connection conexao_BD;
     static Connection c;
    
    public Usuario_DAO()
    {
        Usuario_DAO.conexao_BD = Connection_Factory.getConnection();
    }
        
    public void insert_Usuario(Usuario usuario){
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO usuario(login, senha, nome, email,id_pergunta_seguranca, resposta_seguranca,id_estado,telefone,classe)" + 
                    " VALUES (?, ?, ?, ?, ?, ?, ?,?,?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, usuario.getLogin());
           stat.setString(2, usuario.getSenha());
           stat.setString(3, usuario.getNome());
           stat.setString(4, usuario.getEmail());
           stat.setInt(5, usuario.getId_pergunta_seguranca());
           stat.setString(6, usuario.getResposta_seguranca());
           stat.setInt(7, usuario.getId_estado());
           stat.setString(8, usuario.getTelefone());
           stat.setString(9, usuario.getClasse());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       
    }
    
   public ObservableList<Usuario> select_Usuario()
    {
        try{
            
            ObservableList<Usuario> User = FXCollections.observableArrayList();
        
            PreparedStatement stmt = this.conexao_BD.prepareStatement("SELECT * FROM usuario");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                Usuario usuario = new Usuario();
                
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setClasse(rs.getString("classe"));
                usuario.setEstado(rs.getString("id_estado"));
                usuario.setPergunta_seguranca(rs.getString("id_pergunta_seguranca"));
                
          
                usuario.setFoto_perfil(rs.getString("foto_perfil"));
                   
                User.add(usuario);
            }
            
            stmt.executeQuery();
            
            return User;
     
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
    }
    public Usuario getUsuario(String login, String senha){
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        c = Connection_Factory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,login);
            ppstt.setString(2,senha);
            ResultSet rs = ppstt.executeQuery();
            if(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setClasse(rs.getString("classe"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                
                return usuario;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
   
    public void update_usuario(int id, String login, String nome, String email, String telefone){
        
        Connection c = Connection_Factory.getConnection();
       String sql = "UPDATE usuario SET login = ?, nome = ?, email = ?, telefone = ?" + 
                    " WHERE id_usuario = ?"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, login);
           stat.setString(2, nome);
           stat.setString(3, email);
           stat.setString(4, telefone);
           stat.setInt(5, id);
           
           stat.execute();
           stat.close();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        
    }
    public void update_foto_perfil(int id, String foto){
        
        Connection c = Connection_Factory.getConnection();
       String sql = "UPDATE usuario SET foto_perfil = ?" + 
                    " WHERE id_usuario = ?"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, foto);
           stat.setInt(2, id);
           
           stat.execute();
           stat.close();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        
    }
    
}
