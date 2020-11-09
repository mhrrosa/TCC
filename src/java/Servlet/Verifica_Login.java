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
import java.io.Serializable;
import javafx.collections.FXCollections;
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
public class Verifica_Login extends HttpServlet implements Serializable {

    ;
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
        HttpSession sessao = request.getSession();

        Usuario usuario = null;
        String login_form = request.getParameter("email_login");
        String senha_form = request.getParameter("senha_login");
        Usuario_DAO dao = new Usuario_DAO();

        try {

            usuario = dao.getUsuario(login_form, senha_form);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (usuario == null) {
            sessao.invalidate();
            request.setAttribute("message", "Erro ao realizar o login!");
            request.setAttribute("css_class", "erro");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {

            int idUsuario = usuario.getId_usuario();
            String classeUsuario = usuario.getClasse();
            String nomeUsuario = usuario.getNome();
            sessao.setAttribute("idUsuarioLogado", idUsuario);
            sessao.setAttribute("classeUsuarioLogado", classeUsuario);
            sessao.setAttribute("nomeUsuarioLogado", nomeUsuario);
            request.setAttribute("message", "Login realizado com sucesso!");
            request.setAttribute("css_class", "sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("home_adm.jsp");
            rd.forward(request, response);
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
