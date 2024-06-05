<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html>

            <head>
                <title>Resumo do Pedido - Tialejo ®</title>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
                <link rel="stylesheet" href="static/css/style.css">
                <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
                    integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
            </head>
            <nav class="navbar navbar-expand-lg bg-info">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/carregar-tela-inicial"><img src="static/images/cd.png" class="logo"
                            alt="Logo"> Tialejo
                        ®</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        </ul>
                        <ul class="navbar-nav">
                        </ul>
                    </div>
                </div>
            </nav>

            <body class="bg-dark text-white">
                <div class="container">
                    <div class="col-md-8 mx-auto rounded border p-4 m-4">

                        <h2 class="text-center mb-5 text-info">Resumo do Pedido</h1>
                        <!-- Exibir os detalhes do pedido, como produtos, valores, endereço de entrega, etc. -->
                        <p>Endereço de Entrega: ${enderecoEntrega}</p>
                        <p>Forma de Pagamento: ${formaPagamento}</p>
                        <!-- Lista de produtos selecionados -->
                        <h2>Produtos Selecionados:</h2>
                        <table class="table ml-auto">
                            <thead>
                                <tr>
                                    <th class="text-center bg-info">Produto</th>
                                    <th class="text-center bg-info">Quantidade</th>
                                    <th class="text-center bg-info">Valor Unitário</th>
                                    <th class="text-center bg-info">Valor Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${carrinho}">
                                    <tr>
                                        <td class="table-info">${item.produto.nome}</td>
                                        <td class="table-info">${item.quantidade}</td>
                                        <td class="table-info">R$ ${item.produto.preco}</td>
                                        <td class="table-info">R$ ${item.produto.preco * item.quantidade}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td class="text-center bg-info fw-bold" colspan="2">Frete: R$ ${frete}</td>
                                    <td class="text-center bg-info fw-bold" colspan="2">Total Geral: R$ ${totalGeral}
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                        <!-- Exibir frete, total geral, etc.
                        <p>Frete: R$ ${frete}</p>
                        <p>Total Geral: R$ ${totalGeral}</p>
                        Botões para concluir compra e voltar 
                            
                        ZÉ: coloquei o conteúdo dos parágrafos dentro do rodapé da tabela pra testar -->

                        <div class="row">
                            <div class="offset-sm-4 col-sm-4 d-grid">
                                <form style="width: fit-content;" action="/escolha-pagamento.jsp" method="get">
                                    <button class="btn btn-secondary" type="submit">Voltar</button>
                                </form>
                            </div>
                            <div class="col-sm-4 d-grid">   
                                <form style="width: fit-content;" action="/processar-pedido" method="post">
                                    <button class="btn btn-info" type="submit">Concluir</button>
                                </form>
                            </div>
                        </div>



                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous"></script>
            </body>

            </html>