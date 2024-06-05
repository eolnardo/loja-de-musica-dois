<%@ page contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>Tialejo ® - Login</title>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <nav class="navbar navbar-expand-lg bg-info">
        <div class="container-fluid">
            <a class="navbar-brand" href="/carregar-tela-inicial"><img src="static/images/cd.png" class="logo"
                    alt="Logo"> Tialejo
                ®</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
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

    <body class="bg-dark">

        <div class="container">
            <div class="col-md-8 mx-auto rounded border p-4 m-4">
                <h2 class="text-center mb-5 text-info">Login</h1>

                    <form action="/login-cliente" method="post">
                        <div class="row mb-3">
                            <span>${requestScope.message}</span>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-4 col-form-label text-white text-center" for="email">E-mail:</label>
                            <div class="col-sm-8">
                                <input class="form-control" type="text" id="email" name="email">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-4 col-form-label text-white text-center" for="email">Senha:</label>
                            <div class="col-sm-8">
                                <input class="form-control" type="password" id="senha" name="senha">
                            </div>
                        </div>

                        <div class="row">
                            <div class="offset-sm-4 col-sm-4 d-grid">
                                <a href="criar-cliente.jsp" class="btn btn-secondary">Cadastre-se</a>
                            </div>
                            <div class="col-sm-4 d-grid">
                                <button class="btn btn-info" type="submit">Entrar</button>
                            </div>
                        </div>
                    </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    </body>

    </html>