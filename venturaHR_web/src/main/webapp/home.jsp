<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <nav class="navbar has-background-info" role="navigation" aria-label="main navigation">
            <div class="navbar-brand has-text-weight-bold">
                <a class="navbar-item" href="index.jsp">
                    VENTURA HR
                </a>
            </div>
        </nav>

        <div class="columns">

            <div class="column is-two-thirds">
                <div class="container block is-fluid">
                    <div class="notification has-text-centered p-6">Vagas recentes</div>
                </div>
                <div class="container block is-fluid">
                    <div class="notification has-text-centered">Futuro anuncio de vaga</div>
                </div>
                <div class="container block is-fluid">
                    <div class="notification has-text-centered">Futuro anuncio de vaga</div>
                </div>
                <div class="container block is-fluid">
                    <div class="notification has-text-centered">Futuro anuncio de vaga</div>
                </div>
                <div class="container block is-fluid">
                    <div class="notification has-text-centered">Futuro anuncio de vaga</div>
                </div>
                <div class="container block is-fluid">
                    <div class="notification has-text-centered">Futuro anuncio de vaga</div>
                </div>

            </div>

            <div class="column is-one-third">
                <div class="box">
                    <form action="usuarios/login" method="POST">
                        <figure class="image">
                            <img src="venturaLogo.png">
                        </figure>
                        <div class="field">
                            <label class="label">Email</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" placeholder="E-mail"
                                       name="email" value="maria@gmail.com"> <span class="icon is-small is-left">
                                    <i class="fa fa-user"></i>
                                </span>
                            </div>

                        </div>

                        <div class="field">
                            <label class="label">Senha</label>
                            <div class="control has-icons-left">
                                <input class="input" type="password" placeholder="Senha"
                                       name="senha"> <span class="icon is-small is-left">
                                    <i class="fa fa-lock"></i>
                                </span>
                            </div>
                        </div>

                        <input class="button is-info is-fullwidth" type="submit" value="Login">
                    </form>
                </div>

                <div class="box has-text-centered">
                    <h3>Ainda não possui uma conta?</h3>
                    <a href="cadastro.html">Cadastrar-se</a>

                </div>
            </div>
        </div>
    </body>

    <footer class="footer">
        <div class="content has-text-centered">
            <p>
                Carlos Damiani Paiva - Projeto de Bloco Desenvolvimento Java
            </p>
        </div>
    </footer>
</html>