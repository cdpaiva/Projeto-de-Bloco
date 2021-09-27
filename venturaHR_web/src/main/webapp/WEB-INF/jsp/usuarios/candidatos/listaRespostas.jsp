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

                <div class="column has-text-centered">  
                    <h3>Acompanhe as vagas candidatadas</h3>
                    <!-- Apresentação da vaga ao candidato -->
                    <c:if test="${not empty respostas}">
                        <table class="table is-stripped is-fullwidth">
                            <tr>
                                <th>Vaga</th>
                                <th>Data</th>
                                <th></th>
                            </tr>
                            <c:forEach var="resposta" items="${respostas}">
                                <tr>
                                    <td>${resposta.vaga.cargo}</td>
                                    <td>${resposta.data}</td>
                                </tr>
                            </c:forEach>
                        </table>    
                    </c:if>

                    <c:if test="${empty respostas}">
                        <div class="notification is-danger is-light">
                            <p>Não foram encontradas vagas respondidas</p>
                        </div>
                    </c:if>
                    
                    <c:if test="${not empty msg}">
                        <div class="notification is-danger is-light">
                            <p>${msg}</p>
                        </div>
                    </c:if>

                </div>
            </div>
        </div>

    </body>
</html>