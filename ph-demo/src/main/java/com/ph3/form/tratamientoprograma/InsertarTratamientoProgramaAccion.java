package com.ph3.form.tratamientoprograma;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.TratamientoPrograma;

public class InsertarTratamientoProgramaAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        TratamientoProgramaDAO tratamientoProgramaDAO = DAOFactory.getTratamientoProgramaDAO();
        TratamientoPrograma tratamientoPrograma = new TratamientoPrograma(null, null);
        tratamientoProgramaDAO.insertar(tratamientoPrograma);
        request.setAttribute("listaDeTratamientoProgramas", tratamientoProgramaDAO.buscarTodos());
        return "protegido/admin/form/tratamientoprogramas/mostrarTratamientoProgramas.jsp";
    }
}
