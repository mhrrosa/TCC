<%@page import="Model.Pergunta_Seguranca"%>
<%@page import="Model.Estado"%>
<%@page import="DAO.Estado_DAO"%>
<%@page import="javafx.collections.ObservableList"%>
<%@page import="DAO.Pergunta_Seguranca_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


        <link rel="icon" href="imagens/logo.png">
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#barra_navegacao">
                        <span class="sr-only">Alternar Menu</span> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span> 
                    </button>

                      
                </div> 

                <div class="collapse navbar-collapse" id="barra_navegacao">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="item_menu"><a href="index.jsp">Voltar</a></li>
                        
                    </ul>
                    
                </div>
            </div>  
        </nav>
        <a href="index.jsp" class="navbar-brand" ><img id="img_logo_menu" src="imagens/logo.png" /></a>  
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="height: 600px;">

                    <div class="col-md-2" style="height: 100%;"></div>

                    <div class="col-md-9" style="border-radius: 10px; height: 100%; background: white;">

                        <form  action="Cadastrar_Usuario" method="POST">
                            <div class="page-header">
                                <h2> Cadastro </h2>
                            </div>


                            <div class="col-md-6" style="border-right: 1px solid gray; height: 100%; background: white;">


                                <div class="form-group">
                                    <label>Nome</label>
                                    <input name="nome_cadastro" type="text" class="form-control" id="exampleInputEmail1" placeholder="Digite seu nome">
                                </div>

                                <div class="form-group">
                                    <label >Email</label>
                                    <input name="email_cadastro" type="email" class="form-control" id="exampleInputEmail1" placeholder="Digite seu email">
                                </div>

                                <div class="form-group">
                                    <label >Login</label>
                                    <input name="login_cadastro" type="text" class="form-control" id="exampleInputEmail1" placeholder="Digite um login">
                                </div>
                                <div class="form-group">
                                    <label>Telefone</label>
                                    <input name="telefone_cadastro" type="text" class="form-control" id="exampleInputEmail1" placeholder="Digite um telefone">
                                </div>

                                <div class="form-group">
                                    <label >Senha</label>
                                    <input name="senha_cadastro" type="password" class="form-control" id="exampleInputPassword1" placeholder="Digite uma senha">
                                </div>

                                <div class="form-group">
                                    <label>Repita a senha</label>
                                    <input name="r_senha_cadastro" type="password" class="form-control" id="exampleInputPassword1" placeholder="Repita a senha">
                                </div>

                            </div>    

                            <div class="col-md-6" style="height: 100%; background: white;">    


                                <div class="form-group">
                                    <label for="exampleInputPassword1">Pergunta de Segurança</label>
                                    <select name="pergunta_seguranca_cadastro" class="form-control">

                                        <%
                                            Pergunta_Seguranca_DAO DAO_PS = new Pergunta_Seguranca_DAO();

                                            ObservableList<Pergunta_Seguranca> PS_List = DAO_PS.select_Pergunta_Seguranca();

                                            for (Pergunta_Seguranca ps : PS_List) {
                                        %>

                                        <option> <%= ps.getPergunta_seguranca()%> </option>

                                        <%
                                            }
                                        %>

                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Resposta de Segurança</label>
                                    <input name="resposta_seguranca_cadastro" type="text" class="form-control" id="exampleInputPassword1" placeholder="Digite sua resposta de segurança">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Estado</label>
                                    <select name="estado_cadastro" class="form-control">
                                        <%
                                            Estado_DAO dao_pais = new Estado_DAO();

                                            ObservableList<Estado> lista_pais = dao_pais.select_Estado();

                                            for (Estado e : lista_pais) {
                                        %>
                                        <option><%= e.getNome_estado()%></option>
                                        <%
                                            }
                                        %>
                                    </select>

                                </div>
                                <div>
                                    <label class="margin">Classe:</label>
                                    <select class="margin direita" name="classe_cadastro">
                                        <option value="1">Administrador</option>
                                        <option value="2">Não Administrador</option>
                                    </select>
                                </div>

                            </div>    

                            <button type="submit" class="btn btn-danger" style="margin-left: 15px; margin-top: 15px;">Cadastrar</button>
                        </form>

                    </div>

                    <div class="col-md-2" style="height: 100%;"></div>

                </div> 
            </div>  
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>  
    </body>
</html>
