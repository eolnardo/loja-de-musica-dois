<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Tialejo ® - Estoquista</title>
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

    <h1>Produtos</h1>
    <table>
        <tr >
            <th>ID</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Valor</th>
            <th>Status</th>
            <c:if test="${sessionScope.loggedUsuario != null}">
                <th colspan="3" style="text-align: center;">Ações</th>
            </c:if>


        </tr>
        <form action="/listar-produtos" method="GET">
            <div class="search">
                <div class="input-group mb-3" style="column-gap: 10px;">
                    <form action="/listar-produtos" method="GET">
                        <div class="busca">
                            <input type="text" class="form-style" placeholder="Busca" name="q">
                            <button class="botao azul" type="submit">Buscar</button>
                        </div>
                    </form>
                    <button class="botao cinza"><a href="/criar-produto.jsp">Criar</a></button>
                </div>
            </div>
        </form>
        <c:forEach var="produto" items="${produtos}">
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.qtdEstoque}</td>
                <td>${produto.preco}</td>
                <td>
                <c:choose>
                    <c:when test="${produto.status}">
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
                            <button class="botao azul"><a href="index.jsp?id=${produto.id}&name=${produto.nome}">Atualizar</a></button>
                        </form>
                    </c:if>
                </td>
                <td>
                    <form action="/visualizar-produto" method="get">
                        <input type="hidden" name="id" value="${produto.id}">
                        <button class="botao azul" type="submit">Visualizar</button>
                    </form>
                </td>
                <c:if test="${sessionScope.loggedUsuario != null and sessionScope.grupo == 'admin'}">
                <td>
                        <form action="alterar-status-produto" method="post">
                            <input type="hidden" name="id" value="${produto.id}">
                            <button class="botao azul" type="submit">Inativar/Reativar</button>
                        </form>
                </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>