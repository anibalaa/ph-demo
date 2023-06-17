package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.FaseDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;

public class FaseBean {
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

    public List<FaseGrupo> getGruposRelacionadosConFase(Integer idFase) {
        return DAOFactory.getFaseGrupoDAO().buscarGruposRelacionadosConUnaFase(idFase);
    }

    public static Map<String, String> getDescripcionInfo() {
        return FASE_INFO;
    }
}