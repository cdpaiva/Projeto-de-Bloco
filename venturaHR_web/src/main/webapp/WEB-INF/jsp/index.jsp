<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bem-vindo</title>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menuSuperior.jsp"/>

        <div class="columns">

            <div class="column is-two-thirds">
                <div class="box">
                    <div class="notification has-text-centered is-size-2 p-6 has-background-info-light">VenturaHR</div>
                </div>
                <h2 class="has-text-weight-bold has-text-centered">Confira algumas de nossas vagas disponíveis</h2>
                <div class="box">
                    <div class="container block is-fluid">
                        <div class="notification has-text-centered">
                            <p>${vagaExemplo.cargo}</p>
                            <p>
                                <span class="icon">
                                    <i class="fa fa-map-marker"></i>
                                </span>  
                                ${vagaExemplo.cidade}
                            </p>
                        </div>
                    </div>
                    <div class="container block is-fluid">
                        <div class="notification has-text-centered">
                            <p>${vagaExemplo2.cargo}</p>
                            <p>
                                <span class="icon">
                                    <i class="fa fa-map-marker"></i>
                                </span> 
                                ${vagaExemplo2.cidade}
                            </p>
                        </div>
                    </div>
                </div>
                <h2 class="has-text-centered">Acesse o sistema para mais vagas</h2>

            </div>

            <div class="column is-one-third">
                <div class="box">
                    <form action="/login" method="POST">
                        <div class="field">
                            <label class="label">Email</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" placeholder="E-mail"
                                       name="email" value="joao@gmail.com"> 
                                <span class="icon is-small is-left">
                                    <i class="fa fa-user"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Senha</label>
                            <div class="control has-icons-left">
                                <input class="input" type="password" placeholder="Senha"
                                       name="senha"> 
                                <span class="icon is-small is-left">
                                    <i class="fa fa-lock"></i>
                                </span>
                            </div>
                        </div>

                        <input class="button is-info is-outlined is-fullwidth" type="submit" value="Login">
                    </form>
                </div>

                <div class="box has-text-centered">
                    <h3>Ainda não possui uma conta?</h3>
                    <a href="/cadastro" class="button is-info is-outlined">Cadastrar-se</a>

                </div>
            </div>
        </div>
    </body>

    <footer class="footer">
        <div class="content has-text-centered">
            <p>
                Carlos Damiani Paiva - Projeto de Bloco Desenvolvimento Java
            </p>
            <p>
                Instituto INFNET - Setembro 2021
            </p>
        </div>
    </footer>
</html>
