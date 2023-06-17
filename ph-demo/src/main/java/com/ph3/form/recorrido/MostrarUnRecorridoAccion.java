package com.ph3.form.recorrido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Recorrido;

public class MostrarUnRecorridoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Recorrido> listaDeRecorridos = null;
        listaDeRecorridos = DAOFactory.getRecorridoDAO().buscarTodos();
        request.getSession().setAttribute("listaDeRecorridos", listaDeRecorridos);
        return "protegido/admin/form/recorridos/mostrarUnRecorrido.jsp";
    }
}
