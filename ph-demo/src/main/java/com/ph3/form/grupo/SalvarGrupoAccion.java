package com.ph3.form.grupo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.GrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Grupo;

public class SalvarGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idGrupo"));
        String descripcion = request.getParameter("descripcion");
        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        Grupo unGrupo = grupoDAO.buscarPorClave(id);
        unGrupo.setDescripcion(descripcion);
        grupoDAO.salvar(unGrupo);
        request.setAttribute("listaDeGrupos", grupoDAO.buscarTodos());
        return "protegido/admin/form/grupos/mostrarGrupos.jsp";
    }

}
