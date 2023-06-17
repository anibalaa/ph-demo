package com.ph3.form.motivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.MotivoDAO;
import com.ph3.util.DAOFactory;

public class EliminarMotivoAccion extends com.ph3.util.Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idMotivo"));
        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        motivoDAO.borrar(motivoDAO.buscarPorClave(id));
        request.setAttribute("listaDeMotivos", motivoDAO.buscarTodos());
        return "protegido/admin/form/motivos/mostrarMotivos.jsp";
    }
}