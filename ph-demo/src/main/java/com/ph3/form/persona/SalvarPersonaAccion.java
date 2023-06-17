package com.ph3.form.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;

public class SalvarPersonaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer idPersona = Integer.parseInt(request.getParameter("idPersona").trim());

        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();

        String activo = null;
        //System.out.println(request.getParameter("activo").trim() );
        if (request.getParameter("activo") != null) {
            System.out.println("Entramos en activo != null");
            activo = request.getParameter("activo").trim();
        } else {
            System.out.println("Entramos en activo = 0");
            activo = "0";
        }
        
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona persona = personaDAO.buscarPorClave(idPersona);

        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);

        try {
            persona.setActivo(activo);
        } catch (Exception e) {
            System.err.println("Error en activo");
            e.printStackTrace();
        }

        personaDAO.salvar(persona);

        request.setAttribute("listaDePersonas", personaDAO.buscarTodos());
        return "protegido/admin/form/personas/mostrarPersonas.jsp";
    }

}
