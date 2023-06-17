package com.ph3.form.agrupacion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.Grupo;
import com.ph3.vo.Programa;
import com.ph3.vo.Tratamiento;

public class MostrarMenu2AgrupacionAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String opcion = request.getParameter("agrupacion");
        List<Tratamiento> listaDeTratamientos = null;
        List<Programa> listaDeProgramas = null;
        List<Fase> listaDeFases = null;
        List<Grupo> listaDeGrupos = null;

        if (opcion.indexOf("tratamiento - programa") != -1) {
            listaDeTratamientos = DAOFactory.getTratamientoDAO().buscarTodos();
            request.setAttribute("listaDeTratamientos", listaDeTratamientos);
            listaDeProgramas = DAOFactory.getProgramaDAO().buscarTodos();
            request.setAttribute("listaDeProgramas", listaDeProgramas);
            return "protegido/admin/form/tratamientoprogramas/selecionarTratamientoPrograma.jsp";
        }
        if (opcion.indexOf("programa - fase") != -1) {
            listaDeProgramas = DAOFactory.getProgramaDAO().buscarTodos();
            request.setAttribute("listaDeProgramas", listaDeProgramas);
            listaDeFases = DAOFactory.getFaseDAO().buscarTodos();
            request.setAttribute("listaDeFases", listaDeFases);
            return "protegido/admin/form/programafases/selecionarProgramaFase.jsp";
        }
        if (opcion.indexOf("fase - grupo") != -1) {
            listaDeFases = DAOFactory.getFaseDAO().buscarTodos();
            request.setAttribute("listaDeFases", listaDeFases);
            listaDeGrupos = DAOFactory.getGrupoDAO().buscarTodos();
            request.setAttribute("listaDeGrupos", listaDeGrupos);
            return "protegido/admin/form/fasegrupos/selecionarFaseGrupo.jsp";
        }

        return null;
    }

}
