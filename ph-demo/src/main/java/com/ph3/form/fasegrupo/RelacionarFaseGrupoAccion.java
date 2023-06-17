package com.ph3.form.fasegrupo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.FaseGrupo;

public class RelacionarFaseGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        // Integer idFase = Integer.parseInt(request.getParameter("idFase"));
        Integer idFase = 9;
        List<FaseGrupo> listaDeFaseGrupos = null;
        listaDeFaseGrupos = DAOFactory.getFaseGrupoDAO().buscarGruposRelacionadosConUnaFase(idFase);
        request.setAttribute("idFase", idFase);
        request.setAttribute("listaDeFaseGrupos", listaDeFaseGrupos);
        return "protegido/admin/form/fasegrupos/mostrarFaseGrupoRelacionados.jsp";
    }

}
