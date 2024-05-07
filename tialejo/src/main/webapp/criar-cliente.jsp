<%--
  Created by IntelliJ IDEA.
  User: titi2
  Date: 07/05/2024
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                    <div class="form">
                        <form action="criar-cliente" method="post">
                            <div class="form-header">
                                <div class="title">
                                    <h1>Cadastre-se!!!</h1>
                                </div>
                            </div>
                            <div class="input-group">

                                <div class="input-box">
                                    <label for="nome">Nome:</label>
                                    <input type="text" id="nome" name="nome" value="${param.nome}" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="email">E-mail:</label>
                                    <input type="text" id="email" name="email" value="${param.email}" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="nascimento">Data de Nascimento:</label>
                                    <input type="text" id="nascimento" name="nascimento" value="${param.nascimento}" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="genero">Gênero:</label>
                                    <input type="text" id="genero" name="genero" value="${param.genero}" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="endereco">Endereço:</label>
                                    <input type="text" id="endereco" name="endereco" value="${param.endereco}" required><br><br>
                                    <!-- Inicio do formulario PARA VALIDAR CEP
                                    <form method="get" action=".">
                                        <label>Cep:
                                            <input name="cep" type="text" id="cep" value="" size="10" maxlength="9"
                                                   onblur="pesquisacep(this.value);" /></label><br />
                                        <label>Rua:
                                            <input name="rua" type="text" id="rua" size="60" /></label><br />
                                        <label>Bairro:
                                            <input name="bairro" type="text" id="bairro" size="40" /></label><br />
                                        <label>Cidade:
                                            <input name="cidade" type="text" id="cidade" size="40" /></label><br />
                                        <label>Estado:
                                            <input name="uf" type="text" id="uf" size="2" /></label><br />
                                        <label>IBGE:
                                            <input name="ibge" type="text" id="ibge" size="8" /></label><br />
                                    </form>   -->
                                </div>

                                <div class="input-box">
                                    <label for="cpf">CPF:</label>
                                    <input type="text" id="cpf" name="cpf" value="${param.cpf}" min="14" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="senha">Senha:</label>
                                    <input type="password" id="senha" name="senha" value="${param.senha}"  required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="confirmarSenha">Confirmar Senha:</label>
                                    <input type="password" id="confirmarSenha" name="confirmarSenha" value="${param.confirmarSenha}"  required><br><br>
                                </div>
                                <div class="input-box">
                                    <input type="hidden" id="id" name="id" value="${param.id}">
                                </div>
                            </div>

                            <div class="cadastrar-button">
                                <div>
                                    <button class="botao azul" ><a class="azul" href="index.jsp">Voltar</a></button>
                                </div>
                                <div>
                                    <button type="submit" class="botao verde" style="margin-left: 10px">Cadastrar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
