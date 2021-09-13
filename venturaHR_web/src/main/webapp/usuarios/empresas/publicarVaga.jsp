<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Publicação de vagas</title>
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

                    <h2>Publicar vaga</h2>

                    <form action="/venturaHR_web/vagas/publicar" method="post">

                        <div class="columns is-centered">
                            <div class="column is-half">

                                <div class="field">
                                    <label class="label">Cargo</label>
                                    <div class="control">
                                        <input class="input" name="cargo" type="text" 
                                               value="${vaga.cargo}" placeholder="Nome do cargo">
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">Cidade</label>
                                    <div class="control">
                                        <input class="input" name="cidade" type="text" 
                                               value="${vaga.cidade}" placeholder="Cidade">
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">Forma de Contratação</label>
                                    <div class="control">
                                        <input class="input" name="formaContratacao" type="text" 
                                               value="${vaga.formaContratacao}" placeholder="Forma de contratação">
                                    </div>
                                </div>                                    

                            </div>
                        </div>
                        <input class="button" type="submit" value="Próximo">
                    </form>

                    <c:if test="${not empty vaga}">
                        <form action="/venturaHR_web/vagas/publicarCriterio" method="post">
                            <table class="table is-stripped is-fullwidth">
                                <tr>
                                    <td>Descrição</td>
                                    <td>Perfil</td>
                                    <td>Peso</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="descricao"/></td>
                                    <td><input type="text" name="perfil"/></td>
                                    <td><input type="text" name="peso"/></td>
                                </tr>
                                <c:forEach var="criterio" items="${criterios}">
                                    <tr>
                                        <td>${criterio.descricao}</td>
                                        <td>${criterio.perfil}</td>
                                        <td>${criterio.peso}</td>
                                    </tr>
                                </c:forEach>
                            </table>

                            <input class="button" type="submit" value="Adicionar Critério">
                        </form>

                    </c:if>

                    <c:if test="${not empty criterios}">
                        <form action="/venturaHR_web/vagas/publicar" method="get">
                            <input class="button" type="submit" value="Publicar">
                        </form>
                    </c:if>   

                    <c:if test="${not empty msgSucesso}">
                        <p class="notification is-success">${msgSucesso}</p>
                    </c:if>                

                    <div class="column">
                        <a href="/venturaHR_web/index.jsp">Sair do sistema</a>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>