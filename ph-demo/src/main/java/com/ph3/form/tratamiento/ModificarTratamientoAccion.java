package com.ph3.form.tratamiento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.TratamientoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarTratamientoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idTratamiento"));
        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        request.getSession().setAttribute("unTratamiento", tratamientoDAO.buscarPorClave(id));
        return "protegido/admin/form/tratamientos/modificarTratamiento.jsp";
    }

}
