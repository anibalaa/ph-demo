package com.ph3.form.programa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;
import com.ph3.util.Accion;

public class InsertarProgramaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String descripcion = request.getParameter("descripcion");

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa ep = new Programa(descripcion, null, null, null);
        programaDAO.insertar(ep);
        request.setAttribute("listaDeProgramas", programaDAO.buscarTodos());
        return "protegido/admin/form/programas/mostrarProgramas.jsp";
    }
}
