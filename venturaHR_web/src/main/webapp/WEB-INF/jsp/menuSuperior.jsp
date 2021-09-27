<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar has-background-info" role="navigation" aria-label="main navigation">
    <div class="navbar-brand has-text-weight-bold">
        <a class="navbar-item" href="/">
            VENTURA HR
        </a>
    </div>
    <div class="navbar-end">
        <div class="navbar-item">
            <c:if test="${not empty user}">
                <div class="buttons">
                    <a class="button is-active is-info">Olá ${user.nome}</a>

                    <a class="button is-info" href="/logout">Sair</a>
                </div>
            </c:if>
        </div>
    </div>
</nav>
