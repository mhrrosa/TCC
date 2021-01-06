/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Usuario_DAO;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author deia_
 */
public class Editar_Foto_Usuarios extends HttpServlet {

    private static final long serialVersionUID = 1L;

	public Editar_Foto_Usuarios() {
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
		HttpSession sessao = request.getSession();
		/*Identifica se o formulario é do tipo multipart/form-data*/
			try {
				
                            /*Faz o parse do request*/
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                                
                                int Login = 0;
                                Login = (int) sessao.getAttribute("idUsuarioLogado");
                                
				/*Escreve a o arquivo na pasta img*/
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						item.write(new File("C:\\Users\\deia_\\OneDrive\\Documentos\\NetBeansProjects\\Web_DriveSuper\\web\\imagens\\imagens_usuario\\foto_perfil_" + Login + ".jpg"));
                                                
                                                String foto_perfil = String.valueOf(new File("imagens\\imagens_usuario\\foto_perfil_" + Login + ".jpg"));
                                                
                                                Usuario_DAO dao = new Usuario_DAO();
                                                
                                                dao.update_foto_perfil(Login, foto_perfil);
                                                
                                                request.getRequestDispatcher("/home_adm.jsp").forward(request, response);
					}
				}

			} catch (Exception ex) {
                            
                            System.out.println("Erro: " + ex);
                            
		request.getRequestDispatcher("/home_adm.jsp").forward(request, response);
			}


	}

}
