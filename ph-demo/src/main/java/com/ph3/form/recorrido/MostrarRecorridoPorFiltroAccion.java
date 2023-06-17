package com.ph3.form.recorrido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RecorridoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;

public class MostrarRecorridoPorFiltroAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        Persona persona = DAOFactory.getPersonaDAO().buscarNombreApellido1Apellido2(nombre, apellido1, apellido2);
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        Integer idPersona = null;
        Date fechaInicio = null;
        Date fechaFin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            idPersona = persona.getIdPersona();
            fechaInicio = sdf.parse(request.getParameter("fechaDeInicio"));
            System.out.println("inicio:" + request.getParameter("fechaDeInicio"));
            fechaFin = sdf.parse(request.getParameter("fechaDeFin"));
            System.out.println("fin:" + request.getParameter("fechaDeFin"));
        } catch (ParseException e) {
            System.err.println("Error al parsear fechas o en idPersona");
            e.printStackTrace();
        }

        if (fechaInicio != null && fechaFin != null && idPersona != null) {
            request.setAttribute("listaDeRecorridos", recorridoDAO.buscarRecorridosDeUnaPersonaEntreFechas(idPersona, fechaInicio, fechaFin));
        } else {
            request.setAttribute("listaDeRecorridos", null);
        }
        return "protegido/admin/form/recorridos/mostrarRecorridos.jsp";
    }

}
