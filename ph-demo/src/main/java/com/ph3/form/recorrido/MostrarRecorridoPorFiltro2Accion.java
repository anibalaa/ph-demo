package com.ph3.form.recorrido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RecorridoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class MostrarRecorridoPorFiltro2Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        Integer idMotivo = Integer.valueOf(request.getParameter("motivo"));
        Date fechaInicio = null;
        Date fechaFin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            fechaInicio = sdf.parse(request.getParameter("fechaDeInicio"));
            System.out.println("inicio:" + request.getParameter("fechaDeInicio"));
            fechaFin = sdf.parse(request.getParameter("fechaDeFin"));
            System.out.println("fin:" + request.getParameter("fechaDeFin"));
        } catch (ParseException e) {
            System.err.println("Error al parsear fechas o en idPersona");
            e.printStackTrace();
        }

        if (fechaInicio != null && fechaFin != null && idMotivo != null) {
            request.setAttribute("listaDeRecorridos", recorridoDAO.buscarRecorridosPorMotivoEntreFechas(idMotivo, fechaInicio, fechaFin));
        } else {
            request.setAttribute("listaDeRecorridos", null);
        }
        return "protegido/admin/form/recorridos/mostrarRecorridos.jsp";
    }

}
