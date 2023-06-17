package com.ph3.form.grupo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Grupo;

public class MostrarGrupoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Grupo> listaDeGrupos = null;
        listaDeGrupos = DAOFactory.getGrupoDAO().buscarTodos();
        request.setAttribute("listaDeGrupos", listaDeGrupos);
        return "protegido/admin/form/grupos/mostrarGrupos.jsp";
    }
}
