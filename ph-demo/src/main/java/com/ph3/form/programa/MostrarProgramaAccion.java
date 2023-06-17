package com.ph3.form.programa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;

public class MostrarProgramaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Programa> listaDeProgramas = null;
        listaDeProgramas = DAOFactory.getProgramaDAO().buscarTodos();
        request.setAttribute("listaDeProgramas", listaDeProgramas);
        return "protegido/admin/form/programas/mostrarProgramas.jsp";
    }

}
