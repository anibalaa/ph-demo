package com.ph3.form.rol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RolDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarRolAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idRol"));
        RolDAO rolDAO = DAOFactory.getRolDAO();
        request.getSession().setAttribute("unRol", rolDAO.buscarPorClave(id));
        System.out.println(rolDAO.buscarPorClave(id));
        return "protegido/admin/form/roles/modificarRol.jsp";
    }

}
