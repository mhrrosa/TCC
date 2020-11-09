/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Estado_DAO;
import DAO.Usuario_DAO;
import Model.Estado;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author deia_
 */
public class Mostrar_Usuario extends HttpServlet {

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
        HttpSession sessao = request.getSession();
          
        int id_usuario_logado = (int) sessao.getAttribute("idUsuarioLogado");
        
        
        
        Usuario_DAO dao = new Usuario_DAO();
        
        ObservableList <Usuario> lista_usuario = dao.select_Usuario();
        
        
    
        
               
                
        for(Usuario usu : lista_usuario){
            if(usu.getId_usuario() == id_usuario_logado){
                
                
               
               
                if(usu.getEstado().equals("1")){
                   
                    request.setAttribute("perfil_estado", "Parana" );
                    
                }else if(usu.getEstado().equals("2")){
                    
                    request.setAttribute("perfil_estado", "São Paulo" );
                }else if(usu.getEstado().equals("3")){
                    
                    request.setAttribute("perfil_estado", "Amazonas" );
               }else if(usu.getEstado().equals("4")){
                    
                    request.setAttribute("perfil_estado", "Rio de Janeiro" );
               }else if(usu.getEstado().equals("5")){
                    
                    request.setAttribute("perfil_estado", "Rio Grande do Sul" );
               }
                
               if(usu.getPergunta_seguranca().equals("1")){
                request.setAttribute("perfil_pseguranca", "Qual seu filme preferido?");
               }else if(usu.getPergunta_seguranca().equals("2")){
                   request.setAttribute("perfil_pseguranca", "Qual o Nome do seu cachorro?");
               } else if(usu.getPergunta_seguranca().equals("3")){
                   request.setAttribute("perfil_pseguranca", "Qual rua passou a infancia?");
               }else if(usu.getPergunta_seguranca().equals("4")){
                   request.setAttribute("perfil_pseguranca", "Qual sua serie preferida?");
               }
                
                request.setAttribute("img_perfil", usu.getFoto_perfil());
                request.setAttribute("perfil_login", usu.getLogin());
                request.setAttribute("perfil_nome", usu.getNome());
                request.setAttribute("perfil_email", usu.getEmail());
                request.setAttribute("perfil_telefone", usu.getTelefone());
                
                
                
                
                break;
            }
        }    
        
        
        RequestDispatcher rd = request.getRequestDispatcher("perfil.jsp");
        rd.forward(request, response);
        
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
