package com.ph3.form.grupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.GrupoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class EliminarGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idGrupo"));
        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        grupoDAO.borrar(grupoDAO.buscarPorClave(id));
        request.setAttribute("listaDeGrupos", grupoDAO.buscarTodos());
        return "protegido/admin/form/grupos/mostrarGrupos.jsp";
    }

}
