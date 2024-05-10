<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tialejo ® - Criar Produto</title>
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

    <style>
        .error-message {
            color: #ff0000;
            font-size: 12px;
            margin-top: 5px;
        }

        .form-group.error input.form-style {
            border: 1px solid #ff0000;
            background-color: #ffe6e6;
        }

        .error {
            border: 1px solid #ff0000;
            background-color: #ffe6e6;
        }
    </style>

</head>

<body style="background-color: #b7bafd;">
<div class="navbar">
    <img src="assets/images/pegada.png" alt="petprotectors-logo" style="height: 50px;">
    <a href="index.jsp" class="navbar-brand" style="background-color: #1E1D67;">Pet Protectors</a>
    <ul class="navbar-menu"></ul>
</div>

<div class="container">
    <div class="form-image">
        <img src="assets/images/undraw_Dog_walking_re_l61p.png" alt="">
    </div>
    <div class="form">
        <form action="criar-produto" method="post" enctype="multipart/form-data">
            <div class="form-header">
                <div class="title">
                    <h1>Cadastrar Produto</h1>
                </div>
            </div>
            <div class="input-group">

                <div class="input-box">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" value="${param.nome}" required><br><br>
                </div>
                <div class="input-box">
                    <label for="avaliacao">Avaliação:</label>
                    <input type="text" id="avaliacao" name="avaliacao" value="${param.avaliacao}" min="1" max="5" step="0.5" required><br><br>
                </div>
                <div class="input-box">
                    <label for="descricao">Descrição:</label>
                    <input type="text" id="descricao" name="descricao" value="${param.descricao}" required><br><br>
                </div>
                <div class="input-box">
                    <label for="preco">Preço:</label>
                    <input type="text" id="preco" name="preco" value="${param.preco}" required><br><br>
                </div>
                <div class="input-box">
                    <label for="qtdEstoque">Quantiade em Estoque:</label>
                    <input type="text" id="qtdEstoque" name="qtdEstoque" value="${param.qtdEstoque}" required><br><br>
                </div>
                <div>
                    <label for="image">Upload de imagem</label>
                    <input type="file" name="image" id="image" accept="image/png, image/jpeg" onchange="previewImage(event)"/>
                    <img id="preview" src="#" alt="Prévia da imagem" style="max-width: 300px; max-height: 200px; display: none;"/>
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

<script src="assets/js/menu.js"></script>

<script>
    function previewImage(event) {
        var input = event.target;
        var preview = document.getElementById("preview");

        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                preview.src = e.target.result;
                preview.style.display = "block";
            };

            reader.readAsDataURL(input.files[0]);
        } else {
            preview.src = "#";
            preview.style.display = "none";
        }
    }
</script>

</body>
</html>
