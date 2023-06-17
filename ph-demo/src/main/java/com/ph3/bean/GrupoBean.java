package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.GrupoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Grupo;

public class GrupoBean {
    private static Map<String, String> GRUPO_INFO;
    static {
        GRUPO_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getGrupoInfo() {

        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        List<Grupo> listaDeGrupos = grupoDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Grupo t : listaDeGrupos) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public String[] getGrupoInfo3() {

        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        List<Grupo> listaDeGrupos = grupoDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Grupo t : listaDeGrupos) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public static Map<String, String> getDescripcionInfo() {
        return GRUPO_INFO;
    }
}