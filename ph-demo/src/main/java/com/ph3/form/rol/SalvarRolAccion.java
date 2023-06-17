package com.ph3.form.rol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RolDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Rol;

public class SalvarRolAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idRol"));

        String descripcion = request.getParameter("descripcion");

        RolDAO rolDAO = DAOFactory.getRolDAO();
        Rol unRol = rolDAO.buscarPorClave(id);
        unRol.setDescripcion(descripcion);

        rolDAO.salvar(unRol);
        request.setAttribute("listaDeRoles", rolDAO.buscarTodos());
        return "protegido/admin/form/roles/mostrarRoles.jsp";
    }

}
