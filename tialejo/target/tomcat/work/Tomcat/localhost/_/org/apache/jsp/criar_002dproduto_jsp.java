/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-05-24 23:31:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class criar_002dproduto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Tialejo ® - Criar Produto</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://unicons.iconscout.com/release/v2.1.9/css/unicons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/carrossel.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/cliente.css\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"static/images/cd.ico\" type=\"image/x-icon\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"\r\n");
      out.write("          integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\"\r\n");
      out.write("          crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<nav class=\"navbar\">\r\n");
      out.write("    <a href=\"/carregar-tela-inicial\">\r\n");
      out.write("        <div class=\"left-navbar\">\r\n");
      out.write("            <img  src=\"static/images/cd.ico\" alt=\"Logo\">\r\n");
      out.write("            <h1 class=\"mt-2\">Tialejo ®</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("    </a>\r\n");
      out.write("    <div class=\"right-navbar\">\r\n");
      out.write("        <form action=\"encontrar-todos-produtos\" method=\"get\">\r\n");
      out.write("            <button  class=\"btn mt-4\" style=\"z-index: 999\">Voltar</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <c:choose>\r\n");
      out.write("            <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loggedUsuario != null}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                <a href=\"/logout-cliente\" class=\"btn mt-4\" style=\"z-index: 999\">Sair</a>\r\n");
      out.write("            </c:when>\r\n");
      out.write("            <c:otherwise>\r\n");
      out.write("                <a href=\"/login-cliente\" class=\"btn mt-4\" style=\"z-index: 999\">Login</a>\r\n");
      out.write("            </c:otherwise>\r\n");
      out.write("        </c:choose>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<body style=\"background-color: #b7bafd;\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"form-image\">\r\n");
      out.write("        <img src=\"assets/images/undraw_Dog_walking_re_l61p.png\" alt=\"\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form\">\r\n");
      out.write("        <form action=\"criar-produto\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <div class=\"form-header\">\r\n");
      out.write("                <div class=\"title\">\r\n");
      out.write("                    <h1>Cadastrar Produto</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <label for=\"nome\">Nome:</label>\r\n");
      out.write("                    <input type=\"text\" id=\"nome\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" maxlength=\"200\" required><br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <label for=\"avaliacao\">Avaliação:</label>\r\n");
      out.write("                    <input type=\"number\" id=\"avaliacao\" name=\"avaliacao\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.avaliacao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" min=\"1\" max=\"5\" step=\"0.5\" required><br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <label for=\"descricao\">Descrição:</label>\r\n");
      out.write("                    <textarea id=\"descricao\" name=\"descricao\" maxlength=\"2000\" required>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.descricao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea><br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <label for=\"preco\">Preço:</label>\r\n");
      out.write("                    <input type=\"number\" id=\"preco\" name=\"preco\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.preco}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" min=\"0\" step=\"0.01\" required><br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <label for=\"qtdEstoque\">Quantidade em Estoque:</label>\r\n");
      out.write("                    <input type=\"number\" id=\"qtdEstoque\" name=\"qtdEstoque\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.qtdEstoque}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" min=\"0\" step=\"1\" required><br><br>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <label for=\"image\">Upload de imagem</label>\r\n");
      out.write("                    <input type=\"file\" name=\"image\" id=\"image\" accept=\"image/png, image/jpeg\" onchange=\"previewImage(event)\"/>\r\n");
      out.write("                    <img id=\"preview\" src=\"#\" alt=\"Prévia da imagem\" style=\"max-width: 300px; max-height: 200px; display: none;\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <input type=\"hidden\" id=\"id\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"cadastrar-button\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <button class=\"botao azul\" ><a class=\"azul\" href=\"index.jsp\">Voltar</a></button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <button type=\"submit\" class=\"botao verde\" style=\"margin-left: 10px\">Cadastrar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"assets/js/menu.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function previewImage(event) {\r\n");
      out.write("        var input = event.target;\r\n");
      out.write("        var preview = document.getElementById(\"preview\");\r\n");
      out.write("\r\n");
      out.write("        if (input.files && input.files[0]) {\r\n");
      out.write("            var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("            reader.onload = function (e) {\r\n");
      out.write("                preview.src = e.target.result;\r\n");
      out.write("                preview.style.display = \"block\";\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            reader.readAsDataURL(input.files[0]);\r\n");
      out.write("        } else {\r\n");
      out.write("            preview.src = \"#\";\r\n");
      out.write("            preview.style.display = \"none\";\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
