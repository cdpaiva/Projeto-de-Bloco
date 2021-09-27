<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ventura HR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <c:import url="/WEB-INF/jsp/menuSuperior.jsp"/>
        <div class="section">
            <h2 class="has-text-centered has-text-weight-bold is-size-3">VenturaHR - Candidatos</h2>
            <div class="columns is-centered">

                <div class="column is-half has-text-centered p-6 box">
                    <div class="box">
                        <a href="/usuarios/candidatos/listaRespostas">Veja as vagas que você se candidatou</a>
                    </div>         
                    <label class="label">Buscar Vaga</label>
                    <div class="columns">
                        <div class="column">
                            <form action="/usuarios/candidatos/pesquisarCargo" method="get">
                                <div class="field">
                                    <div class="control">
                                        <input class="input" name="pesquisa" type="text" 
                                               placeholder="Nome do cargo desejado">
                                    </div>
                                </div>
                                <input class="button is-info is-outlined" type="submit" value="Busca por Cargo">
                            </form>
                        </div>

                        <div class="column">
                            <form action="/usuarios/candidatos/pesquisarCidade" method="get">
                                <div class="field">
                                    <div class="control">
                                        <input class="input" name="pesquisa" type="text" 
                                               placeholder="Nome da cidade desejada">
                                    </div>
                                </div>
                                <input class="button is-info is-outlined" type="submit" value="Busca por Cidade">
                            </form>
                        </div>
                    </div>

                    <div>
                        <c:if test="${not empty msgPesquisa}">
                            <h3>${msgPesquisa}</h3>
                        </c:if>
                    </div>

                    <c:if test="${not empty vagas}">
                        <table class="table is-stripped is-fullwidth">
                            <tr>
                                <th>Cargo</th>
                                <th>Cidade</th>
                                <th>Critérios</th>
                                <th></th>
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
                                    <td><a href="/usuarios/candidatos/vaga/${vaga.id}">Mais Informações</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

    </body>
</html>