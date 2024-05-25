<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/carrinho.css">
    <link rel="stylesheet" href="static/css/cliente.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Carrinho de compras</title>
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
    <a href="carrinho.jsp"><i class="fa-solid fa-cart-shopping mt-4"></i></a>
    <c:choose>
        <c:when test="${sessionScope.loggedCliente != null}">
            <a href="/logout-cliente" class="btn mt-4" style="z-index: 999">Sair</a>
        </c:when>
        <c:otherwise>
                <a href="/login-cliente" class="btn mt-4" style="z-index: 999">>Login ou Cadastre-se</a>
            </div>
        </c:otherwise>
    </c:choose>

</nav>
<body>

<main>
    <div class="titulo">Carrinho</div>
    <div class="conteudo">
        <form action="/adicionar-carrinho" method="get">
            <c:set var="subtotal" value="0" scope="page"/>
            <c:forEach var="carrinho" items="${carrinhos}">
                <section>
                    <table class="tabela">
                        <thead>
                        <tr>
                            <th>Produto</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            <th>Total</th>
                            <th>Remover</th>
                        </tr>
                        </thead>
                <tbody>
                <tr>
                    <td>
                        <div class="product">
                            <img class="img" src="${carrinho.produto.image}" style="max-height: 8rem; max-width: 8rem" alt="${carrinho.produto.nome}">
                            <div class="info">
                                <div class="name">${carrinho.produto.nome}</div>
                            </div>
                        </div>
                    </td>
                    <td>R$ ${carrinho.produto.preco}</td>
                    <td>
                        <span>${carrinho.quantidade}</span>
                    </td>
                    <td><fmt:formatNumber value="${carrinho.produto.preco * carrinho.quantidade}" type="currency" currencySymbol="R$"/></td>
                    <td>
                        <button class="remove"><i class="fa-solid fa-x"></i></button>
                    </td>
                </tr>

                </tbody>
            </table>
        </section>
            </c:forEach>
        </form>
        <aside>
            <div class="box">
                <header>Resumo da compra</header>
                <div class="infoCp">
                    <div><span>Sub-total</span>R$300</div>
                    <div><span>Frete</span>Grátis</div>
                </div>
                <footer>
                    <span>Total:</span>
                    <span>R$300,00</span>
                </footer>
            </div>
            <button class="botao azul">Finalizar Compra</button>
        </aside>
    </div>
</main>
</body>

</html>