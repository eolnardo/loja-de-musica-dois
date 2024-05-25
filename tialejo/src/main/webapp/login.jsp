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
    <link rel="stylesheet" href="static/css/cliente.css">
    <link rel="shortcut icon" href="@{/images/cd.ico}" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img  src="static/images/logo-tialejo.png" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <div class="right-navbar">
    </div>
</nav>
<section class="content">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 justify-content-center text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">
                    <div class="form">

                        <h1 class="mb-0 pb-3">Login</h1>
                        <form action="/login-cliente" method="post">
                            <div class="input-group">
                                <div class="input-box">
                                    <span>${requestScope.message}</span>
                                </div>
                                <br>
                                <div class="input-box">
                                    <label for="email">E-mail:</label>
                                    <input type="text" id="email" name="email">
                                </div>
                                <div class="input-box">
                                    <label for="senha">Senha:</label>
                                    <input type="password" id="senha" name="senha">
                                </div>

                            </div>
                            <div class="action-button">
                                <button class="botao azul" type="submit" style="width: 250px;">Entrar</button>
                                <button class="botao cinza">Cadastre-se</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>

</body>
</html>