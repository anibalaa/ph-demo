package com.ph3.form.fasegrupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseGrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.FaseGrupo;

public class InsertarFaseGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        FaseGrupoDAO faseGrupoDAO = DAOFactory.getFaseGrupoDAO();
        FaseGrupo faseGrupo = new FaseGrupo(null, null);
        faseGrupoDAO.insertar(faseGrupo);
        request.setAttribute("listaDeFaseGrupos", faseGrupoDAO.buscarTodos());
        return "protegido/admin/form/fasegrupos/mostrarFaseGrupos.jsp";
    }

}
