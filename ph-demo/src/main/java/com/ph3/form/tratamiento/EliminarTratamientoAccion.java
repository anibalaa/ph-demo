package com.ph3.form.tratamiento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.TratamientoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class EliminarTratamientoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idTratamiento"));
        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        tratamientoDAO.borrar(tratamientoDAO.buscarPorClave(id));
        request.setAttribute("listaDeTratamientos", tratamientoDAO.buscarTodos());
        return "protegido/admin/form/tratamientos/mostrarTratamientos.jsp";
    }

}
