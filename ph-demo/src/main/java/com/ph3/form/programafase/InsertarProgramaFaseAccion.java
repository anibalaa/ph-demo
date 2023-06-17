package com.ph3.form.programafase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.ProgramaFase;

public class InsertarProgramaFaseAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        ProgramaFaseDAO programaFaseDAO = DAOFactory.getProgramaFaseDAO();
        ProgramaFase programaFase = new ProgramaFase(null, null);
        programaFaseDAO.insertar(programaFase);
        request.setAttribute("listaDeProgramaFases", programaFaseDAO.buscarTodos());
        return "protegido/admin/form/programafases/mostrarProgramaFases.jsp";
    }

}
