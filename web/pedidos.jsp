<%-- 
    Document   : carrinho
    Created on : 09/11/2020, 14:23:22
    Author     : deia_
--%>


<%@page import="DAO.Pedidos_DAO"%>
<%@page import="Model.Pedido"%>
<%@page import="Servlet.Mostrar_Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page import="java.net.InetAddress"%>
<%@page import="DAO.Produto_DAO"%>
<%@page import="Model.Produto"%>
<%@page import="Servlet.Verifica_Login"%>
<%@page import="javafx.collections.ObservableList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="icon" href="imagens/logo.png">

        <%

            HttpSession sessao = request.getSession();

            Usuario_DAO dao_usuario = new Usuario_DAO();

            ObservableList<Usuario> lista_usuarios = dao_usuario.select_Usuario();

            int id_usuario = (int) sessao.getAttribute("idUsuarioLogado");

            String ip = InetAddress.getLocalHost().getHostAddress();

        %>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="collapse navbar-collapse" id="barra_navegacao">
                <ul class="nav navbar-nav navbar-right">
                    <li class="item_menu"><a href="home_adm.jsp">voltar</a></li>

                </ul>
        </nav>
        <div class="container" style="background: rgba(255, 255, 255, 0.5); margin-top: 10px; margin-bottom: 10px; padding: 10px; border-radius: 10px;">


        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-6" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">

                     <div style="margin-left: 45%;">
                            <br><br>
                            <h1>Pendentes</h1>
                            <br><br>
                        </div>
                   <div class="page-header" style="width: 100%; margin-top: 2%;"></div>

                    <%  Pedidos_DAO dao = new Pedidos_DAO();

                        ObservableList<Pedido> ped = dao.select_Pedidos();

                        for (Pedido p : ped) {
                            if (p.getId_usuario() == id_usuario) {

                                Produto_DAO dao_produto = new Produto_DAO();

                                ObservableList<Produto> produto = dao_produto.select_Produto();

                                for (Produto prod : produto) {

                                    if (p.getId_produto() == prod.getId_produto()) {
                                        if (p.getTipo().equals("pendente")) {

                    %>

                    <div class="col-md-6">
                        <div class="thumbnail" style="width: 250px; background: white;border-radius: 5px; margin: 20px 0px; padding: 0px;">
                            <img class="img_produto" style="border-radius: 10px; width: 236px; height: 200px; margin-top: 5px;" src="http://<%=ip + ":8080/Web_DriveSuper/" + prod.getFoto_1()%>" alt="...">
                            <div class="caption">
                                <h3 name="nome_produto"> <%= prod.getNome_produto()%> </h3>
                                <p><span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Preço </span>
                                    <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; color: black; padding: 3px;"> R$ <%= prod.getPreco_produto()%> </span></p>
                                <p><span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Categoria </span>
                                    <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; color: black; padding: 3px;"> <%= prod.getCategoria_produto()%> </span></p>

                                <p><a href="Mostrar_Produto?param=<%= prod.getId_produto()%>" class="btn btn-danger" role="button">Ver Produto</a><br>
                                <p><a href="Deleta_Pedido?param=<%= prod.getId_produto()%>" class="btn btn-danger" role="button""> Cancelar Pedido</a></p>
                                
                            </div>
                        </div>
                    </div>

                    <%

                                        }

                                    }

                                }

                            }

                        }%>
                </div>
                           
                    <div class="col-md-6" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
                          
                         <div style="margin-left: 20%;">
                            <h1>Prontos para Retirar</h1>
                            
                        </div>
                        <div style="margin-left: 35%;"> <h1>na Loja</h1></div>
                        <div class="page-header" style="width: 100%"></div>
                       
                        <%  

                            for (Pedido p : ped) {
                                if (p.getId_usuario() == id_usuario) {

                                    Produto_DAO dao_produto = new Produto_DAO();

                                    ObservableList<Produto> produto = dao_produto.select_Produto();

                                    for (Produto prod : produto) {

                                        if (p.getId_produto() == prod.getId_produto()) {
                                            if (p.getTipo().equals("pronto")) {


                        %>
                         
                        <div class="col-md-6" style="background-color: #ff6565">
                             
                            <div class="thumbnail" style="width: 250px; background: white;border-radius: 5px; margin: 20px 0px; padding: 0px;">
                                <img class="img_produto" style="border-radius: 10px; width: 236px; height: 200px; margin-top: 5px;" src="http://<%=ip + ":8080/Web_DriveSuper/" + prod.getFoto_1()%>" alt="...">
                                <div class="caption">
                                    <h3 name="nome_produto"> <%= prod.getNome_produto()%> </h3>
                                    <p><span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Preço </span>
                                        <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; color: black; padding: 3px;"> R$ <%= prod.getPreco_produto()%> </span></p>
                                    <p><span style="border-bottom-left-radius: 5px; border-top-left-radius: 5px; background: #ff6565; color: white; padding: 3px;">Categoria </span>
                                        <span style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; color: black; padding: 3px;"> <%= prod.getCategoria_produto()%> </span></p>

                                    <p><a href="Mostrar_Produto?param=<%= prod.getId_produto()%>" class="btn btn-danger" role="button">Ver Produto</a><br>
                                   <p><a href="Deleta_Pedido?param=<%= prod.getId_produto() %>" class="btn btn-danger" role="button""> Cancelar Pedido </a></p>
                                   
                                </div>
                            </div>
                        </div>

                        <%

                            } 

                        
                                           }

                                       }

                                   }

                               }%>


                    </div>    
                </div>        
            </div>  
        </div>           
    </section>    
</body>
</html>


