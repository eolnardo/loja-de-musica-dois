package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter({"/admin/*"})
public class FiltroAutenticacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (isUserLoggedOn(httpServletRequest)) {

            servletRequest.setAttribute("message", "Usuário não autenticado!");

            servletRequest.getRequestDispatcher("/backoffice.jsp").forward(httpServletRequest, servletResponse);

        } else {
            isUserAdmin(httpServletRequest);
            chain.doFilter(servletRequest, servletResponse);

        }

    }

    @Override
    public void destroy() { }

    private boolean isUserLoggedOn(HttpServletRequest httpServletRequest) {

        return  httpServletRequest.getSession().getAttribute("loggedUsuario") == null;

    }

    private boolean isUserAdmin(HttpServletRequest httpServletRequest) {

        return  httpServletRequest.getSession().getAttribute("admin") == null;

    }

}