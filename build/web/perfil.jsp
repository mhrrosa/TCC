<%-- 
    Document   : perfil
    Created on : 05/11/2020, 16:09:30
    Author     : deia_
--%>


<%@page import="java.net.InetAddress"%>
<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page import="Servlet.Verifica_Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Drive - Super</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="imagens/logo.png">
      
        
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        
        
        
        <%
            
            HttpSession sessao = request.getSession();
            
            Usuario_DAO dao_usuario = new Usuario_DAO();
             
            ObservableList <Usuario> lista_usuarios = dao_usuario.select_Usuario();
            
            int id_usuario = (int) sessao.getAttribute("idUsuarioLogado");
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            
        %>
        
    </head>
    <body>
        
        <div class="${css_class}">${message}</div>
        

        <nav class="navbar navbar-default">
          <div class="collapse navbar-collapse" id="barra_navegacao">
                    <ul class="nav navbar-nav navbar-right">
                        
        
                        <li class="item_menu"><a href="Logout">Logout</a></li>
                        
                    </ul>
        </nav>
        <div class="container" style="background: rgba(255, 255, 255, 0.5); margin-top: 10px; margin-bottom: 10px; padding: 10px; border-radius: 10px;">
              
                <div class="col-md-4"></div>
                    <div class="col-md-8" style="margin: 0px; padding: 0px;">                      
                        <a class="btn btn-danger" href="home_adm.jsp" role="button" style="margin-left:50px;margin-right: 5px">Home</a>
                        <a href="Mostrar_Editar_Usuario" class="btn btn-danger" role="button"style="margin-right: 5px"> Editar Perfil </a>
                        <a href="Mostrar_Usuario" class="btn btn-danger" role="button"> Perfil </a>
                       
                    </div>
                <div class="col-md-3"></div>
                
            </div>
            
            <!-- PERFIL -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px; padding-bottom: 20px;">
                        
                        <div class="page-header">
                            <h1> Perfil </h1>
                        </div>
                        
                        
                        
                       <div class="col-md-3" style="">

                                <img src="http://<%=ip%>:8080/Web_DriveSuper/${img_perfil}" style="width: 200px; height: 200px; border-radius: 50px; margin: 10px;"/>

                               

                            </div>
                         
                        <div class="col-md-9">
                           
                            <p style="margin: 20px 0px;">
                                 <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Login: </span> <span style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px; color:red;">${perfil_login} </span>
                             
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Nome: </span> <span  style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;color:red;">${perfil_nome} </span>
                                
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> E-mail: </span> <span  style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;color:red;">${perfil_email} </span>
                            </p>
                            
                            <p style="margin: 20px 0px;">
            <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Telefone: </span> <span  style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;color:red;">${perfil_telefone} </span>
                               
                            </p>
                            
                            <p style="margin: 20px 0px;">
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Pergunta de Segurança: </span> <span  style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;color:red;">${perfil_pseguranca} </span>
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Estado: </span> <span style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;color:red;">${perfil_estado} </span>
                            </p>
                            
                            <p style="margin: 20px 0px;">
                                <a href="Mostrar_Editar_Usuario" class="btn btn-danger botoes_menu" role="button"> Editar Perfil </a>
                                
                            </p>
                            
                        </div> 
                            
                       
                            
                    </div>    
                </div>        
            </div>
            
            
                  
                </div>

              </div>

            </form>   
                        
        
                        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>  
                        
    
</html>
