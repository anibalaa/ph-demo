package com.ph3.form.fase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;

public class SalvarFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idFase"));
        String descripcion = request.getParameter("descripcion");
        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase unFase = faseDAO.buscarPorClave(id);
        unFase.setDescripcion(descripcion);
        faseDAO.salvar(unFase);
        request.setAttribute("listaDeFases", faseDAO.buscarTodos());
        return "protegido/admin/form/fases/mostrarFases.jsp";
    }
}
