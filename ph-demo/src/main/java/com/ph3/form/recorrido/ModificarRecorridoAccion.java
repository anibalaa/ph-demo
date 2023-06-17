package com.ph3.form.recorrido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RecorridoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.Motivo;
import com.ph3.vo.ProgramaFase;
import com.ph3.vo.TratamientoPrograma;

public class ModificarRecorridoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        List<TratamientoPrograma> listaDeTratamientos = null;
        listaDeTratamientos = DAOFactory.getTratamientoProgramaDAO().buscarTratamientosExistentes();
        request.setAttribute("listaDeTratamientos", listaDeTratamientos);
        
        List<TratamientoPrograma> listaDeProgramas = null;
        listaDeProgramas = DAOFactory.getTratamientoProgramaDAO().buscarProgramasExistentes();
        request.setAttribute("listaDeProgramas", listaDeProgramas);
        
        List<ProgramaFase> listaDeFases = null;
        listaDeFases = DAOFactory.getProgramaFaseDAO().buscarFasesExistentes();
        request.setAttribute("listaDeFases", listaDeFases);
        
        List<FaseGrupo> listaDeGrupos = null;
        listaDeGrupos = DAOFactory.getFaseGrupoDAO().buscarGruposExistentes();
        request.setAttribute("listaDeGrupos", listaDeGrupos);
        
        List<Motivo> listaDeMotivos = null;
        listaDeMotivos = DAOFactory.getMotivoDAO().buscarTodos();
        request.setAttribute("listaDeMotivos", listaDeMotivos);
        
        Integer idRecorrido = Integer.parseInt(request.getParameter("idRecorrido"));
        System.out.println("idRecorrido: " + idRecorrido);
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        request.getSession().setAttribute("unRecorrido", recorridoDAO.buscarPorClave(idRecorrido));
        return "protegido/admin/form/recorridos/modificarRecorrido.jsp";
    }

}
