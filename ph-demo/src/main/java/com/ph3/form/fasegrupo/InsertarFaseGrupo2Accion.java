package com.ph3.form.fasegrupo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.FaseGrupoDAO;
import com.ph3.dao.GrupoDAO;
import com.ph3.util.Accion;
import com.ph3.util.Consola;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.Grupo;

public class InsertarFaseGrupo2Accion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Estas en Insertar FG.java\n");

        Consola c = new Consola();
        c.mostrarMapas(request);

        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase fase = new Fase();

        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        Grupo grupo = new Grupo();

        FaseGrupoDAO faseGrupoDAO = DAOFactory.getFaseGrupoDAO();
        FaseGrupo faseGrupo = null;

        String[] fases = request.getParameterValues("idFase");

        for (String f : fases) {
            System.out.println("f: " + f);
            fase = faseDAO.buscarPorClave(Integer.parseInt(f));
        }

        String[] lscGrupos = request.getParameterValues("listaSinCambios");

        if (lscGrupos != null) {
            for (String g : lscGrupos) {
                System.out.println("g: " + g);
                grupo = grupoDAO.buscarPorClave(Integer.parseInt(g));
                faseGrupo = new FaseGrupo(fase, grupo);
                if (faseGrupoDAO.buscarFaseGruposRelacionados(fase.getIdFase(), grupo.getIdGrupo()).isEmpty()) {
                    faseGrupoDAO.salvar(faseGrupo);
                }
                faseGrupo = null;
            }
        }

        String[] ldnmGrupos = request.getParameterValues("listaDeNuevosMarcados");

        if (ldnmGrupos != null) {
            for (String g : ldnmGrupos) {
                System.out.println("g: " + g);
                grupo = grupoDAO.buscarPorClave(Integer.parseInt(g));
                faseGrupo = new FaseGrupo(fase, grupo);
                if (faseGrupoDAO.buscarFaseGruposRelacionados(fase.getIdFase(), grupo.getIdGrupo()).isEmpty()) {
                    faseGrupoDAO.insertar(faseGrupo);
                }
                faseGrupo = null;
            }
        }

        String[] lddGrupos = request.getParameterValues("listaDeDesmarcados");
        List<FaseGrupo> listaDeFaseGrupos = null;
        FaseGrupo fg = null;

        // NO HACE NADA, ES DECIR, NO SE BORRAR DE LA BD LOS VALORES DE DESMARCADOS, NO FUNCIONA AUN
        
//        if (lddGrupos != null) {
//            for (String g : lddGrupos) {
//                System.out.println("g: " + g);
//                grupo = grupoDAO.buscarPorClave(Integer.parseInt(g));
//                faseGrupo = new FaseGrupo(fase, grupo);
//                int hola = faseGrupoDAO.buscarPorClave(faseGrupoDAO.buscarFaseGruposRelacionados(fase.getIdFase(), grupo.getIdGrupo()).get(0).getIdFaseGrupo());
//                faseGrupo = null;
//            }
//        }
        return "protegido/admin/form/fasegrupos/grabarFaseGrupo.jsp";
    }

}
