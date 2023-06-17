package com.ph3.form.persona;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.TratamientoPrograma;

public class InsertarPersonaRecorrido2Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        List<TratamientoPrograma> listaDeTratamientos = null;
        listaDeTratamientos = DAOFactory.getTratamientoProgramaDAO().buscarTratamientosExistentes();
        request.setAttribute("listaDeTratamientos", listaDeTratamientos);
        return "protegido/admin/form/ingresos/ingresarPersonaRecorrido.jsp";
    }

}
