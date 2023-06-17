package com.ph3.form.tratamientoprograma;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarTratamientoProgramaAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idTratamientoPrograma"));
        TratamientoProgramaDAO tratamientoProgramaDAO = DAOFactory.getTratamientoProgramaDAO();
        request.getSession().setAttribute("unTratamientoPrograma", tratamientoProgramaDAO.buscarPorClave(id));
        System.out.println(tratamientoProgramaDAO.buscarPorClave(id));
        return "protegido/admin/form/tratamientoprogramas/modificarTratamientoPrograma.jsp";
    }

}
