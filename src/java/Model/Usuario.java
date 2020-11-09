/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author deia_
 */
public class Usuario
{
    private int id_usuario;
    
    private String login;
    private String senha;
    
    private String nome;
    private String email;
    private String telefone;
    
    private String classe;
    
    private int id_estado;
    
    private String estado;
    
    private int id_pergunta_seguranca;
    
    private String pergunta_seguranca;
    private String resposta_seguranca;
    
    private String foto_perfil;
    
    public Usuario(){}

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

   

    
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_pergunta_seguranca() {
        return id_pergunta_seguranca;
    }

    public void setId_pergunta_seguranca(int id_pergunta_seguranca) {
        this.id_pergunta_seguranca = id_pergunta_seguranca;
    }
    
    public String getPergunta_seguranca() {
        return pergunta_seguranca;
    }

    public void setPergunta_seguranca(String pergunta_seguranca) {
        this.pergunta_seguranca = pergunta_seguranca;
    }

    public String getResposta_seguranca() {
        return resposta_seguranca;
    }

    public void setResposta_seguranca(String resposta_seguranca) {
        this.resposta_seguranca = resposta_seguranca;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
        
}
