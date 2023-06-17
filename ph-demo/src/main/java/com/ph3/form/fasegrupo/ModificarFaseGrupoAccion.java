package com.ph3.form.fasegrupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseGrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarFaseGrupoAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idFaseGrupo"));
        FaseGrupoDAO faseGrupoDAO = DAOFactory.getFaseGrupoDAO();
        request.getSession().setAttribute("unaFaseGrupo", faseGrupoDAO.buscarPorClave(id));
        System.out.println(faseGrupoDAO.buscarPorClave(id));
        return "protegido/admin/form/fasegrupos/modificarFaseGrupo.jsp";
    }

}
