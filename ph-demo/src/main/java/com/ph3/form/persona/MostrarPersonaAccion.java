package com.ph3.form.persona;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;
import com.ph3.util.Accion;

public class MostrarPersonaAccion extends Accion {

    
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Persona> listaDePersonas = null;
        listaDePersonas = DAOFactory.getPersonaDAO().buscarTodos();
        request.setAttribute("listaDePersonas", listaDePersonas);
        return "protegido/admin/form/personas/mostrarPersonas.jsp";
    }

}
