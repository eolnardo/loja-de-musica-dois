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
    <link rel="stylesheet" href="static/css/cliente.css">
    <link rel="shortcut icon" href="static/images/cd.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<nav class="navbar">
    <a href="/carregar-tela-inicial">
        <div class="left-navbar">
            <img  src="static/images/cd.ico" alt="Logo">
            <h1 class="mt-2">Tialejo ®</h1>
        </div>
    </a>
    <div class="right-navbar">
        <form action="encontrar-todos-produtos" method="get">
            <button  class="btn mt-4" style="z-index: 999">Voltar</button>
        </form>
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

<body style="background-color: #b7bafd;">

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
                    <input type="text" id="nome" name="nome" value="${param.nome}" maxlength="200" required><br><br>
                </div>
                <div class="input-box">
                    <label for="avaliacao">Avaliação:</label>
                    <input type="number" id="avaliacao" name="avaliacao" value="${param.avaliacao}" min="1" max="5" step="0.5" required><br><br>
                </div>
                <div class="input-box">
                    <label for="descricao">Descrição:</label>
                    <textarea id="descricao" name="descricao" maxlength="2000" required>${param.descricao}</textarea><br><br>
                </div>
                <div class="input-box">
                    <label for="preco">Preço:</label>
                    <input type="number" id="preco" name="preco" value="${param.preco}" min="0" step="0.01" required><br><br>
                </div>
                <div class="input-box">
                    <label for="qtdEstoque">Quantidade em Estoque:</label>
                    <input type="number" id="qtdEstoque" name="qtdEstoque" value="${param.qtdEstoque}" min="0" step="1" required><br><br>
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
