package com.ph3.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.*;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter("/FiltroAdmin")
public class FiltroAdmin implements Filter {

    /**
     * Default constructor.
     */
    public FiltroAdmin() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        boolean permisoRol = false;
        System.out.println("pasa por el dofilter");
        // AUTENTICADO: ¿esta el usuario almacenado en la sesión ?
        boolean logueado = req.getSession() != null && req.getSession().getAttribute("usuarioNombre") != null;

        // AUTORIZADO: ¿ el rol almacenado en la sesión coincide con parte del directorio donde está intentando acceder en la petición ?
        if (req.getSession().getAttribute("Rol") != null)
            if (req.getServletPath().contains((String) req.getSession().getAttribute("Rol")))
                permisoRol = true;

        // Si el usuario está autenticado y autorizado encadena con la petición solicitada porque tiene permiso de acceso
        if (logueado && permisoRol) {
            chain.doFilter(request, response);
            System.out.println("pasa por el chain");

        }

        // Si el usuario esta autenticado pero no autorizado: no tiene permiso de acceso a ese recurso
        if (logueado && !permisoRol) {
            req.getSession().setAttribute("error", "Usuario no autorizado");
            res.sendRedirect(req.getContextPath() + "/error.jsp");
        }

        // Si el usuario no está autenticado: debe loguearse
        if (!logueado) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            System.out.println("pasa por el login");
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}