<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="navbar-item" href="index.jsp">
                    VENTURA HR
                </a>
            </div>
        </nav>

        <div class="columns is-centered">
            <div class="column is-three-quarters p-6">
                <div class="has-text-centered">

                    Página inicial de empresas

                    <h2>Bem vindo ${usuario.nome}</h2>

                    <c:if test="${not empty vagas}">
                        <table class="table is-stripped is-fullwidth">
                            <tr>
                                <th>Cargo</th><th>Cidade</th><th>Critérios</th>
                            </tr>

                            <c:forEach var="vaga" items="${vagas}">
                                <tr>
                                    <td>${vaga.cargo}</td>
                                    <td>${vaga.cidade}</td>
                                    <td>
                                        <c:forEach var="criterio" items="${vaga.criterios}">
                                            ${criterio.descricao}<br/>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>

                    <div class="column">
                        <a href="/venturaHR_web/usuarios/empresas/publicarVaga.jsp">Publicar uma nova vaga</a>
                    </div>

                    <div class="column">
                        <a href="/venturaHR_web/index.jsp">Sair do sistema</a>
                    </div>


                </div>
            </div>
        </div>

    </body>
</html>