package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.ProgramaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Programa;
import com.ph3.vo.ProgramaFase;

public class ProgramaBean {
    private static Map<String, String> PROGRAMA_INFO;
    static {
        PROGRAMA_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getProgramaInfo() {

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        List<Programa> listaDeProgramas = programaDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Programa t : listaDeProgramas) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public String[] getProgramaInfo3() {

        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        List<Programa> listaDeProgramas = programaDAO.buscarTodos();

        List<String> listafin = new ArrayList<String>();
        for (Programa t : listaDeProgramas) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public List<ProgramaFase> getFasesRelacionadasConPrograma(Integer idPrograma) {
        return DAOFactory.getProgramaFaseDAO().buscarFasesRelacionadasConUnPrograma(idPrograma);
        
    }

    public static Map<String, String> getDescripcionInfo() {
        return PROGRAMA_INFO;
    }
}