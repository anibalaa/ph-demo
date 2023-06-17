package com.ph3.form.tratamiento;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Tratamiento;

public class MostrarTratamientoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Tratamiento> listaDeTratamientos = null;
        listaDeTratamientos = DAOFactory.getTratamientoDAO().buscarTodos();
        request.setAttribute("listaDeTratamientos", listaDeTratamientos);
        return "protegido/admin/form/tratamientos/mostrarTratamientos.jsp";
    }

}
