package com.ph3.form.fase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.util.DAOFactory;
import com.ph3.util.Accion;

public class EliminarFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idFase"));
        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        faseDAO.borrar(faseDAO.buscarPorClave(id));
        request.setAttribute("listaDeFases", faseDAO.buscarTodos());
        return "protegido/admin/form/fases/mostrarFases.jsp";
    }

}
