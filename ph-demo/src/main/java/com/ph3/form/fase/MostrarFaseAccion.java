package com.ph3.form.fase;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;

public class MostrarFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Fase> listaDeFases = null;
        listaDeFases = DAOFactory.getFaseDAO().buscarTodos();
        request.setAttribute("listaDeFases", listaDeFases);
        return "protegido/admin/form/fases/mostrarFases.jsp";
    }

}
