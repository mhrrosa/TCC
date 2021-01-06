/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author deia_
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    
    
    @Test
    public void TestarSenha(){
        //cenario
        Usuario usuario = new Usuario();
        String senhateste = "12345";
        
        //ação
        usuario.setSenha(senhateste);
        
        String testar = usuario.getSenha();
        //validção
        assertEquals(testar,senhateste);
        
        
    }
    @Test
    public void testaNome(){
        String nome = "Matheus";
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        
        String testa = usuario.getNome();
        assertEquals(testa,nome);
    }
    @Test
    public void testaLogin(){
        String login = "adm_mat";
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        
        String testa = usuario.getLogin();
        assertEquals(testa,login);
    }
    
}
