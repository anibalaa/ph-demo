package com.ph3.form.tratamientoprograma;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.util.SystemOutLoggingOutput;

import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.TratamientoDAO;
import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.Consola;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;
import com.ph3.vo.Tratamiento;
import com.ph3.vo.TratamientoPrograma;

public class InsertarTratamientoPrograma2Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        System.err.println("Estas en InsertarTP.java\n");

        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        Tratamiento tratamiento = new Tratamiento();

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa programa = new Programa();

        TratamientoProgramaDAO tratamientoProgramaDAO = DAOFactory.getTratamientoProgramaDAO();
        TratamientoPrograma tratamientoPrograma = null;

        tratamiento = tratamientoDAO.buscarPorClave(Integer.parseInt(request.getParameter("idTratamiento")));

        String[] programas = request.getParameterValues("programa");

        Consola c = new Consola();
        c.mostrarMapas(request);

        for (String p : programas) {
            System.out.println("p: " + p);
            programa = programaDAO.buscarPorClave(Integer.parseInt(p));
            tratamientoPrograma = new TratamientoPrograma(programa, tratamiento);
            if (tratamientoProgramaDAO.buscarTratamientoProgramasRelacionados(tratamiento.getIdTratamiento(), programa.getIdPrograma()).isEmpty()) {
                System.out.println("estas en if");
                tratamientoProgramaDAO.salvar(tratamientoPrograma);
            }
            tratamientoPrograma = null;
        }

//        List<TratamientoPrograma> listaDeTratamientoProgramas = DAOFactory.getTratamientoProgramaDAO().buscarTratamientoProgramasExistentesSegunTratamiento(tratamiento.getIdTratamiento());

//        for (TratamientoPrograma tp : listaDeTratamientoProgramas) {
//            System.out.println("tp: " + tp);
//            for (String p : programas) {
//
//                if (tp.getPrograma().getIdPrograma().toString().equals(p)) {
//                    System.out.println("Son iguales");
//                } else {
//                    System.out.println("son diferentes");
//                }
//            }
//        }

        //tratamientoProgramaDAO.borrarTratamientoProgramasDesmarcados(tratamiento.getIdTratamiento(), programa.getIdPrograma());

        return "protegido/admin/form/tratamientoprogramas/grabarTratamientoPrograma.jsp";
    }
}
