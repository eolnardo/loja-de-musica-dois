<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Resumo do Pedido - Tialejo ®</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<h1>Resumo do Pedido</h1>
<!-- Exibir os detalhes do pedido, como produtos, valores, endereço de entrega, etc. -->
<p>Endereço de Entrega: ${enderecoEntrega}</p>
<p>Forma de Pagamento: ${formaPagamento}</p>
<!-- Lista de produtos selecionados -->
<h2>Produtos Selecionados:</h2>
<table>
    <tr>
        <th>Produto</th>
        <th>Quantidade</th>
        <th>Valor Unitário</th>
        <th>Valor Total</th>
    </tr>
    <c:forEach var="item" items="${carrinho}">
        <tr>
            <td>${item.produto.nome}</td>
            <td>${item.quantidade}</td>
            <td>R$ ${item.produto.preco}</td>
            <td>R$ ${item.produto.preco * item.quantidade}</td>
        </tr>
    </c:forEach>
</table>
<!-- Exibir frete, total geral, etc. -->
<p>Frete: R$ ${frete}</p>
<p>Total Geral: R$ ${totalGeral}</p>
<!-- Botões para concluir compra e voltar -->
<form action="/processar-pedido" method="post">
    <button type="submit">Concluir Compra</button>
</form>
<form action="/escolha-pagamento.jsp" method="get">
    <button type="submit">Voltar</button>
</form>
</body>
</html>
