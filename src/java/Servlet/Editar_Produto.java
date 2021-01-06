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
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deia_
 */
public class Editar_Produto extends HttpServlet {

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
        String nome_produto = (String) request.getParameter("nome_produto_cadastro");
        Float preco_preco = Float.valueOf(request.getParameter("preco_produto_cadastro"));
        String categoria_produto = (String) request.getParameter("categoria_produto_cadastro");
        String descricao_produto = (String) request.getParameter("descricao_produto_cadastro");
        
        System.out.println("CCCC: " + categoria_produto);
        
        int id_produto = Mostrar_Produto.id_produto;
        
        int id_categoria = 0;
        
        Produto_DAO dao = new Produto_DAO();
        
        Categoria_DAO dao_categ = new Categoria_DAO();
        
        ObservableList<Categoria> lista_categoria = dao_categ.select_Categoria();
        
        for(Categoria c : lista_categoria){
            if(c.getNome_categoria().equals(categoria_produto)){
                id_categoria = c.getId_categoria();
            }
        }
        
        Produto prod = new Produto();
        
        prod.setNome_produto(nome_produto);
        prod.setPreco_produto(preco_preco);
        prod.setDescricao_produto(descricao_produto);
        prod.setId_categoria(id_categoria);
        prod.setId_produto(id_produto);
        
        dao.update_produto(prod);
        
        request.getRequestDispatcher("/home.jsp").forward(request, response);
        
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
