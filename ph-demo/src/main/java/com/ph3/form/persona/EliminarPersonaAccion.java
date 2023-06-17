package com.ph3.form.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;
import com.ph3.vo.Persona;

@SuppressWarnings("unused")
public class EliminarPersonaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idPersona"));
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        personaDAO.borrar(personaDAO.buscarPorClave(id));
        request.setAttribute("listaDePersonas", personaDAO.buscarTodos());
        return "protegido/admin/form/personas/mostrarPersonas.jsp";
    }
}
