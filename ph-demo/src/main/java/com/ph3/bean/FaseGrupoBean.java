package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.FaseGrupoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;

public class FaseGrupoBean {
    private static Map<String, String> FASE_INFO;
    static {
        FASE_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getFaseInfo() {

        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        List<Fase> listaDeFases = faseDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Fase t : listaDeFases) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public String[] getFaseInfo3() {

        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        List<Fase> listaDeFases = faseDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Fase t : listaDeFases) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public String[] getGrupoInfo3(Integer idFase) {

        FaseGrupoDAO faseGrupoDAO = DAOFactory.getFaseGrupoDAO();
        List<FaseGrupo> listaDeFaseGrupos = faseGrupoDAO.buscarFaseGruposExistentesSegunFase(idFase);
        List<String> listafin = new ArrayList<String>();
        for (FaseGrupo fg : listaDeFaseGrupos) {
//            listafin.add(fg.getGrupo().getIdGrupo().toString());
            listafin.add(fg.getGrupo().getDescripcion().toString());
        }
        
        // quitamos duplicados si hubiera
        Set<String> hs = new HashSet<String>();
        hs.addAll(listafin);
        listafin.clear();
        listafin.addAll(hs);        
        /// funciona :):):)
        
        return listafin.toArray(new String[]{});
    }
    
    public List<FaseGrupo> getGruposRelacionadosConFase(Integer idFase) {
       
        return DAOFactory.getFaseGrupoDAO().buscarGruposRelacionadosConUnaFase(idFase);
    }

    public static Map<String, String> getDescripcionInfo() {
        return FASE_INFO;
    }
}