package com.ph3.form.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;
import com.ph3.util.Accion;

public class InsertarPersonaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();
        String activo = request.getParameter("activo");

        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona persona = new Persona(nombre, apellido1, apellido2, activo, null, null);
        personaDAO.insertar(persona);
        request.setAttribute("listaDePersonas", personaDAO.buscarTodos());
        return "protegido/admin/form/personas/mostrarPersonas.jsp";
    }

}
