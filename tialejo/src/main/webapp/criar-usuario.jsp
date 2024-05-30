<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Tialejo ® - Criar Usuario</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        integrity="sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="static/css/style.css">
  <link rel="shortcut icon" href="img/cd.ico" type="image/x-icon">
</head>

<body>
<section class="content">
  <div class="container">
    <div class="row full-height">
      <div class="col-12   py-5">
        <div class="section pb-5 pt-5 pt-sm-2">
          <h4 class="mb-3 pb-3">Cadastre-se</h4>
          <form action="/criar-usuario" method="post">
            <div class="form-header"></div>
            <div class="input-group">
              <div class="input-box">
                <label for="nome">Nome Completo:</label>
                <input type="text" id="nome" name="nome" value="${param.nome}" required><br><br>
              </div>

              <div class="input-box">
                <label for="cpf">CPF:</label>
                <input type="text" id="cpf" name="cpf" value="${param.cpf}" required><br><br>
              </div>

              <div class="input-box">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" value="${param.email}" required><br><br>
              </div>

              <div class="input-box">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" value="${param.senha}" required><br><br>
              </div>

              <div class="input-box">
                <label for="confirmaSenha">Confirmar Senha:</label>
                <input type="password" id="confirmaSenha" name="confirmaSenha" value="${param.confirmaSenha}" required><br><br>
              </div>

              <div class="input-box">
                <label for="grupo">Grupo:</label>
                <select id="grupo" name="grupo" required>
                  <option value="" disabled selected>Selecione o grupo</option>
                  <option value="administrador">Administrador</option>
                  <option value="estoquista">Estoquista</option>
                </select>
              </div>
            </div>
            <div class="action-button">
              <a class="botao cinza" href="listar-usuarios.jsp">Voltar</a>
              <button type="submit" class="botao azul" style="margin-left: 10px">Confirmar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>