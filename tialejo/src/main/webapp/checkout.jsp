<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Checkout - Tialejo ®</title>
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
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img src="static/images/cd.ico" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <div class="right-navbar">
        <a class="btn mt-4" style="z-index: 999" href="/carregar-tela-inicial">Voltar</a>
        <a href="/logout-cliente" class="btn mt-4" style="z-index: 999">Sair</a>
    </div>
</nav>

<main>
    <div class="container mt-5">
        <h2>Escolha o Endereço de Entrega</h2>
        <!-- <form action="/processar-endereco" method="post"> -->
            <div class="form-group">
                <label for="endereco">Endereço:</label>
                <select class="form-control" id="endereco" name="endereco" required>
                    <c:forEach var="endereco" items="${enderecos}">
                        <option value="${endereco.id}">${endereco.endereco}, ${endereco.cep}</option>
                    </c:forEach>
                </select>
            </div>
        <!--  <button type="submit" class="btn btn-primary">Confirmar Endereço</button>
        </form> -->

        <h2 class="mt-5">Forma de Pagamento</h2>
        <form action="/processar-pedido" method="get">
            <div class="form-group">
                <label for="formaPagamento">Forma de Pagamento:</label>
                <select class="form-control" id="formaPagamento" name="formaPagamento" required>
                    <option value="boleto">Boleto</option>
                    <option value="cartao">Cartão de Crédito</option>
                </select>
            </div>

            <div id="cartaoDetails" style="display: none;">
                <div class="form-group">
                    <label for="numeroCartao">Número do Cartão:</label>
                    <input type="text" class="form-control" id="numeroCartao" name="numeroCartao">
                </div>
                <div class="form-group">
                    <label for="codigoVerificador">Código Verificador:</label>
                    <input type="text" class="form-control" id="codigoVerificador" name="codigoVerificador">
                </div>
                <div class="form-group">
                    <label for="nomeCompleto">Nome Completo:</label>
                    <input type="text" class="form-control" id="nomeCompleto" name="nomeCompleto">
                </div>
                <div class="form-group">
                    <label for="dataVencimento">Data de Vencimento:</label>
                    <input type="text" class="form-control" id="dataVencimento" name="dataVencimento">
                </div>
                <div class="form-group">
                    <label for="parcelas">Quantidade de Parcelas:</label>
                    <select class="form-control" id="parcelas" name="parcelas">
                        <c:forEach var="i" begin="1" end="12">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <button type="submit" class="btn btn-primary mt-3">Confirmar Pagamento</button>
        </form>
    </div>
</main>

<script>
    document.getElementById('formaPagamento').addEventListener('change', function() {
        var display = this.value === 'cartao' ? 'block' : 'none';
        document.getElementById('cartaoDetails').style.display = display;
    });
</script>

</body>
</html>
