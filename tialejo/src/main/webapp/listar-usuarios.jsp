<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>Tialejo ® - Sua Loja de Música!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="@{css/style.css}">
    <link rel="shortcut icon" href="@{/images/cd.ico}" type="image/x-icon">
</head>
<body>
<div>

    <c:if test="${sessionScope.loggedUsuario != null}">
        <span>${sessionScope.loggedUsuario}</span>
        <a href="/logout-backoffice">Sair</a>
    </c:if>

    <h1>usuarios</h1>
    <table>
        <tr>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Status</th>
            <th>Grupo</th>
            <c:if test="${sessionScope.loggedUsuario != null}">
                <th>Ações</th>
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
                            <span> | </span>
                            <a href="index.jsp?id=${usuario.nome}&name=${usuario.email}">Atualizar</a>
                        </form>
                    </c:if>
                </td>
                <td>
                    <c:if test="${sessionScope.loggedUsuario != null}">
                        <form action="alterar-status-usuario" method="post">
                            <input type="hidden" name="id" value="${usuario.id}">
                            <button type="submit">Inativar/Reativar</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>