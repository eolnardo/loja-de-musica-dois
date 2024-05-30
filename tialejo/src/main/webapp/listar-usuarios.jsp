<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
    <title>Tialejo ® - Sua Loja de Música!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
</head>
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img  src="static/images/logo-tialejo.png" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <c:if test="${sessionScope.loggedUsuario != null}">
        <span>${sessionScope.loggedUsuario}</span>
        <a href="/logout-backoffice">Sair</a>
    </c:if>
</nav>

<body>
    <div id="container-tabela">

    <c:if test="${sessionScope.loggedUsuario != null}">
        <span>${sessionScope.loggedUsuario}</span>
        <a href="/logout-backoffice">Sair</a>
    </c:if>

    <h1>Usuários</h1>
        <form action="/listar-produtos" method="GET">
            <div class="search">
                <div class="input-group mb-3" style="column-gap: 10px;">
                    <form action="/listar-produtos" method="GET">
                        <div class="busca">
                            <input type="text" class="form-style" placeholder="Busca" name="q">
                            <button class="botao azul" type="submit">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </form>
        <a href="/criar-usuario.jsp" class="botao cinza">Criar</a>
        <table>
        <tr>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Status</th>
            <th>Grupo</th>
            <th>Status</th>
            <c:if test="${sessionScope.loggedUsuario != null}">
                <th colspan="2" style="text-align: center;">Ações</th>
            </c:if>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.status}</td>
                <td>${usuario.grupo}</td>
                <td>
                    <c:choose>
                        <c:when test="${usuario.status}">
                            Ativo
                        </c:when>
                        <c:otherwise>
                            Inativo
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${sessionScope.loggedUsuario != null}">
                        <form action="/delete-car" method="post">
                            <button class="botao azul"><a href="index.jsp?id=${usuario.nome}&name=${usuario.email}">Atualizar</a></button>
                        </form>
                    </c:if>
                </td>
                <td>
                    <c:if test="${sessionScope.loggedUsuario != null}">
                        <form action="alterar-status-usuario" method="post">
                            <input type="hidden" name="id" value="${usuario.id}">
                            <button class="botao azul" type="submit">Inativar/Reativar</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>