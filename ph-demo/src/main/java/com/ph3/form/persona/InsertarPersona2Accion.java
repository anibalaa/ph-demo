package com.ph3.form.persona;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;

public class InsertarPersona2Accion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        return "/protegido/admin/form/personas/insertarPersonas2.jsp";
    }

}
