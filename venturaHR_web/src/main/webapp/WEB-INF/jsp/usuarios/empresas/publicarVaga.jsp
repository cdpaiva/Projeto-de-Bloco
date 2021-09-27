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

        <div class="container">
            <div class="columns is-centered">
                <div class="column is-three-quarters p-6">
                    <div class="box">

                        <h2 class="has-text-centered has-text-weight-bold is-size-3">Publicar vaga</h2>

                        <form action="/usuarios/empresas/adicionarVaga" method="post">

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
                            <div class="has-text-centered">
                                <input class="button is-info is-outlined" type="submit" value="Próximo">
                            </div>
                        </form>

                        <c:if test="${not empty vaga}">
                            <form action="/usuarios/empresas/adicionarCriterio" method="post">
                                <table class="table is-stripped is-fullwidth">
                                    <tr>
                                        <td>Descrição</td>
                                        <td>Perfil</td>
                                        <td>Peso</td>
                                    </tr>
                                    <tr>
                                        <td><input class="input" type="text" name="descricao"/></td>
                                        <td><input class="input" type="text" name="perfil"/></td>
                                        <td><input class="input" type="text" name="peso"/></td>
                                        <td></td>
                                    </tr>
                                    <c:forEach var="criterio" items="${criterios}">
                                        <tr>
                                            <td>${criterio.descricao}</td>
                                            <td>${criterio.perfil}</td>
                                            <td>${criterio.peso}</td>
                                        </tr>
                                    </c:forEach>
                                </table>

                                <div class="has-text-centered">
                                    <input class="button is-info is-outlined" type="submit" value="Adicionar Critério">
                                </div>
                            </form>

                        </c:if>

                        <c:if test="${not empty criterios}">
                            <div class="has-text-centered box">
                                <form action="/usuarios/empresas/publicarVaga" method="post">
                                    <input class="button is-info" type="submit" value="Publicar Vaga">
                                </form>
                            </div>
                        </c:if>   

                        <c:if test="${not empty msgSucesso}">
                            <div class="notification is-success is-light">
                                <button class="delete"></button>
                                <p>${msgSucesso}</p>
                            </div>
                        </c:if>    


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>