package com.ph3.form.recorrido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Recorrido;

public class MostrarUnRecorrido2Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        // Integer idRecorrido = Integer.parseInt(request.getParameter("idRecorrido"));
        // Integer idPersona = Integer.parseInt(request.getParameter("idPersona"));
        // Integer idTratamiento = Integer.parseInt(request.getParameter("idTratamiento"));
        // Integer idPrograma = Integer.parseInt(request.getParameter("idPrograma"));
        // Integer idFase = Integer.parseInt(request.getParameter("idFase"));
        // Integer idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        // System.err.println("valor de idRecorrido: " + idRecorrido);
        // System.err.println("valor de idPersona: " + idPersona);
        // System.err.println("valor de idTratamiento: " + idTratamiento);
        // System.err.println("valor de idPrograma: " + idPrograma);
        // System.err.println("valor de idFase: " + idFase);
        // System.err.println("valor de idGrupo: " + idGrupo);
        // // Recorrido recorrido = DAOFactory.getRecorridoDAO().buscarPorClave(idRecorrido);
        // Recorrido recorrido = DAOFactory.getRecorridoDAO().buscarPorPersonaTratamientoProgramaFaseYGrupo(DAOFactory.getPersonaDAO().buscarPorClave(idPersona), idTratamiento, idPrograma, idFase,
        // idGrupo);
        // request.getSession().setAttribute("recorrido", recorrido);
        Integer idRecorrido = Integer.valueOf(request.getParameter("idRecorrido"));
        System.out.println("id de recorrido: " + idRecorrido);

        Recorrido recorrido = DAOFactory.getRecorridoDAO().buscarPorClave(idRecorrido);
        request.getSession().setAttribute("recorrido", recorrido);

        return "protegido/admin/form/recorridos/mostrar_recorrido_valores.jsp";
    }
}
