<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tialejo ® - Login</title>
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
<section class="content">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 justify-content-center text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center" style="max-width: 50%; margin-left: 25%;">

                    <h1 class="mb-0 pb-3">Login</h1>
<form action="/login-cliente" method="post">

    <span>${requestScope.message}</span>

    <br>

    <label for="email">E-mail:</label>
    <input type="text" id="email" name="email">

    <br>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha">

    <button type="submit">Entrar</button>

    <a href="criar-cliente.jsp" type="submit">Cadastre-se!</a>
</form>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>