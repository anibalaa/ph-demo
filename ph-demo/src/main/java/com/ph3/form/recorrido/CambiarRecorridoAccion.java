package com.ph3.form.recorrido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.RecorridoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;
import com.ph3.vo.TratamientoPrograma;
import com.ph3.util.Accion;

public class CambiarRecorridoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer idRecorrido = Integer.parseInt(request.getParameter("idRecorrido"));
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        request.setAttribute("idRecorrido", idRecorrido); 
                
        Integer idPersona = recorridoDAO.buscarPorClave(idRecorrido).getPersona().getIdPersona();
        request.setAttribute("idPersona", idPersona);
        
        List<TratamientoPrograma> listaDeTratamientos = null;
        listaDeTratamientos = DAOFactory.getTratamientoProgramaDAO().buscarTratamientosExistentes();
        request.setAttribute("listaDeTratamientos", listaDeTratamientos);
        
        List<Motivo> listaDeMotivos = null;
        listaDeMotivos = DAOFactory.getMotivoDAO().buscarTodos();
        request.setAttribute("listaDeMotivos", listaDeMotivos);
        
        return "protegido/admin/form/recorridos/cambiarRecorridos.jsp";
    }

}