<!doctype html>
<html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <title>Tialejo ® - Cadastro de Usuário</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" th:href="@{/css/style.css}">
    <link rel="shortcut icon" th:href="@{/images/cd.ico}" type="image/x-icon">

</head>

<body>
<nav class="navbar">
    <a th:href="@{'/'}">
        <div class="left-navbar">

            <img  th:src="@{/images/cd.ico}" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>

        </div>
    </a>
    <div class="right-navbar">
    </div>
</nav>
<section class="content">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5" style="max-width: 50%; margin-left: auto; margin-right: auto;">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">

                    <h4 class="mb-3 pb-3">Cadastre-se</h4>
                    <form method="post" action="/cadastro-cliente" th:object="${cliente}">
                        <div th:if="${errors}" class="error-message">
                            <ul>
                                <li th:each="error : ${#fields.errors('*')}" th:text="${error}"></li>
                            </ul>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-style" placeholder="Nome Completo" name="name">
                            <i class="input-icon uil uil-user"></i>
                            <div th:if="${#fields.hasErrors('name')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('name')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="text" class="form-style" placeholder="Telefone" name="telefone">
                            <i class="input-icon uil uil-phone"></i>
                            <div th:if="${#fields.hasErrors('name')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('telefone')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="text" class="form-style" placeholder="endereço" name="endereco">
                            <div th:if="${#fields.hasErrors('endereco')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('endereco')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="text" class="form-style" placeholder="gênero" name="gênero">
                            <div th:if="${#fields.hasErrors('genero')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('genero')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="text" class="form-style" placeholder="CPF" name="cpf">
                            <div th:if="${#fields.hasErrors('cpf')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('cpf')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="email" class="form-style" placeholder="Email" name="email">
                            <i class="input-icon uil uil-at"></i>
                            <div th:if="${#fields.hasErrors('email')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('email')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <div class="form-group mt-2">
                            <input type="password" class="form-style" placeholder="Senha" name="senha">
                            <i class="input-icon uil uil-lock-alt"></i>
                        </div>
                        <div class="form-group mt-2">
                            <input type="password" class="form-style" placeholder="Confirmar Senha" name="confirmaSenha">
                            <i class="input-icon uil uil-lock-alt"></i>
                            <div th:if="${#fields.hasErrors('senha')}" class="error-message">
                                <ul>
                                    <li th:each="error : ${#fields.errors('senha')}" th:text="${error}"></li>
                                </ul>
                            </div>
                        </div>
                        <button type="submit" class="btn mt-4">Cadastrar</button>
                        <a href="loginCliente" class="btn mt-4">Voltar</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>
