package com.ph3.form.tratamiento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
//import com.ph3.util.DAOFactory;
//import com.ph3.vo.Tratamiento;

public class MostrarUnTratamientoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
//        Tratamiento unTratamiento = null;
        Integer idPersona = 1;
        System.out.println("idPersona: " + idPersona);
//        unTratamiento = DAOFactory.getTratamientoDAO().buscarTratamientoPorPersona(idPersona);
//        System.out.println("mostrar1movjava: " + unTratamiento.getDescripcion());
//        request.setAttribute("unTratamiento", unTratamiento.getDescripcion());
        return "protegido/admin/form/tratamientos/mostrarUnTratamiento.jsp";
    }

}
