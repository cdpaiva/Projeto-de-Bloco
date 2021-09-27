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
        <script type="text/javascript">document.addEventListener('DOMContentLoaded', () => {
                (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
                    const $notification = $delete.parentNode;

                    $delete.addEventListener('click', () => {
                        $notification.parentNode.removeChild($notification);
                    });
                });
            });
        </script>
    </head>
    
    <body>

        <c:import url="/WEB-INF/jsp/menuSuperior.jsp"/>

        <div class="columns is-centered">
            <div class="column is-three-quarters p-6">
                <div class="has-text-centered">

                    <h2 class="has-text-centered has-text-weight-bold is-size-3">VenturaHR - Empresas</h2>

                    <h2>${exec}</h2>

                    <c:if test="${not empty vagas}">
                        <div class="box">
                            <h2 class="has-text-centered has-text-weight-bold is-size-4">Vagas Publicadas</h2>
                            <hr>
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
                                        <td>
                                            <a href="/usuarios/empresas/excluir/${vaga.id}" class="button is-danger is-outlined is-small">Excluir</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:if>

                    <c:if test="${not empty mensagem}">
                        <div class="notification is-success is-light">
                            <button class="delete"></button>
                            <p>${mensagem}</p>
                        </div>
                    </c:if>

                    <div class="column">
                        <a class="button is-info is-outlined" href="/usuarios/empresas/publicarVaga">Publicar uma nova vaga</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>