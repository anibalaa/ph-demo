package com.ph3.form.motivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.MotivoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;

public class SalvarMotivoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idMotivo"));
        String descripcion = request.getParameter("descripcion");
        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        Motivo unMotivo = motivoDAO.buscarPorClave(id);
        unMotivo.setDescripcion(descripcion);
        motivoDAO.salvar(unMotivo);
        request.setAttribute("listaDeMotivos", motivoDAO.buscarTodos());
        return "protegido/admin/form/motivos/mostrarMotivos.jsp";
    }
}
