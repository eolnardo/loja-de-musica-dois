<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">


<head>
    <title>Tialejo ® - Administrador</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/cliente.css">
    <link rel="shortcut icon" href="img/cd.ico" type="image/x-icon">
</head>

<body>
<nav class="navbar">
    <a th:href="@{'/'}">
        <div class="left-navbar">

            <img th:src="@{/images/cd.ico}" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>

        </div>
    </a>
</nav>
<section class="content">
    <div class="container">

        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">
                    <label for="reg-log"></label>
                    <div class="card-3d-wrap mx-auto">
                        <div class="card-3d-wrapper">
                            <div class="card-front">
                                <div class="center-wrap">
                                    <div class="section text-center actions">
                                        <h1 class="mb-0 pb-3"><span>Início</span></h1>
                                        <a href="/encontrar-todos-usuarios" class="btn mt-4">Listar Usuários</a>
                                        <a href="/encontrar-todos-produtos" class="btn mt-4">Listar Produtos</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>