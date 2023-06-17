package com.ph3.form.tratamientoprograma;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Tratamiento;
import com.ph3.vo.TratamientoPrograma;

public class RelacionarTratamientoProgramaAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        List <Tratamiento> listaDeTratamientos = DAOFactory.getTratamientoDAO().buscarTodos();
        request.getSession().setAttribute("listaDeTratamientos", listaDeTratamientos);
        
        List <TratamientoPrograma> listaDeTratamientoProgramas = DAOFactory.getTratamientoProgramaDAO().buscarTodos();
        request.getSession().setAttribute("listaDeTratamientoProgramas", listaDeTratamientoProgramas);
        
        
        request.getSession().setAttribute("idTratamiento", "10");

        return "protegido/admin/form/tratamientoprogramas/mostrarTratamientoProgramaRelacionados.jsp";
    }

}
