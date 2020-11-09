<%-- 
    Document   : index
    Created on : 22/10/2020, 17:13:40
    Author     : rosa
--%>
<%@page import="DAO.Produto_DAO"%>
<%@page import="DAO.Usuario_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <head>
        <title>Drive - Super</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/mensagens.css" rel="stylesheet">
        <link rel="icon" href="imagens/logo.png">
        
        
        
    </head>
    
    <body backgound-img="imagens/fundo.jpg">
        
        
        
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
                
                <div class="collapse navbar-collapse " id="barra_navegacao">
                    <ul class="nav navbar-nav navbar-right">
                        
                    </ul>
                </div>
            </div>  
        </nav>
        
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="margin-top: 50px; height: 500px;">
                    
                    <div class="col-md-7" style="height: 100%;">
                    
                        <div class="col-md-12" style="border-radius: 10px; background: white; margin-right: 50px;">
                            
                            <img class="img-responsive" src="imagens/logo.png"/>
                        
                        </div>
                        
                        <div class="col-md-12" style="border-radius: 10px; margin-right: 50px; margin-top: 20px; padding: 5px;">
                            
                            
                            
                        </div>
                        
                        <div class="col-md-12" style="border-radius: 10px; margin-right: 50px; margin-top: 20px; padding: 5px;">
                            
                            
                            
                        </div>
                            
                    </div>
                    
                    <div class="col-md-5" style="height: 100%;">
                    
                        <div class="div_login_cadastro" style="border-radius: 100px; width: 100%; height: 100%; background: white; ">
                            
                            <div>
                                <form action="Verifica_Login" method="POST" style="padding: 30px; padding-top: 10px;">
                                    <h3>Login</h3>

                                    <div class="form-group">
                                      <label for="email">Email ou Login</label>
                                      <input name="email_login" type="text" class="form-control" id="email" placeholder="Digite seu email ou login">
                                    </div>

                                    <div class="form-group">
                                      <label for="senha">Senha</label>
                                      <input name="senha_login" type="password" class="form-control" id="senha" placeholder="Digite sua senha">
                                    </div>
                                    <div class="${css_class}">${message}</div>
                                    <br>
                                    <button type="submit" class="btn btn-danger">Logar</button> 

                                </form>
                            </div>
                            
                            <div style="padding: 30px; padding-top: 0px;">
                                <h3>Cadastre-se aqui!</h3>
                                <p><a class="btn btn-danger" href="cadastro_usuario.jsp" role="button">Cadastre-se</a></p>
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
    </body>
</html>
