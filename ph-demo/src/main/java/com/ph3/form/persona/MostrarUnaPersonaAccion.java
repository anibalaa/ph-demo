package com.ph3.form.persona;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.vo.Persona;
import com.ph3.util.Accion;
import com.ph3.util.Consola;
import com.ph3.util.DAOFactory;

public class MostrarUnaPersonaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Persona> listaDePersonas = null;
        listaDePersonas = DAOFactory.getPersonaDAO().buscarTodos();
        request.getSession().setAttribute("listaDePersonas", listaDePersonas);
        
        Consola c = new Consola();
        c.mostrarMapas(request);
        c = null;
        
        return "protegido/admin/form/personas/mostrarUnaPersona.jsp";
    }

}