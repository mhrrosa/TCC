/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Produto_DAO;
import DAO.Usuario_DAO;
import Model.Produto;
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
public class Mostrar_Produto extends HttpServlet {
    public static int id_produto;
    
    public static int id_vendedor;
    public static String nome_produto;
    public static String vendedor_produto;
    public static Float preco_produto;
    public static String categoria_produto;
   
    public static String descricao_produto;
        
    public static String foto_1;
   
    
    public static String telefone;
    public static String email;
    public static String estado;
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
       
        
        int id_prod = Integer.parseInt(request.getParameter("param"));
        
        Produto_DAO dao_produto = new Produto_DAO();
        
        ObservableList <Produto> lista_produto = dao_produto.select_Produto();
        
        Usuario_DAO dao_usuario = new Usuario_DAO();
        
        ObservableList <Usuario> lista_usuarios = dao_usuario.select_Usuario();
        
        for(Produto prod : lista_produto){
            
            if(prod.getId_produto() == id_prod){
                
                id_produto = prod.getId_produto();
                
                nome_produto = prod.getNome_produto();
                vendedor_produto = prod.getVendedor_produto();
                preco_produto = prod.getPreco_produto();
                
                categoria_produto = prod.getCategoria_produto();
                
                descricao_produto = prod.getDescricao_produto();

                foto_1 = prod.getFoto_1();
               
                
                id_vendedor = prod.getId_vendedor();
                
                for(Usuario usu : lista_usuarios){
                  
                    if(usu.getId_usuario() == id_vendedor){
                      
                        telefone = usu.getTelefone();
                        email = usu.getEmail();
                        estado = usu.getEstado();
                        
                    }
                    
                }
                
                
                    RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
                    rd.forward(request, response);
              
                break;
            }
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
