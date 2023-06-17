package com.ph3.form.fasegrupo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.FaseGrupo;

public class MostrarFaseGrupoAccion extends Accion{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List <FaseGrupo> listaDeFaseGrupos = null;
        listaDeFaseGrupos = DAOFactory.getFaseGrupoDAO().buscarTodos();
        request.setAttribute("listaDeFaseGrupos", listaDeFaseGrupos);
        return "protegido/admin/form/fasegrupos/mostrarFaseGrupos.jsp";
    }

}
