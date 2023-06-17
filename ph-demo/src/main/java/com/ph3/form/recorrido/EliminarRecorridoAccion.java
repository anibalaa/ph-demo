package com.ph3.form.recorrido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.dao.RecorridoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;
import com.ph3.vo.Recorrido;
import com.ph3.util.Accion;
import com.ph3.util.Chequeo;

public class EliminarRecorridoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer idRecorrido = Integer.parseInt(request.getParameter("idRecorrido"));
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        Persona persona = recorridoDAO.buscarPorClave(idRecorrido).getPersona();
        recorridoDAO.borrar(recorridoDAO.buscarPorClave(idRecorrido));
        
        // buscar en todos los recorridos de una persona si no están activos, en ese caso poner activo 0 en persona
        List<Recorrido> listaDeRecorridos = recorridoDAO.buscarRecorridosDeUnaPersona(persona.getIdPersona());
        Chequeo c = new Chequeo();
        c.buscarRecorridosActivosDeUnaPersona(persona, listaDeRecorridos);
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        personaDAO.salvar(persona);
        
        request.setAttribute("listaDeRecorridos", recorridoDAO.buscarTodos());
        return "protegido/admin/form/recorridos/mostrarRecorridos.jsp";
    }

}
