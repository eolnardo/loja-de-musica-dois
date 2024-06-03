<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Adicionar Endereço - Tialejo ®</title>
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

<main>
    <div class="container mt-5">
        <h2>Adicionar Endereço</h2>
        <form action="/adicionar-endereco" method="post">
            <div class="form-group">
                <label for="rua">Rua:</label>
                <input type="text" class="form-control" id="rua" name="rua" required>
            </div>
            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="text" class="form-control" id="numero" name="numero" required>
            </div>
            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" class="form-control" id="cidade" name="cidade" required>
            </div>
            <div class="form-group">
                <label for="estado">Estado:</label>
                <input type="text" class="form-control" id="estado" name="estado" required>
            </div>
            <button type="submit" class="btn btn-primary">Adicionar Endereço</button>
        </form>
    </div>
</main>

</body>
</html>
