<%-- 
    Document   : editar_produto
    Created on : 06/11/2020, 16:53:06
    Author     : deia_
--%>

<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="Model.Categoria"%>
<%@page import="DAO.Categoria_DAO"%>

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

        <link rel="icon" href="imagens/logo.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <%

            HttpSession sessao = request.getSession();

            Usuario_DAO dao_usuario = new Usuario_DAO();

            ObservableList<Usuario> lista_usuarios = dao_usuario.select_Usuario();

            int id_usuario = (int) sessao.getAttribute("idUsuarioLogado");

            String ip = InetAddress.getLocalHost().getHostAddress();

        %>
    </head>
    <nav class="navbar navbar-default">
        <div class="collapse navbar-collapse" id="barra_navegacao">
            <ul class="nav navbar-nav navbar-right">
                <li class="item_menu"><a href="produto.jsp">Voltar</a></li>

            </ul>
    </nav>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px; height: auto;">

                    <div class="page-header">
                        <h1> Editar Produto </h1>
                    </div>
                    
                    <div class="col-md-6" style="margin-bottom: 30px;">
                        <div style="padding: 10px 20px;">        

                            <form action="Editar_Foto_Produto" method="POST" enctype="multipart/form-data">   
                                <img src="http://<%=ip + ":8080/Web_DriveSuper/" + Mostrar_Produto.foto_1%>" style="border-radius: 10px; width: 300px; height: 300px;">
                                <br>
                                <br><br>
                                <input type="file" name="file" id="file" class="btn btn-danger " value="Editar Foto - 1" style="margin-bottom: 10px;">
                                <input href="" type="submit" class="btn btn-danger " role="button" value="Editar Foto">
                            </form> 



                        </div>

                    </div>

                    <div class="col-md-6" style="padding: 10px; margin-bottom: 30px;">

                        <form action="Editar_Produto" method="POST">    

                            <p style="margin: 20px 0px;">
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Nome do Produto </span> <input name="nome_produto_cadastro" value="<%= Mostrar_Produto.nome_produto%>" class="valores_produto" style="font-size: 14px; border-bottom-right-radius: 7px; border-top-right-radius: 7px;"> 
                            </p>

                            <p style="margin: 20px 0px;">
                                <span class="atributos_produto" style="font-size: 20px; border-bottom-left-radius: 7px; border-top-left-radius: 7px;"> Preço </span> <input name="preco_produto_cadastro" value="<%= Mostrar_Produto.preco_produto%>" class="valores_produto" style="font-size: 14px; border-bottom-right-radius: 7px; border-top-right-radius: 7px;">
                            </p>

                            <div class="form-group">
                                <label>Categoria</label>
                                <select name="categoria_produto_cadastro" class="form-control">
                                    <%
                                        Categoria_DAO dao_categ = new Categoria_DAO();

                                        ObservableList<Categoria> lista_categorias = dao_categ.select_Categoria();

                                        for (Categoria c : lista_categorias) {
                                    %>        
                                    <option><%= c.getNome_categoria()%></option>
                                    <%
                                        }
                                    %>    
                                </select>
                            </div>
                                <div class="col-md-1">    
                            <p style=" border-radius: 7px; margin: 20px 0px;">
                                <span  style="font-size: 20px; border-bottom-left-radius: 0px; border-top-left-radius: 7px;"> Descrição: </span> 
                           
                                </div>
                                
                                <textarea name="descricao_produto_cadastro" class="valores_produto" style="font-size: 20px;  height: 100px;margin-left: 100px;background: none;"><%= Mostrar_Produto.descricao_produto%></textarea>
                                
                                </p>
                                 <p>
                                <input href="" type="submit" class="btn btn-danger " role="button" value="Editar produto"> 
                                <a href="Deleta_Produto?param=<%= Mostrar_Produto.id_produto %>" class="btn btn-danger" role="button" onclick="deleta_produto();"> Deletar Produto </a>
                            </p>

                        </form>    

                    </div>

                </div>    
            </div>        
        </div>

    </section>    
</body>
</html>

</body>
</html>
