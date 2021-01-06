<%-- 
    Document   : editar_usuario
    Created on : 04/11/2020, 14:23:24
    Author     : deia_
--%>


<%@page import="java.net.InetAddress"%>
<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page import="javafx.collections.ObservableList"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Drive - Super</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="imagens/logo.png">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/newcss.css">
        <%
            
            HttpSession sessao = request.getSession();
            
            Usuario_DAO dao_usuario = new Usuario_DAO();
             
            ObservableList <Usuario> lista_usuarios = dao_usuario.select_Usuario();
            
            int id_usuario = (int) sessao.getAttribute("idUsuarioLogado");
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            
        %>
        
    </head>
    <body>
        

        
        
        <section>
            
            
            <div class="container banner_principal_1"style="padding: 10px;width: 100%;">
              
                <div class="col-md-5"></div>
                    <div class="col-md-6" style="margin: 0px; padding: 0px;">      
                        
                        <a href="home_adm.jsp"  class="btn btn-danger" type="button">Home</a>
                        <a href="carrinho.jsp" class="botoes_menu btn btn-danger" role="button">Carrinho</a>
                        <a href="Mostrar_Usuario" class="botoes_menu btn btn-danger" role="button">Perfil</a>
                    </div>
                <div class="col-md-3"></div>
                
            </div>
            
            <!-- MENSAGENS -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="background: rgba(255, 255, 255, 0.5); border-radius: 100px; padding-bottom: 20px;">
                        
                        <div class="page-header">
                            <h1> Perfil </h1>
                        </div>
                        
                        
                        
                        <form action="Editar_Foto_Usuarios" method="POST" enctype="multipart/form-data">
                         
                            <div class="col-md-3" style="">

                                <img src="http://<%=ip%>:8080/Web_DriveSuper/${img_editar}" style="width: 200px; height: 200px; border-radius: 50px; margin: 10px;"/>

                                <input type="file" name="file" id="file" class="btn btn-danger">
                                
                                <p style="margin: 20px 0px;">
                                    <input type="submit" value="Editar Foto de Perfil" class="btn btn-danger">
                                </p>

                            </div>

                        </form>
                                
                        <form action="Editar_Usuario" method="POST">       
                                
                            <div class="col-md-9" style="">

                                <p style="margin: 10px 0px;">
                                    <span  style="font-size: 18px;"> Login </span> <input name="login" value="${login_editar}" style="font-size: 14px; border-bottom-right-radius: 1px; border-top-right-radius: 1000px; margin-right: 20px;">
                                    <span style="font-size: 18px; "> Nome </span> <input value="${nome_editar}" name="nome" style="font-size: 14px; border-bottom-right-radius: 1px; border-top-right-radius: 1000px; margin-right: 20px;">
                                    <span  style="font-size: 18px; "> E-mail </span> <input value="${email_editar}" name="email"  style="font-size: 14px; border-bottom-right-radius: 1px; border-top-right-radius: 1000px;">
                                </p>

                                <p style="margin: 20px 0px;">
                                    <span  style="font-size: 18px; "> Telefone </span> <input value="${telefone_editar}" name="telefone" class="valores_produto" style="font-size: 14px; border-bottom-right-radius: 1px; border-top-right-radius: 1000px; margin-right: 20px;">
                                </p>

                                <p style="margin: 20px 0px;margin-left: 80%">
                                    <input type="submit" value="Editar Perfil" class="btn btn-danger">
                                    <br>
                                    <br>
                                    <a href="Deleta_Usuario?param=<%= id_usuario %>" class="btn btn-danger" role="button" onclick="aa"> Deletar Conta </a>
                                    
                                </p>
                               

                            </div>
                            
                        </form>    
                            
                    </div>    
                </div>        
            </div>
                                    
        </section>    
    </body>
</html>
