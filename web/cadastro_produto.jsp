<%@page import="Servlet.Mostrar_Produto"%>
<%@page import="java.net.InetAddress"%>
<%@page import="Model.Usuario"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page import="DAO.Categoria_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Drive - Super</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

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

        <!-- MENU 1 - PRINCIPAL -->
        <nav class="navbar navbar-default" style="margin-bottom: 0px; border-radius: 0px;">
            <div class="container">

                <div class="collapse navbar-collapse" id="barra_navegacao">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="item_menu"><a href="home_adm.jsp">Voltar</a></li>

                    </ul>


                </div>


            </div>
        </nav>

        <section>

            <!-- MENU VOLTAR - CADASTRO PRODUTO -->

            <p></p>
            
                            
                          
                        
          
            
            <div class="col-md-10"></div>

            

            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="background: rgba(255, 255, 255, 0.5); border-radius: 10px;">
                        
                        <div class="page-header">
                            <h1>Produto</h1>
                        </div>
                        
                        <div>
                            
                            <form action="Cadastra_Produto" method="POST">
                                <div class="col-md-4">
                                 <img class="img-responsive" src="imagens/logo.png"/>
                                </div>
                                <div class="col-md-3" style="">
                                    
                                    <div class="form-group">
                                        <label for="nome_produto">Nome do Produto</label>
                                        <input name="nome_produto_cadastro" type="text" class="form-control" id="nome_produto" placeholder="Digite nome produto">
                                    </div>

                                    <div class="form-group">
                                        <label for="preco_produto">Preço</label>
                                        <input name="preco_produto_cadastro" type="text" class="form-control" id="preco_produto" placeholder="Digite seu nome">
                                    </div>

                                    <div class="form-group">
                                        <label>Categoria</label>
                                        <select name="categoria_produto_cadastro" class="form-control">
                                            <option>Eletrodomestico</option>
                                            <option>Alimentos</option>
                                            <option>Eletronicos</option>
                                            <option>Roupas</option>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-danger" style="margin-top: 15px;">Cadastrar Produto</button>

                                    <a href="home_adm.jsp" class="botoes_menu btn btn-danger"style="margin-top: 15px;" role="button">Voltar</a>

                                </div>
                              

                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label>Descrição</label>
                                        <textarea name="descricao_produto_cadastro" class="form-control"></textarea>
                                        
                                    </div>

                                </div>

                            </form>

                        </div>

                    </div>
                </div>
            </div>

        </section>

    </body>
</html>

