package com.ph3.form.tratamiento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.TratamientoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Tratamiento;

public class InsertarTratamientoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String descripcion = request.getParameter("descripcion");

        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        Tratamiento ep = new Tratamiento(descripcion, null, null);
        tratamientoDAO.insertar(ep);
        request.setAttribute("listaDeTratamientos", tratamientoDAO.buscarTodos());
        return "protegido/admin/form/tratamientos/mostrarTratamientos.jsp";
    }
}
