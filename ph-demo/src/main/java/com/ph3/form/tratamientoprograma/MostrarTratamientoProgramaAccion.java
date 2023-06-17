package com.ph3.form.tratamientoprograma;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.TratamientoPrograma;

public class MostrarTratamientoProgramaAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<TratamientoPrograma> listaDeTratamientoProgramas = null;
        listaDeTratamientoProgramas = DAOFactory.getTratamientoProgramaDAO().buscarTodos();
        request.setAttribute("listaDeTratamientoProgramas", listaDeTratamientoProgramas);
        return "protegido/admin/form/tratamientoprogramas/mostrarTratamientoProgramas.jsp";
    }

}
