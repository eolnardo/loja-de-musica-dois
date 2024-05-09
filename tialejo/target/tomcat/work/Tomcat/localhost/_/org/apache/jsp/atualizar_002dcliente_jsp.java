/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-05-09 22:25:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class atualizar_002dcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"pt-BR\" xmlns:th=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Tialejo ® - Atualizar Cadastro</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://unicons.iconscout.com/release/v2.1.9/css/unicons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\"\r\n");
      out.write("          integrity=\"sha512-VuwNeOLQQ1vXtZgTkqK3zUFJAN3Uw8byEUVqyIZJc6DvZ4FYvZMzUKcFE4fsVHmzUchidreL5x5xKWszxiVjQg==\"\r\n");
      out.write("          crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/style.css\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"img/cd.ico\" type=\"image/x-icon\">\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("    <!-- jQuery UI -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Adicione este script dentro da seção <head> do seu arquivo JSP -->\r\n");
      out.write("    <script>\r\n");
      out.write("        function consultarCEP(cep, endereco) {\r\n");
      out.write("            // Fazendo a requisição AJAX para o endpoint da API do Postmon\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"https://api.postmon.com.br/v1/cep/\" + cep,\r\n");
      out.write("                type: \"GET\",\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                success: function(response) {\r\n");
      out.write("                    // Manipulando a resposta da API\r\n");
      out.write("                    // Aqui você pode acessar os dados do CEP na variável 'response'\r\n");
      out.write("                    // Por exemplo: response.logradouro, response.bairro, response.cidade, response.estado, etc.\r\n");
      out.write("                    document.getElementById(endereco).value = cep + ', ' + response.logradouro + ', ' + response.bairro + ', ' + response.cidade + ' - ' + response.estado;\r\n");
      out.write("                },\r\n");
      out.write("                error: function(xhr, status, error) {\r\n");
      out.write("                    // Manipulando erros, se houver algum\r\n");
      out.write("                    console.error('Erro ao consultar CEP:', error);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function validarCPF(cpf) {\r\n");
      out.write("            cpf = cpf.replace(/[^\\d]+/g, '');\r\n");
      out.write("            if (cpf == '') return false;\r\n");
      out.write("            // Elimina CPFs invalidos conhecidos\r\n");
      out.write("            if (cpf.length != 11 ||\r\n");
      out.write("                cpf == '00000000000' ||\r\n");
      out.write("                cpf == '11111111111' ||\r\n");
      out.write("                cpf == '22222222222' ||\r\n");
      out.write("                cpf == '33333333333' ||\r\n");
      out.write("                cpf == '44444444444' ||\r\n");
      out.write("                cpf == '55555555555' ||\r\n");
      out.write("                cpf == '66666666666' ||\r\n");
      out.write("                cpf == '77777777777' ||\r\n");
      out.write("                cpf == '88888888888' ||\r\n");
      out.write("                cpf == '99999999999')\r\n");
      out.write("                return false;\r\n");
      out.write("            // Valida 1o digito\r\n");
      out.write("            add = 0;\r\n");
      out.write("            for (i = 0; i < 9; i++)\r\n");
      out.write("                add += parseInt(cpf.charAt(i)) * (10 - i);\r\n");
      out.write("            rev = 11 - (add % 11);\r\n");
      out.write("            if (rev == 10 || rev == 11)\r\n");
      out.write("                rev = 0;\r\n");
      out.write("            if (rev != parseInt(cpf.charAt(9)))\r\n");
      out.write("                return false;\r\n");
      out.write("            // Valida 2o digito\r\n");
      out.write("            add = 0;\r\n");
      out.write("            for (i = 0; i < 10; i++)\r\n");
      out.write("                add += parseInt(cpf.charAt(i)) * (11 - i);\r\n");
      out.write("            rev = 11 - (add % 11);\r\n");
      out.write("            if (rev == 10 || rev == 11)\r\n");
      out.write("                rev = 0;\r\n");
      out.write("            if (rev != parseInt(cpf.charAt(10)))\r\n");
      out.write("                return false;\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function copiarEndereco() {\r\n");
      out.write("            // Obter os valores do endereço de faturamento\r\n");
      out.write("            var enderecoFaturamento = document.getElementById('enderecoFaturamento').value;\r\n");
      out.write("\r\n");
      out.write("            // Definir os valores do endereço de faturamento nos campos de endereço de entrega\r\n");
      out.write("            document.getElementById('enderecoEntrega').value = enderecoFaturamento;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar\">\r\n");
      out.write("    <a href=\"/carregar-tela-inicial\">\r\n");
      out.write("        <div class=\"left-navbar\">\r\n");
      out.write("            <img  src=\"static/img/cd.ico\" alt=\"Logo\">\r\n");
      out.write("            <h1 class=\"mt-2\">Tialejo ®</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("    </a>\r\n");
      out.write("    <div class=\"right-navbar\">\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<section class=\"content\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row full-height justify-content-center\">\r\n");
      out.write("            <div class=\"col-12 text-center align-self-center py-5\" style=\"max-wid 50%; margin-left: auto; margin-right: auto;\">\r\n");
      out.write("                <div class=\"section pb-5 pt-5 pt-sm-2 text-center\">\r\n");
      out.write("\r\n");
      out.write("                    <h4 class=\"mb-3 pb-3\">Cadastrar-se</h4>\r\n");
      out.write("                    <div class=\"form\">\r\n");
      out.write("                        <form action=\"/atualizar-cadastro-cliente\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-header\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"nome\">Nome:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"nome\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"dataNascimento\">Data de Nascimento:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"dataNascimento\" name=\"dataNascimento\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.dataNascimento}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <script>\r\n");
      out.write("                                    $( function() {\r\n");
      out.write("                                        $( \"#dataNascimento\" ).datepicker();\r\n");
      out.write("                                    } );\r\n");
      out.write("                                </script>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"cepFaturamento\">CEP do Endereço de Faturamento:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"cepFaturamento\" name=\"cepFaturamento\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.cepFaturamento}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required>\r\n");
      out.write("                                    <button type=\"button\" onclick=\"consultarCEP(document.getElementById('cepFaturamento').value, 'enderecoFaturamento')\">Consultar</button>\r\n");
      out.write("                                    <br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"enderecoFaturamento\">Endereço de Faturamento:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"enderecoFaturamento\" name=\"enderecoFaturamento\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.enderecoFaturamento}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly>\r\n");
      out.write("                                    <br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"complementoFaturamento\">Complemento do Endereço de Faturamento:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"complementoFaturamento\" name=\"complementoFaturamento\"><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"cepEntrega\">CEP do Endereço de Entrega:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"cepEntrega\" name=\"cepEntrega\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.cepEntrega}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required>\r\n");
      out.write("                                    <button type=\"button\" onclick=\"consultarCEP(document.getElementById('cepEntrega').value, 'enderecoEntrega')\">Consultar</button>\r\n");
      out.write("                                    <br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"enderecoEntrega\">Endereço de Entrega:</label>\r\n");
      out.write("                                    <button type=\"button\" onclick=\"copiarEndereco()\">Copiar Endereço de Faturamento</button>\r\n");
      out.write("                                    <input type=\"text\" id=\"enderecoEntrega\" name=\"enderecoEntrega\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.enderecoEntrega}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"complementoEntrega\">Complemento do Endereço de Entrega:</label>\r\n");
      out.write("                                    <input type=\"text\" id=\"complementoEntrega\" name=\"complementoEntrega\"><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"genero\">Gênero:</label>\r\n");
      out.write("                                    <select id=\"genero\" name=\"genero\" required>\r\n");
      out.write("                                        <option value=\"\" disabled selected>Selecione o gênero</option>\r\n");
      out.write("                                        <option value=\"Homem\">Homem</option>\r\n");
      out.write("                                        <option value=\"Mulher\">Mulher</option>\r\n");
      out.write("                                        <option value=\"Outro\">Outro</option>\r\n");
      out.write("                                        <option value=\"Prefiro não dizer\">Outro</option>\r\n");
      out.write("\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"senha\">Senha:</label>\r\n");
      out.write("                                    <input type=\"password\" id=\"senha\" name=\"senha\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.senha}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  required><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <label for=\"confirmarSenha\">Confirmar Senha:</label>\r\n");
      out.write("                                    <input type=\"password\" id=\"confirmarSenha\" name=\"confirmarSenha\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.confirmarSenha}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  required><br><br>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"input-box\">\r\n");
      out.write("                                    <input type=\"hidden\" id=\"id\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"cadastrar-button\">\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <button class=\"botao azul\" ><a class=\"azul\" href=\"index.jsp\">Cancelar</a></button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <button type=\"submit\" class=\"botao verde\" style=\"margin-left: 10px\">Confirmar</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $('#cpf').blur(function () {\r\n");
      out.write("            var cpf = $(this).val();\r\n");
      out.write("            if (validarCPF(cpf)) {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: 'verificarCPF.jsp?cpf=' + cpf,\r\n");
      out.write("                    success: function (response) {\r\n");
      out.write("                        if (response == 'true') {\r\n");
      out.write("                            $('#cpfError').text('CPF já cadastrado.');\r\n");
      out.write("                        } else {\r\n");
      out.write("                            $('#cpfError').text('');\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            } else {\r\n");
      out.write("                $('#cpfError').text('CPF inválido.');\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // Função para validar o nome\r\n");
      out.write("    function validarNome() {\r\n");
      out.write("        var nome = document.getElementById('nome').value;\r\n");
      out.write("        var palavras = nome.split(' ');\r\n");
      out.write("        if (palavras.length < 2) {\r\n");
      out.write("            alert('O nome deve conter pelo menos duas palavras.');\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        for (var i = 0; i < palavras.length; i++) {\r\n");
      out.write("            if (palavras[i].length < 3) {\r\n");
      out.write("                alert('Cada palavra do nome deve ter pelo menos três letras.');\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // Adiciona um listener para o evento de envio do formulário\r\n");
      out.write("    document.querySelector('form').addEventListener('submit', function(event) {\r\n");
      out.write("        if (!validarNome()) {\r\n");
      out.write("            event.preventDefault(); // Evita o envio do formulário se a validação do nome falhar\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
