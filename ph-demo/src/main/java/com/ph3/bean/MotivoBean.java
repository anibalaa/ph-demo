package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.MotivoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Motivo;

public class MotivoBean {
    private static Map<String, String> MOTIVO_INFO;
    static {
        MOTIVO_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getMotivoInfo() {

        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        List<Motivo> listaDeMotivos = motivoDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Motivo m : listaDeMotivos) {
            listafin.add(m.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public String[] getMotivoInfo3() {

        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        List<Motivo> listaDeMotivos = motivoDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Motivo m : listaDeMotivos) {
            listafin.add(m.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public List<Motivo> getMotivos() {
        return DAOFactory.getMotivoDAO().buscarTodos();
    }

    public static Map<String, String> getDescripcionInfo() {
        return MOTIVO_INFO;
    }
}