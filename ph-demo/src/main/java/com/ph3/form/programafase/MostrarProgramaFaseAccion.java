package com.ph3.form.programafase;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.ProgramaFase;

public class MostrarProgramaFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<ProgramaFase> listaDeProgramaFases = null;
        listaDeProgramaFases = DAOFactory.getProgramaFaseDAO().buscarTodos();
        request.setAttribute("listaDeProgramaFases", listaDeProgramaFases);
        return "protegido/admin/form/programafases/mostrarProgramaFases.jsp";
    }

}
