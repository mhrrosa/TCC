/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Produto_DAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author deia_
 */
public class Editar_Foto_Produto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
        
       private static final long serialVersionUID = 1L;

	public Editar_Foto_Produto() {
            super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Obtem o caminho relatorio da pasta img*/
		String path = request.getRealPath("img")+ File.separator;
		
                System.out.println("OLA:" + path);
                
		File files = new File(path);
		response.setContentType("image/jpeg");
		
		/*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
		for (String file : files.list()) {
			File f = new File(path + file);
			BufferedImage bi = ImageIO.read(f);
			OutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
                        System.out.println(f);
			out.close();
                        System.out.println(out);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

            
		/*Identifica se o formulario é do tipo multipart/form-data*/
			try {
				
                            /*Faz o parse do request*/
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                                int id = Mostrar_Produto.id_produto;
                               
				/*Escreve a o arquivo na pasta img*/
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
                                            
                                            Produto_DAO dao = new Produto_DAO();
                                            
                                            
                                                
						item.write(new File("C:\\Users\\deia_\\OneDrive\\Documentos\\NetBeansProjects\\Web_DriveSuper\\web\\imagens\\imagens_produtos\\foto_produto_" + id + ".jpg"));
                                                
                                                String foto_1 = String.valueOf(new File("imagens\\imagens_produtos\\foto_produto_" + id + ".jpg"));
                                             
                                                dao.update_fotos(id, foto_1, null, null);
                                                
                                            
                                                
                                                request.getRequestDispatcher("/home_adm.jsp").forward(request, response);
					}
				}

			} catch (Exception ex) {
                            
                            System.out.println("Erro: " + ex);
                            
		request.getRequestDispatcher("/home_adm.jsp").forward(request, response);
			}


	}

}


    