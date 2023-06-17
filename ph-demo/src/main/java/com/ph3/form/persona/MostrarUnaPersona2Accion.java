package com.ph3.form.persona;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RecorridoDAO;
import com.ph3.util.Accion;
import com.ph3.util.Consola;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;
import com.ph3.vo.Recorrido;


public class MostrarUnaPersona2Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        List<Recorrido> listaDeRecorridos = null;
        
        Integer idPersona = Integer.valueOf(request.getParameter("idPersona"));
        System.out.println("id de persona: " + idPersona);
        Persona persona = DAOFactory.getPersonaDAO().buscarPorClave(idPersona);
        request.getSession().setAttribute("persona", persona);
        
        listaDeRecorridos = recorridoDAO.buscarRecorridosDeUnaPersona(idPersona);
        request.getSession().setAttribute("listaDeRecorridos", listaDeRecorridos);
        
        Consola c = new Consola();
        c.mostrarMapas(request);
        c = null;

        return "protegido/admin/form/personas/mostrar_persona_valores.jsp";
    }
    
}
