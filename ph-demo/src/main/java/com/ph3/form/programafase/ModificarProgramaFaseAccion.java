package com.ph3.form.programafase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarProgramaFaseAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idProgramaFase"));
        ProgramaFaseDAO programaFaseDAO = DAOFactory.getProgramaFaseDAO();
        request.getSession().setAttribute("unProgramaFase", programaFaseDAO.buscarPorClave(id));
        System.out.println(programaFaseDAO.buscarPorClave(id));
        return "protegido/admin/form/programafases/modificarProgramaFase.jsp";
    }

}
