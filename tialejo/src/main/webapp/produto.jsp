<%@ page contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>Tialejo ® - Produto</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/css/style.css">
        <link rel="stylesheet" href="static/css/carrossel.css">
        <link rel="stylesheet" href="static/css/cliente.css">
        <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <body>
        <nav class="navbar">
            <a href="/carregar-tela-inicial">
                <div class="left-navbar">
                    <img src="static/images/cd.ico" alt="Logo">
                    <h1 class="mt-2">Tialejo ®</h1>
                </div>
            </a>
            <div class="right-navbar">
                <form action="encontrar-todos-produtos" method="get">
                    <button class="btn mt-4" style="z-index: 999">Voltar</button>
                </form>
                <c:choose>
                    <c:when test="${sessionScope.loggedUsuario != null}">
                        <a href="/logout-cliente" class="btn mt-4" style="z-index: 999">Sair</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/login-cliente" class="btn mt-4" style="z-index: 999">Login</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>



        <form action="/visualizar-produto" method="get">
            <div class="maior">
                <div class="produto">
                    <div class="carrousel" data-carrousel>
                        <div class="slides" data-slides-container>
                            <div class="slide">
                                <div class="conteudo">
                                    <img class="standardsize" src="${produto.image}" alt="Imagem do Produto">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carrousel-botoes">
                    <a href="/visualizar?id=${produto.id}" class="carrousel-botoes botao-anterior "
                        data-carrousel-botao-anterior><span class="fa-solid fa-circle-chevron-left"></span></a>
                    <a href="/visualizar?id=${produto.id}" class="carrousel-botoes botao-proximo "
                        data-carrousel-botao-proximo><span class="fa-solid fa-circle-chevron-right"></span></a>
                </div>
                <div class="form">
                    <div class="input-group">
                        <div class="input-box">
                            <input type="hidden" name="action" value="adicionar">
                            <input type="hidden" name="idProduto" value="${produto.id}">
                            <label>Nome: </label>
                            <input value="${produto.nome}" readonly>
                        </div>
                        <div class="input-box">
                            <label>Descrição: </label>
                            <input value="${produto.descricao}" readonly>
                        </div>
                        <div class="input-box">
                            <label>Preço: </label>
                            <input value="${produto.preco}" readonly>
                        </div>
                        <div class="input-box">
                            <label>Avaliações: <i class="fa-solid fa-star"></i></label>
                            <input value="${produto.avaliacao}" readonly>
                        </div>
                        <div class="action-button" style="margin-left: 40%;">
                            <button type="submit" class="botao azul">Adicionar ao Carrinho</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <script src="static/js/carrousel.js"></script>

    </body>

    </html>