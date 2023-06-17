package com.ph3.form.programafase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.util.Accion;
import com.ph3.util.Consola;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.Programa;
import com.ph3.vo.ProgramaFase;

public class InsertarProgramaFase2Accion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        System.err.println("Estas en Insertar PF.java\n");

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa programa = new Programa();

        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase fase = new Fase();

        ProgramaFaseDAO programaFaseDAO = DAOFactory.getProgramaFaseDAO();
        ProgramaFase programaFase = null;

        //String[] programas = request.getParameterValues("idPrograma");

        programa = programaDAO.buscarPorClave(Integer.parseInt(request.getParameter("idPrograma")));
//        
//        for (String p : programas) {
//            System.out.println("p: " + p);
//            if (p != null || p != "") {
//                programa = programaDAO.buscarPorClave(Integer.parseInt(p));
//            }
//        }

        String[] fases = request.getParameterValues("fase");
        
        Consola c = new Consola();
        c.mostrarMapas(request);
        
        
        for (String f : fases) {
            System.out.println("f: " + f);
            fase = faseDAO.buscarPorClave(Integer.parseInt(f));
            programaFase = new ProgramaFase(fase, programa);
            if (programaFaseDAO.buscarProgramaFasesRelacionadas(programa.getIdPrograma(), fase.getIdFase()).isEmpty()) {
                programaFaseDAO.salvar(programaFase);
            }
            programaFase = null;
        }

        return "protegido/admin/form/programafases/grabarProgramaFase.jsp";
    }

}
