package com.ph3.form.motivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.MotivoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarMotivoAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idMotivo"));
        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        request.getSession().setAttribute("unMotivo", motivoDAO.buscarPorClave(id));
        System.out.println(motivoDAO.buscarPorClave(id));
        return "protegido/admin/form/motivos/modificarMotivo.jsp";
    }
}
