package com.ph3.form.grupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.GrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Grupo;

public class InsertarGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String descripcion = request.getParameter("descripcion");
        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        Grupo ep = new Grupo(descripcion, null, null);
        grupoDAO.insertar(ep);
        request.setAttribute("listaDeGrupos", grupoDAO.buscarTodos());
        return "protegido/admin/form/grupos/mostrarGrupos.jsp";
    }
}
