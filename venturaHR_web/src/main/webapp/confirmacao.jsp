<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de usuários</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav class="navbar has-background-info" role="navigation" aria-label="main navigation">
            <div class="navbar-brand has-text-weight-bold">
                <a class="navbar-item" href="/index.jsp">
                    VENTURA HR
                </a>
            </div>
        </nav>
        <%String nome = (String) request.getAttribute("nome");%>


        <div class="columns is-centered">
            <div class="column is-half p-6">
                <div class="notification is-success has-text-centered">
                    <div class="block">
                        <span class="icon is-size-1 is-large"> 
                            <i class="fa fa-check-circle"></i>
                        </span>
                    </div>
                    Usuario: <%=nome%> cadastrado com sucesso!
                    <br>
                    <a href="/venturaHR_web/index.jsp">Retornar à página inicial</a>
                </div>
            </div>
        </div>
                    

    </body>
</html>
