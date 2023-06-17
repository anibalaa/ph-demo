package com.ph3.form.agrupacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;

public class MostrarMenuAgrupacionAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        return "protegido/admin/form/agrupaciones/mostrarMenuAgrupacion.jsp";
    }

}

