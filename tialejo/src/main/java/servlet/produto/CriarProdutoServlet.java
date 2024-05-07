    package servlet.produto;

    import dao.ProdutoDAO;
    import model.Produto;
    import org.apache.commons.fileupload.FileItem;
    import org.apache.commons.fileupload.disk.DiskFileItemFactory;
    import org.apache.commons.fileupload.servlet.ServletFileUpload;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.File;
    import java.io.IOException;
    import java.math.BigDecimal;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

    @WebServlet("/criar-produto")
    public class CriarProdutoServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            Map<String, String> parameters = uploadImage(req);

            String produtoNome = req.getParameter("nome");
            System.out.println("Nome do produto é: " + produtoNome);
            String produtoAvaliacao = req.getParameter("avaliacao");
            String produtoDescricao = req.getParameter("descricao");
            BigDecimal produtoPreco = new BigDecimal(req.getParameter("preco"));
            System.out.println(produtoPreco);
            int produtoqtdEstoque = Integer.parseInt(req.getParameter("qtdEstoque"));
            boolean produtoStatus = Boolean.parseBoolean(req.getParameter("status"));
            String produtoId = req.getParameter("id");
            String produtoImagem = parameters.get("image");

            ProdutoDAO produtoDao = new ProdutoDAO();

            System.out.println(produtoPreco);

            Produto produto = new Produto(produtoId, produtoNome, produtoAvaliacao, produtoDescricao, produtoPreco, produtoqtdEstoque, produtoStatus, produtoImagem);

            System.out.println("oi");

            if (produtoId == null || produtoId.isBlank()) {
                System.out.println(produto);
                produtoDao.criarProduto(produto);
            } else {
                //produtoDao.atualizarProduto(produto);
            }

            System.out.println("tchau");

            resp.sendRedirect("encontrar-todos-produtos");
        }

        private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

            Map<String, String> requestParameters = new HashMap<>();

            if (isMultipartContent(httpServletRequest)) {

                try {

                    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                    List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                    for (FileItem fileItem : fileItems) {

                        checkFieldType(fileItem, requestParameters);

                    }

                } catch (Exception ex) {

                    requestParameters.put("image", "img/default-car.jpg");

                }

            }

            return requestParameters;

        }
        private void checkFieldType(FileItem item, Map requestParameters) throws Exception {

            if (item.isFormField()) {

                requestParameters.put(item.getFieldName(), item.getString());

            } else {

                String fileName = processUploadedFile(item);
                requestParameters.put("image", "img/".concat(fileName));

            }

        }
        private String processUploadedFile(FileItem fileItem) throws Exception {
            Long currentTime = new Date().getTime();
            String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
            String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
            fileItem.write(new File(filePath));
            return fileName;
        }
    }
