package com.ph3.form.programa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.ProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;

public class SalvarProgramaAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idPrograma"));

        String descripcion = request.getParameter("descripcion");

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa unPrograma = programaDAO.buscarPorClave(id);
        unPrograma.setDescripcion(descripcion);

        programaDAO.salvar(unPrograma);
        request.setAttribute("listaDeProgramas", programaDAO.buscarTodos());
        return "protegido/admin/form/programas/mostrarProgramas.jsp";
    }

}
