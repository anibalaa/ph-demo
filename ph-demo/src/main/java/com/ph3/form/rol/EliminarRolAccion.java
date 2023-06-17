package com.ph3.form.rol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RolDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class EliminarRolAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idRol"));
        RolDAO rolDAO = DAOFactory.getRolDAO();
        rolDAO.borrar(rolDAO.buscarPorClave(id));
        request.setAttribute("listaDeRoles", rolDAO.buscarTodos());
        return "protegido/admin/form/roles/mostrarRoles.jsp";
    }

}
