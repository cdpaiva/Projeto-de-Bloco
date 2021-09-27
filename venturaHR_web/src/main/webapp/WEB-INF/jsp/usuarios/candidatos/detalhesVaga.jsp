<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <script type="text/javascript">document.addEventListener('DOMContentLoaded', () => {
            (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
                const $notification = $delete.parentNode;

                $delete.addEventListener('click', () => {
                    $notification.parentNode.removeChild($notification);
                });
            });
        });
    </script>
    <body>

        <c:import url="/WEB-INF/jsp/menuSuperior.jsp"/>

        <div class="columns is-centered">
            <div class="box">
                <div class="column p-6 has-text-centered">

                    <h3>Veja os detalhes da vaga escolhida:</h3>

                    <!-- Apresentação da vaga ao candidato -->
                    <c:if test="${not empty vaga}">
                        <table class="table is-stripped is-fullwidth">
                            <tr>
                                <th>Cargo</th>
                                <th>Cidade</th>
                                <th>Forma de Contratação</th>
                            </tr>

                            <tr>
                                <td>${vaga.cargo}</td>
                                <td>${vaga.cidade}</td>
                                <td>${vaga.formaContratacao}</td>
                            </tr>
                        </table>

                        <table class="table is-fullwidth">
                            <tr>
                                <th>Criterio</th>
                                <th>Avaliação</th>
                                <th></th>
                            </tr>
                            <c:forEach var="criterio" items="${vaga.criterios}">
                                <tr>
                                    <td>
                                        ${criterio.descricao}
                                    </td>
                                <form action="/usuarios/resposta/adicionarRespostaCriterio" method="post">
                                    <input class="input" type="hidden" name= "idCriterio" value="${criterio.id}"/>
                                    <td>
                                        <select name="respostaCriterio">
                                            <option value="1">Insuficiente</option>
                                            <option value="2">Regular</option>
                                            <option value="3">Bom</option>
                                            <option value="4">Muito Bom</option>
                                            <option value="5">Excelente</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input class="button is-info is-outlined is-small" type="submit" value="Responder Critério">
                                    </td>
                                </form>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>

                    <c:if test="${not empty respostasCriterios}">
                        <div class="column is-narrow">
                            <p>Suas respostas até o momento</p>
                            <table class="table is-fullwidth">
                                <tr>
                                    <th>Descrição</th>
                                    <th>Resposta</th>
                                </tr>
                                <c:forEach var="rc" items="${respostasCriterios}">
                                    <tr>
                                        <td>${rc.criterio.descricao}</td> 
                                        <td>${rc.respostaCriterio}</td>
                                    </tr>
                                </c:forEach>
                            </table>

                            <form action="/usuarios/candidatos/responderVaga" method="post">
                                <input class="button is-info is-outlined" type="submit" value="Submeter">
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${not empty msg}">
                        <div class="notification is-info is-light">
                            <button class="delete"></button>
                            <p>${msg}</p>
                        </div>
                    </c:if>    
                </div>
            </div>
        </div>

    </body>
</html>