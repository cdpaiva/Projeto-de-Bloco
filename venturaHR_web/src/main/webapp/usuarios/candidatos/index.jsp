<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <div class="column is-half p-6 has-text-centered">
                <h3>Página inicial de candidatos</h3>
                <form action="/venturaHR_web/vagas/pesquisar" method="post">
                    <div class="field">
                        <label class="label">Buscar Vaga</label>
                        <div class="control">
                            <input class="input" name="pesquisa" type="text" 
                                   placeholder="Nome do cargo desejado">
                        </div>
                    </div>
                    <input class="button" type="submit" value="Buscar">
                </form>

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

                <a href="/venturaHR_web/index.jsp">Retornar à página de login</a>
            </div>
        </div>

    </body>
</html>