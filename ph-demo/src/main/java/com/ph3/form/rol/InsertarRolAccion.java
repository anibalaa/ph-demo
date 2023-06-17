package com.ph3.form.rol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RolDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Rol;

public class InsertarRolAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String descripcion = request.getParameter("descripcion");

        RolDAO rolDAO = DAOFactory.getRolDAO();
        Rol ep = new Rol(descripcion, null, null);
        rolDAO.insertar(ep);
        request.setAttribute("listaDeRoles", rolDAO.buscarTodos());
        return "protegido/admin/form/roles/mostrarRoles.jsp";
    }
}
