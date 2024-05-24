<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">

    <head>
        <title>Tialejo ® - Sua Loja de Música!</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
            integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="static/css/style.css">
        <link rel="stylesheet" href="static/css/cliente.css">
        <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
    </head>

    <nav class="navbar">
        <a href="/carregar-tela-inicial">
            <div class="left-navbar">
                <img src="static/images/logo-tialejo.png" alt="Logo">
                <h1 class="mt-2">Tialejo ®</h1>
            </div>
        </a>

        <form action="atualizar-cadastro-cliente" method="get">
            <li>
                <button class="botao azul" type="submit">Meu Cadastro</button>
            </li>
        </form>

        <div class="right-navbar">
            <c:choose>
                <c:when test="${sessionScope.loggedCliente != null}">
                    <a href="/logout-cliente" class="btn mt-4" style="z-index: 999">Sair</a>
                </c:when>
                <c:otherwise>
                    <div class="right-navbar">
                        <a href="/adicionar-carrinho"><i class="fa-solid fa-cart-shopping mt-4"></i></a>
                        <a href="/login-cliente" class="btn mt-4" style="z-index: 999">>Login ou Cadastre-se</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
    <body>

        <section id="secao-produtos">
            <form action="/carregar-tela-inicial" method="get">
                <c:forEach var="produto" items="${produtos}">
                    <ul>
                        <li>
                            <div class="card col-09">
                                <div class="card-info">
                                    <img src="${produto.image}" class="img-principal" alt="imagem principal do produto">
                                    <h3>${produto.nome}</h3>
                                    <span style="display: flex; gap: 5px; justify-content: center;">
                                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                                        <h4>${produto.avaliacao}</h4>
                                    </span>
                                    <span style="display: flex; gap: 5px; justify-content: center;">
                                        <i class="fa-solid fa-hand-holding-dollar" style="color: #74C0FC;"></i>
                                        <h4>${produto.preco}</h4>
                                    </span>
                                    <span style="display: flex; gap: 5px; justify-content: center;">
                                        <i class="fa-solid fa-info-circle" style="color: #74C0FC;"></i>
                                        <h4>${produto.descricao}</h4>
                                    </span>
                                    <a href="/visualizar?id=${produto.id}" class="btn mt-1 align-self-center">Ver
                                        Detalhes</a>
                                </div>
                            </div>
                        </li>
                    </ul 
                </c:forEach>
            </form>
        </section>

        <script src="https://kit.fontawesome.com/eaae749ef3.js" crossorigin="anonymous"></script>

    </body>

    </html>