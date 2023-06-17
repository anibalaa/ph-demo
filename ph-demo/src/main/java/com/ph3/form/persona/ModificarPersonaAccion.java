package com.ph3.form.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class ModificarPersonaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer idPersona = Integer.parseInt(request.getParameter("idPersona").trim());
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        request.getSession().setAttribute("unaPersona", personaDAO.buscarPorClave(idPersona));
        return "protegido/admin/form/personas/modificarPersona.jsp";
    }

}
