package com.ph3.form.recorrido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;
import com.ph3.util.Accion;

public class ConsultarRecorrido2Accion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        
        List<Motivo> listaDeMotivos = null;
        listaDeMotivos = DAOFactory.getMotivoDAO().buscarTodos();
        request.setAttribute("listaDeMotivos", listaDeMotivos);
        
        return "protegido/admin/form/recorridos/consultarRecorridos2.jsp";
    }

}