package com.ph3.form.programa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarProgramaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idPrograma"));
        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        request.getSession().setAttribute("unPrograma", programaDAO.buscarPorClave(id));
        System.out.println(programaDAO.buscarPorClave(id));
        return "protegido/admin/form/programas/modificarPrograma.jsp";
    }

}
