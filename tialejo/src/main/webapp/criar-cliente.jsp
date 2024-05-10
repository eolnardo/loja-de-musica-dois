<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="pt-BR" xmlns:th="http://www.w3.org/1999/xhtml">


<head>
    <title>Tialejo ® - Cadastrar-se</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="shortcut icon" href="img/cd.ico" type="image/x-icon">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery UI -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- Adicione este script dentro da seção <head> do seu arquivo JSP -->
    <script>
        function consultarCEP(cep, endereco) {
            // Fazendo a requisição AJAX para o endpoint da API do Postmon
            $.ajax({
                url: "https://api.postmon.com.br/v1/cep/" + cep,
                type: "GET",
                dataType: "json",
                success: function(response) {
                    // Manipulando a resposta da API
                    // Aqui você pode acessar os dados do CEP na variável 'response'
                    // Por exemplo: response.logradouro, response.bairro, response.cidade, response.estado, etc.
                    document.getElementById(endereco).value = cep + ', ' + response.logradouro + ', ' + response.bairro + ', ' + response.cidade + ' - ' + response.estado;
                },
                error: function(xhr, status, error) {
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
<body>
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img  src="static/img/cd.ico" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <div class="right-navbar">
    </div>
</nav>
<section class="content">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5" style="max-wid 50%; margin-left: auto; margin-right: auto;">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">

                    <h4 class="mb-3 pb-3">Cadastrar-se</h4>
                    <div class="form">
                        <form action="criar-cliente" method="post">
                            <div class="form-header">
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
                                    <label for="dataNascimento">Data de Nascimento:</label>
                                    <input type="text" id="dataNascimento" name="dataNascimento" value="${param.dataNascimento}" readonly><br><br>
                                </div>
                                <script>
                                    $( function() {
                                        $( "#dataNascimento" ).datepicker();
                                    } );
                                </script>
                                <div class="input-box">
                                    <label for="cepFaturamento">CEP do Endereço de Faturamento:</label>
                                    <input type="text" id="cepFaturamento" name="cepFaturamento" value="${param.cepFaturamento}" required>
                                    <button type="button" onclick="consultarCEP(document.getElementById('cepFaturamento').value, 'enderecoFaturamento')">Consultar</button>
                                    <br><br>
                                </div>
                                <div class="input-box">
                                    <label for="enderecoFaturamento">Endereço de Faturamento:</label>
                                    <input type="text" id="enderecoFaturamento" name="enderecoFaturamento" value="${param.enderecoFaturamento}" readonly>
                                    <br><br>
                                </div>
                                <div class="input-box">
                                    <label for="complementoFaturamento">Complemento do Endereço de Faturamento:</label>
                                    <input type="text" id="complementoFaturamento" name="complementoFaturamento"><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="cepEntrega">CEP do Endereço de Entrega:</label>
                                    <input type="text" id="cepEntrega" name="cepEntrega" value="${param.cepEntrega}" required>
                                    <button type="button" onclick="consultarCEP(document.getElementById('cepEntrega').value, 'enderecoEntrega')">Consultar</button>
                                    <br><br>
                                </div>

                                <div class="input-box">
                                    <label for="enderecoEntrega">Endereço de Entrega:</label>
                                    <button type="button" onclick="copiarEndereco()">Copiar Endereço de Faturamento</button>
                                    <input type="text" id="enderecoEntrega" name="enderecoEntrega" value="${param.enderecoEntrega}" required><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="complementoEntrega">Complemento do Endereço de Entrega:</label>
                                    <input type="text" id="complementoEntrega" name="complementoEntrega"><br><br>
                                </div>
                                <div class="input-box">
                                    <label for="cpf">CPF:</label>
                                    <input type="text" id="cpf" name="cpf" value="${param.cpf}" maxlength="14" required>
                                    <span id="cpfError" style="color: red;"></span>
                                    <br><br>
                                </div>
                                <div class="input-box">
                                    <label for="genero">Gênero:</label>
                                    <select id="genero" name="genero" required>
                                        <option value="" disabled selected>Selecione o gênero</option>
                                        <option value="Homem">Homem</option>
                                        <option value="Mulher">Mulher</option>
                                        <option value="Outro">Outro</option>
                                        <option value="Prefiro não dizer">Outro</option>

                                    </select>
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
    document.querySelector('form').addEventListener('submit', function(event) {
        if (!validarNome()) {
            event.preventDefault(); // Evita o envio do formulário se a validação do nome falhar
        }
    });
</script>
</body>
</html>
