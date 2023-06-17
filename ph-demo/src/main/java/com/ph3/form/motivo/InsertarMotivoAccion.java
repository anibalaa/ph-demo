package com.ph3.form.motivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.MotivoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;

public class InsertarMotivoAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String descripcion = request.getParameter("descripcion");
        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        Motivo ep = new Motivo(descripcion, null);
        motivoDAO.insertar(ep);
        request.setAttribute("listaDeMotivos", motivoDAO.buscarTodos());
        return "protegido/admin/form/motivos/mostrarMotivos.jsp";
    }
}
