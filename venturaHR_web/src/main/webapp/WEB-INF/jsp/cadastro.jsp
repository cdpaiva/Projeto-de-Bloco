<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div class="section">
            <h2 class="has-text-centered has-text-weight-bold is-size-3">Cadastro de Usuário</h2>
            <div class="box">
                <form action="cadastrar" method="POST">
                    <div class="columns is-centered">
                        <div class="column is-4">



                            <div class="field">
                                <label class="label">Nome</label>
                                <div class="control">
                                    <input class="input" name="nome" type="text" 
                                           placeholder="Nome Completo" value="usuario">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Endereço</label>
                                <div class="control">
                                    <input class="input" name="endereco" type="text" 
                                           placeholder="Endereço" value="End usuario">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Telefone</label>
                                <div class="control">
                                    <input class="input" name="telefone" type="tel" 
                                           placeholder="Telefone" value="Tel usuario">
                                </div>
                            </div>                    

                            <div class="field">
                                <label class="label">Email</label>
                                <div class="control">
                                    <input class="input" type="text" name="email" 
                                           placeholder="Email" value="user@mail">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Senha</label>
                                <div class="control">
                                    <input class="input" type="password" name="senha" 
                                           placeholder="Senha" value="123">
                                </div>
                            </div>
                        </div>
                        <hr>                     
                        <div class="column is-4">
                            <div class="control ">
                                <label class="label">Selecione o tipo de usuário:</label>
                                <div class="has-text-centered">
                                    <label class="radio">
                                        <input type="radio" name="tipo" value="C"
                                               onclick="document.getElementById('cpf').disabled = false;
                                                       document.getElementById('cnpj').disabled = true;
                                                       document.getElementById('razaoSocial').disabled = true;">
                                        Candidato
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="tipo" value="E"
                                               onclick="document.getElementById('cnpj').disabled = false;
                                                       document.getElementById('razaoSocial').disabled = false;
                                                       document.getElementById('cpf').disabled = true;">
                                        Empresa
                                    </label>
                                </div>
                            </div>                      

                            <div class="field">
                                <label class="label">CPF</label>
                                <div class="control">
                                    <input class="input" id="cpf" name="cpf" type="text" placeholder="CPF" disabled="disabled">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">Razão Social</label>
                                <div class="control">
                                    <input class="input" id="razaoSocial" name="razaoSocial" type="text" placeholder="Razão Social" disabled="disabled">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">CNPJ</label>
                                <div class="control">
                                    <input class="input" id="cnpj" name="cnpj" type="text" placeholder="CNPJ" disabled="disabled">
                                </div>
                            </div>      
                        </div>
                    </div>
                    <div class="columns is-centered">
                        <div class="column is-half">
                            <div class="field has-text-centered">
                                <div class="control">
                                    <input type="submit" class="button is-link is-big" value="Cadastrar">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <c:if test="${not empty msgSucesso}">
                    <div class="notification is-success is-light">
                        <button class="delete"></button>
                        <p>${msgSucesso}</p>
                    </div>
                </c:if> 
            </div>
        </div>
    </body>

</html>
