/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Categoria_DAO;
import DAO.Produto_DAO;
import Model.Categoria;
import Model.Produto;
import Model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author deia_
 */
public class Cadastra_Produto extends HttpServlet {

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
        
        String Nome = request.getParameter("nome_produto_cadastro");
        Float Preco = Float.valueOf(request.getParameter("preco_produto_cadastro"));
        String Descricao = request.getParameter("descricao_produto_cadastro");
        String Categoria = request.getParameter("categoria_produto_cadastro");
        
        int id_categoria = 1;
        
        Produto_DAO dao = new Produto_DAO();
        
        Categoria_DAO dao_categ = new Categoria_DAO();
        
        ObservableList<Categoria> lista_categoria = dao_categ.select_Categoria();
        
        for(Categoria c : lista_categoria){
            if(c.getNome_categoria().equals(Categoria)){
                id_categoria = c.getId_categoria();
            }
        }
        
        int id_usuario_logado = (int) sessao.getAttribute("idUsuarioLogado");
       
          
    

    
        
        Produto prod = new Produto();
        
        prod.setNome_produto(Nome);
        prod.setPreco_produto(Preco);
        prod.setDescricao_produto(Descricao);
        prod.setId_categoria(id_categoria);
        prod.setId_vendedor(id_usuario_logado);
        
        dao.insert_Produto(prod);
        
        request.getRequestDispatcher("/home_adm.jsp").forward(request, response);
	  
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
