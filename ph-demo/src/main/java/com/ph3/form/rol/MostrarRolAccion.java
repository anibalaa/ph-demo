package com.ph3.form.rol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Rol;

public class MostrarRolAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Rol> listaDeRoles = null;
        listaDeRoles = DAOFactory.getRolDAO().buscarTodos();
        request.setAttribute("listaDeRoles", listaDeRoles);
        return "protegido/admin/form/roles/mostrarRoles.jsp";
    }

}
