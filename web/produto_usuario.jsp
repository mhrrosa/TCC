<%-- 
    Document   : produto_usuario
    Created on : 06/11/2020, 17:33:44
    Author     : deia_
--%>

<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<%@page import="Servlet.Mostrar_Produto"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page import="Servlet.Verifica_Login"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Drive - Super</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <link rel="icon" href="imagens/logo.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         <%
            
            HttpSession sessao = request.getSession();
            
            Usuario_DAO dao_usuario = new Usuario_DAO();
             
            ObservableList <Usuario> lista_usuarios = dao_usuario.select_Usuario();
            
            int id_usuario = (int) sessao.getAttribute("idUsuarioLogado");
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            
        %>
    </head>
     <nav class="navbar navbar-default">
            <div class="collapse navbar-collapse" id="barra_navegacao">
                <ul class="nav navbar-nav navbar-right">
                    <li class="item_menu"><a href="home_adm.jsp">Voltar</a></li>

                </ul>
        </nav>
    <body>
         <div class="container">
                <div class="row">
                    <div class="col-md-12" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px; height: auto;">
                        
                        <div class="page-header">
                            <h1> <%= Mostrar_Produto.nome_produto %> </h1>
                        </div>
                        
                        <div class="col-md-6" style="margin-bottom: 30px;">
                            
                           
                         
                            <div class="col-md-3" style="">

                                <img src="http://<%=ip + ":8080/Web_DriveSuper/" + Mostrar_Produto.foto_1 %>" alt="First Slide" style="border-radius: 10px; width: 500px; height: 292px;">

                               

                            </div>

                       
                        </div>
                     
                        <div class="col-md-6" style="padding: 10px; margin-bottom: 30px;">
                                
                            <p style="margin: 20px 0px;">

                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Preço </span> <span class="valores_produto" style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;"> <%= Mostrar_Produto.preco_produto %> </span>
             
                            </p>
                            
                            <p style="margin: 20px 0px;">
                            </p>
                            
                            <p style="margin: 20px 0px;">

                              
                            </p>
                            
                            <p style="margin: 20px 0px;">
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Categoria </span> <span class="valores_produto" style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px;"> <%= Mostrar_Produto.categoria_produto %> </span>
                            </p>
                            
                            <p style="background: #ff6565; margin: 20px 0px;">
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 0px; border-top-left-radius: 7px;"> Descrição </span> <span class="valores_produto" style="font-size: 20px; border-bottom-right-radius: 7px; border-top-right-radius: 7px; margin-right: 20px; background: none;"> <%= Mostrar_Produto.descricao_produto %> </span>
                            </p>
                               
                            
                            
                        </div>
                        
                    </div>    
                </div>        
            </div>
             
    </body>
</html>

