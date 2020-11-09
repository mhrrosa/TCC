/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Usuario_DAO;
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
public class Mostrar_Editar_Usuario extends HttpServlet {

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
                
                
                request.setAttribute("login_editar", usu.getLogin());
                request.setAttribute("nome_editar", usu.getNome());
                request.setAttribute("email_editar", usu.getEmail());
                request.setAttribute("telefone_editar", usu.getTelefone());
                request.setAttribute("img_editar", usu.getFoto_perfil());
                
                break;
            }
        }    
        
        
        RequestDispatcher rd = request.getRequestDispatcher("editar_usuario.jsp");
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
