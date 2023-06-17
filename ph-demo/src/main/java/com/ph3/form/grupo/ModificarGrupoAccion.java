package com.ph3.form.grupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.GrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idGrupo"));
        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        request.getSession().setAttribute("unGrupo", grupoDAO.buscarPorClave(id));
        System.out.println(grupoDAO.buscarPorClave(id));
        return "protegido/admin/form/grupos/modificarGrupo.jsp";
    }
}
