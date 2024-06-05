<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page contentType="text/html; charset=UTF-8" %>
        <!doctype html>
        <html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">


        <head>
            <title>Tialejo ® - Cadastrar-se</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
                integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
                crossorigin="anonymous" referrerpolicy="no-referrer" />
            <link rel="stylesheet" href="static/css/style.css">
            <link rel="stylesheet" href="static/css/cliente.css">
            <link rel="shortcut icon" href="img/cd.ico" type="image/x-icon">
            <!-- jQuery -->
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <!-- jQuery UI -->
            <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">

            <!-- Adicione este script dentro da seção <head> do seu arquivo JSP -->
            <script>
                function consultarCEP(cep, endereco) {
                    // Fazendo a requisição AJAX para o endpoint da API do Postmon
                    $.ajax({
                        url: "https://api.postmon.com.br/v1/cep/" + cep,
                        type: "GET",
                        dataType: "json",
                        success: function (response) {
                            // Manipulando a resposta da API
                            // Aqui você pode acessar os dados do CEP na variável 'response'
                            // Por exemplo: response.logradouro, response.bairro, response.cidade, response.estado, etc.
                            document.getElementById(endereco).value = cep + ', ' + response.logradouro + ', ' + response.bairro + ', ' + response.cidade + ' - ' + response.estado;
                        },
                        error: function (xhr, status, error) {
                            // Manipulando erros, se houver algum
                            console.error('Erro ao consultar CEP:', error);
                        }
                    });
                }

                function validarCPF(cpf) {
                    cpf = cpf.replace(/[^\d]+/g, '');
                    if (cpf == '') return false;
                    // Elimina CPFs invalidos conhecidos
                    if (cpf.length != 11 ||
                        cpf == '00000000000' ||
                        cpf == '11111111111' ||
                        cpf == '22222222222' ||
                        cpf == '33333333333' ||
                        cpf == '44444444444' ||
                        cpf == '55555555555' ||
                        cpf == '66666666666' ||
                        cpf == '77777777777' ||
                        cpf == '88888888888' ||
                        cpf == '99999999999')
                        return false;
                    // Valida 1o digito
                    add = 0;
                    for (i = 0; i < 9; i++)
                        add += parseInt(cpf.charAt(i)) * (10 - i);
                    rev = 11 - (add % 11);
                    if (rev == 10 || rev == 11)
                        rev = 0;
                    if (rev != parseInt(cpf.charAt(9)))
                        return false;
                    // Valida 2o digito
                    add = 0;
                    for (i = 0; i < 10; i++)
                        add += parseInt(cpf.charAt(i)) * (11 - i);
                    rev = 11 - (add % 11);
                    if (rev == 10 || rev == 11)
                        rev = 0;
                    if (rev != parseInt(cpf.charAt(10)))
                        return false;
                    return true;
                }

                function copiarEndereco() {
                    // Obter os valores do endereço de faturamento
                    var enderecoFaturamento = document.getElementById('enderecoFaturamento').value;
                    var cepFaturamento = document.getElementById('cepFaturamento')

                    // Definir os valores do endereço de faturamento nos campos de endereço de entrega
                    document.getElementById('cepEntrega').value = cepFaturamento;
                    document.getElementById('enderecoEntrega').value = enderecoFaturamento;
                }
            </script>


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

        <body class="bg-dark">
            <div class="container">
                <div class="col-md-8 mx-auto rounded border p-4 m-4">
                    <h2 class="text-center mb-5 text-info">Cadastre-se</h1>
                        <form action="criar-cliente" method="post">
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="nome">Nome:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="nome" name="nome" value="${param.nome}"
                                        required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="email">E-mail:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="email" name="email"
                                        value="${param.email}" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="dataNascimento">Data
                                    de Nascimento:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="dataNascimento" name="dataNascimento"
                                        value="${param.dataNascimento}" >
                                </div>
                            </div>
                            <script>
                                $(function () {
                                    $("#dataNascimento").datepicker();
                                });
                            </script>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="cepFaturamento">CEP
                                    Faturamento:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="cepFaturamento" name="cepFaturamento"
                                        value="${param.cepFaturamento}" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="offset-sm-4 col-sm-4 d-grid">
                                    <button class="btn btn-info" type="button"
                                        onclick="consultarCEP(document.getElementById('cepFaturamento').value, 'enderecoFaturamento')">Consultar</button>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="enderecoFaturamento">Endereço de Faturamento:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="enderecoFaturamento"
                                        name="enderecoFaturamento" value="${param.enderecoFaturamento}" readonly>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="complementoFaturamento">Complemento:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="complementoFaturamento"
                                        name="complementoFaturamento">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="cepEntrega">CEP do
                                    Endereço de Entrega:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="cepEntrega" name="cepEntrega"
                                        value="${param.cepEntrega}" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="offset-sm-4 col-sm-4 d-grid">
                                    <button class="btn btn-info" type="button"
                                        onclick="consultarCEP(document.getElementById('cepEntrega').value, 'enderecoEntrega')">Consultar</button>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="enderecoEntrega">Endereço de Entrega:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="enderecoEntrega" name="enderecoEntrega"
                                        value="${param.enderecoEntrega}" required>
                                </div>

                            </div>
                            <div class="row mb-3">
                                <div class="offset-sm-4 col-sm-4 d-grid">
                                    <button class="btn btn-info" type="button" onclick="copiarEndereco()">Copiar
                                        Faturamento</button>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="complementoEntrega">Complemento Entrega:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="complementoEntrega"
                                        name="complementoEntrega">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="cpf">CPF:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" id="cpf" name="cpf" value="${param.cpf}"
                                        maxlength="14" required>
                                    <span id="cpfError" style="color: red;"></span>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="genero">Gênero:</label>
                                <div class="col-sm-8">
                                    <select class="form-control" id="genero" name="genero" required>
                                        <option value="" disabled selected>Selecione o gênero</option>
                                        <option value="Homem">Homem</option>
                                        <option value="Mulher">Mulher</option>
                                        <option value="Outro">Outro</option>
                                        <option value="Prefiro não dizer">Outro</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center" for="senha">Senha:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="password" id="senha" name="senha"
                                        value="${param.senha}" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label text-white text-center"
                                    for="confirmarSenha">Confirmar Senha:</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="password" id="confirmarSenha"
                                        name="confirmarSenha" value="${param.confirmarSenha}" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <input type="hidden" id="id" name="id" value="${param.id}">
                            </div>

                            <div class="row">
                                <div class="offset-sm-4 col-sm-4 d-grid">
                                    <button class="btn btn-secondary"><a class="text-dark" href="index.jsp">Voltar</a></button>
                                </div>
                                <div class="col-sm-4 d-grid">
                                    <button type="submit" class="btn btn-info">Cadastrar</button>
                                </div>
                            </div>
                </form>
            </div>
            <script>
                $(document).ready(function () {
                    $('#cpf').blur(function () {
                        var cpf = $(this).val();
                        if (validarCPF(cpf)) {
                            $.ajax({
                                url: 'verificarCPF.jsp?cpf=' + cpf,
                                success: function (response) {
                                    if (response == 'true') {
                                        $('#cpfError').text('CPF já cadastrado.');
                                    } else {
                                        $('#cpfError').text('');
                                    }
                                }
                            });
                        } else {
                            $('#cpfError').text('CPF inválido.');
                        }
                    });
                });

                // Função para validar o nome
                function validarNome() {
                    var nome = document.getElementById('nome').value;
                    var palavras = nome.split(' ');
                    if (palavras.length < 2) {
                        alert('O nome deve conter pelo menos duas palavras.');
                        return false;
                    }
                    for (var i = 0; i < palavras.length; i++) {
                        if (palavras[i].length < 3) {
                            alert('Cada palavra do nome deve ter pelo menos três letras.');
                            return false;
                        }
                    }
                    return true;
                }

                // Adiciona um listener para o evento de envio do formulário
                document.querySelector('form').addEventListener('submit', function (event) {
                    if (!validarNome()) {
                        event.preventDefault(); // Evita o envio do formulário se a validação do nome falhar
                    }
                });
            </script>
            <script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                                        crossorigin="anonymous"></script>
        </body>

        </html>