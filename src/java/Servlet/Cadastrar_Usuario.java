/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;



import DAO.Estado_DAO;
import DAO.Pergunta_Seguranca_DAO;
import DAO.Usuario_DAO;
import Model.Estado;
import Model.Pergunta_Seguranca;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deia_
 */
public class Cadastrar_Usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            String login = (String) request.getParameter("login_cadastro");           
            String senha = (String) request.getParameter("senha_cadastro"); 
            String r_senha = (String) request.getParameter("r_senha_cadastro");
            String nome = (String) request.getParameter("nome_cadastro");
            String email = (String) request.getParameter("email_cadastro");
            String pergunta_seguranca = (String) request.getParameter("pergunta_seguranca_cadastro");
            String ps_2;
            String resposta_seguranca = (String) request.getParameter("resposta_seguranca_cadastro");
            String estado = (String) request.getParameter("estado_cadastro");
            String telefone = (String) request.getParameter("telefone_cadastro");
            String classe = (String) request.getParameter("classe_cadastro");
        
            int id_ps = 0;
            int id_estado = 0;
            
            
            if(senha.equals(r_senha)){
            
                Pergunta_Seguranca_DAO dao_ps = new Pergunta_Seguranca_DAO();
                
                ObservableList <Pergunta_Seguranca> lista_ps = dao_ps.select_Pergunta_Seguranca();
                
                for(Pergunta_Seguranca ps : lista_ps){
                    ps_2 = ps.getPergunta_seguranca();
                    if(ps_2.equals(pergunta_seguranca)){
                        id_ps = ps.getId_pergunta_seguranca();
                        
                        break;
                    }
                }
                Estado_DAO dao_estado = new Estado_DAO();
                
                ObservableList <Estado> lista_estados = dao_estado.select_Estado();
                
                for(Estado estados : lista_estados){
                    if(estados.getNome_estado().equals(estado)){
                        id_estado = estados.getId_estado();
                        
                        break;
                    }
                }
                Usuario usuario = new Usuario();
                
                if(classe.equals("1")){
                    
                    usuario.setClasse("Administrador");
                   
                }else if(classe.equals("2")){
                    usuario.setClasse("Não Administrador");
                    
                }
                
            
            
        
    
             
                
                

                usuario.setLogin(login);
                usuario.setEmail(email);
                usuario.setNome(nome);
                usuario.setSenha(senha);
                usuario.setId_estado(id_estado);
                usuario.setId_pergunta_seguranca(id_ps);
                usuario.setResposta_seguranca(resposta_seguranca);
                usuario.setTelefone(telefone);
                usuario.setClasse(classe);

                Usuario_DAO DAO = new Usuario_DAO();
                
                try{
                DAO.insert_Usuario(usuario);
                }catch(Exception ex){
                    System.out.println("Erro11: " + ex);
                }

                request.setAttribute("message", "Usuário cadastrado com sucesso!");
               
                
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            
            }else{
                
                request.setAttribute("message", "Erro ao cadastrar usuário!");
                
                
                RequestDispatcher rd = request.getRequestDispatcher("cadastro_usuario.jsp");
                rd.forward(request, response);
                
            }
            
        }catch(Exception ex){
            System.out.println("Erro:" + ex);
        }    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
