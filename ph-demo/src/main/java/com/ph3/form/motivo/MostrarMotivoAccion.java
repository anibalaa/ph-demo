package com.ph3.form.motivo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;

public class MostrarMotivoAccion extends Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Motivo> listaDeMotivos = null;
        listaDeMotivos = DAOFactory.getMotivoDAO().buscarTodos();
        request.setAttribute("listaDeMotivos", listaDeMotivos);
        return "protegido/admin/form/motivos/mostrarMotivos.jsp";
    }
}
