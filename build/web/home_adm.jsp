<%-- 
    Document   : adm
    Created on : 30/10/2020, 11:57:44
    Author     : deia_
--%>

<%@page import="java.net.InetAddress"%>
<%@page import="Servlet.Verifica_Login"%>
<%@page import="Model.Produto"%>
<%@page import="DAO.Produto_DAO"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home ADM</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <link rel="icon" href="imagens/logo.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            HttpSession sessao = request.getSession();
            try {
                if (sessao.getAttribute("idUsuarioLogado") == null) {%>
        <jsp:forward page="index.jsp" />
        <%
        } else if (sessao.getAttribute("classeUsuarioLogado").equals("2")) {%>
        <jsp:forward page="home_usuario.jsp" />
        <%
                }
            } catch (Exception e) {

            }
        %>
        <%
            int pagina_produto = 1;
            
           Produto_DAO dao_produto = new Produto_DAO();
            
            ObservableList <Produto> lista_produtos = dao_produto.select_Produto();

            
        %>
        <div class="${css_class}">${message}</div>
        <nav class="navbar navbar-default">
            <div class="collapse navbar-collapse" id="barra_navegacao">
                <ul class="nav navbar-nav navbar-right">
                    <li class="item_menu"><a href="Logout">Logout</a></li>

                </ul>
        </nav>
        <div class="container" style="background: rgba(255, 255, 255, 0.5); margin-top: 10px; margin-bottom: 10px; padding: 10px; border-radius: 10px;">

            <div class="col-md-4"></div>
            <div class="col-md-5" style="margin: 0px; padding: 0px;">                      
                <a class="btn btn-danger" href="cadastro_produto.jsp" role="button" style="margin-right: 5px">Cadastrar produto</a>
                 <a href="carrinho.jsp" class="btn btn-danger" role="button"> Carrinho </a> |
                <a href="Mostrar_Editar_Usuario" class="btn btn-danger" role="button"style="margin-right: 5px"> Editar Perfil </a>
                <a href="Mostrar_Usuario" class="btn btn-danger" role="button"> Perfil </a>
            </div>
            <div class="col-md-3"></div>

        </div>
        <!-- Carousel -->

        <!-- Carrosel -->
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="border-radius: 10px; margin-bottom: 50px;">
                    <div style="width: 100%; height: 200px; margin: 0px; position: relative;">
                        <div class="col-md-12" style="width: 100%; height: 100%; margin: 0px 0px;">

                            <div id="myCarousel" class="carousel slide" data-ride="carousel" style=" width: 100%; height: 100%; border-radius: 10px;">
                                <!-- Carousel indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li>
                                </ol>   
                                <!-- Wrapper for carousel items -->
                                <div class="carousel-inner">
                                    <div class="item active"style="height: 200px;">

                                        <img  src="imagens/banner-eletrodomesticos.jpg" alt="First Slide">

                                    </div>
                                    <div class="item" style="height:200px;" >
                                        <img src="imagens/banner-eletronicos.png" alt="Second Slide">


                                    </div>
                                    <div class="item"style="height:200px;">
                                        <img src="imagens/banner-roupa.jpg" alt="Third Slide">

                                    </div>
                                    <div class="item" style="height: 200px;">
                                        <img src="imagens/banner_alimentos.jpg"alt="Third Slide">

                                    </div>
                                </div>
                                <!-- Carousel controls -->
                                <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="carousel-control right" href="#myCarousel" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>  

                        </div>
                    </div> 
                </div>    
            </div>        
        </div>
        
        <div class="page-header" style="margin-left: 25px;">
                <h1> Produtos </h1>
            </div>
        
        <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        
                        <div class="row" style="margin: 0px; padding: 0px;">
                            
                            <%
                                String ip = InetAddress.getLocalHost().getHostAddress();
                                
                                ObservableList <Produto> list;
                                
                               
                                    
                                    list = lista_produtos;
                                    
                               
                                
                                for(Produto prod : list){                            
                            %>
                            
                            <div class="col-sm-6 col-md-3">
                                <div class="thumbnail" style="width: 250px; background: white;border-radius: 5px; margin: 20px 0px; padding: 0px;">
                                    <img class="img_produto" style="border-radius: 10px; width: 236px; height: 200px; margin-top: 5px;" src="http://<%=ip + ":8080/Web_DriveSuper/" + prod.getFoto_1() %>" alt="...">
                                    <div class="caption">
                                        <h3 name="nome_produto" style=""> <%= prod.getNome_produto() %> </h3>
                                        <p> <span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Preço </span>
                                            <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; color: black; padding: 3px;"> R$ <%= prod.getPreco_produto() %> </span> </p>
                                        <p> <span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Categoria </span>
                                            <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px;color: black; padding: 3px;"> <%= prod.getCategoria_produto() %> </span> </p>
                                        
                                        <p><a href="Mostrar_Produto?param=<%= prod.getId_produto() %>" class="btn btn-danger" role="button">Ver Produto</a>
                                      
                                        <p><a href="Carrinho_Add?param=<%= prod.getId_produto() %>" class="btn btn-danger">Adicionar ao Carrinho</a></p>
                                        
                                        
                                                                                                                                                          
                                    </div>
                                </div>
                            </div>
                            
                           
                            <%
                                }
                            %>
          
                    </div> 

        
    </body>
</html>
