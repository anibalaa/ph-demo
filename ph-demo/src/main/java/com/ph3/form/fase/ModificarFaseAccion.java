package com.ph3.form.fase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;

public class ModificarFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idFase"));
        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        request.getSession().setAttribute("unaFase", faseDAO.buscarPorClave(id));
        System.out.println(faseDAO.buscarPorClave(id));
        return "protegido/admin/form/fases/modificarFase.jsp";
    }

}
