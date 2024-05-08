<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Tialejo ® - Produto</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/carrossel.css">
    <link rel="shortcut icon" href="@{/images/cd.ico}" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img  src="static/img/cd.ico" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <div class="right-navbar">
        <form action="encontrar-todos-produtos" method="get">
            <button  class="btn mt-4" style="z-index: 999">Voltar</button>
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


    <form action="/visualizar" method="get">
        <div class="maior">
        <div class="produto">
            <div class="carrousel" data-carrousel>
                <div class="slides" data-slides-container>
                    <div class="slide">
                        <div class="conteudo" >
                            <img class="standardsize" src="${produto.image}" alt="Imagem do Produto">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="carrousel-botoes">
            <a href="/visualizar?id=${produto.id}" class="carrousel-botoes botao-anterior " data-carrousel-botao-anterior><span
                    class="fa-solid fa-circle-chevron-left"></span></a>
            <a href="/visualizar?id=${produto.id}"  class="carrousel-botoes botao-proximo " data-carrousel-botao-proximo><span
                    class="fa-solid fa-circle-chevron-right"></span></a>
        </div>
        <div>
            <div class="col-12 text-center align-self-center py-5" style="color: rgb(180, 14, 235)">
                <label>Nome</label>
                        <input value="${produto.nome}" readonly>
            </div>
            <div class="informações">
                <h3 style="color: rgb(234, 18, 18)">Preço: <input value="${produto.preco}" readonly></h3>
                <h4>Avaliações: <input value="${produto.avaliacao}" readonly> <i class="fa-solid fa-star"></i></h4>

            </div>
            <div class="informações">
                <h3 style="color: rgb(234, 18, 18)">Descrição: ${produto.descricao}</h3>
            </div>
            <a href="adicionar-carrinho" class="btn mt-4">Comprar</a>
        </div>
        </div>
    </form>
<script src="static/js/carrousel.js"></script>

</body>

</html>
