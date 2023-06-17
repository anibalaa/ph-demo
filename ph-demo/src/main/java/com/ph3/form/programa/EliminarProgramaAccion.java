package com.ph3.form.programa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class EliminarProgramaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idPrograma"));
        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        programaDAO.borrar(programaDAO.buscarPorClave(id));
        request.setAttribute("listaDeProgramas", programaDAO.buscarTodos());
        return "protegido/admin/form/programas/mostrarProgramas.jsp";
    }

}
