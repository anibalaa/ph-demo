package com.ph3.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private DAOFactory df;
    

    public Controlador() {
        super();
        df = new DAOFactory();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        String url = request.getServletPath();
        Accion accion = null;
        accion = Accion.getAccion(getNombreAccion(url));
        despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
        despachador.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String getNombreAccion(String url) {
        return url.substring(1, url.length() - 3);
    }
}
