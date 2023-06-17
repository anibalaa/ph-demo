package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;

public class NombrePersonaBean {

    private static Map<String, String> NOMBRE_INFO;
    static {
        NOMBRE_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getPersonaInfo() {
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        List<Persona> listaDePersonas = personaDAO.buscarTodos();
        List<String> listafin = new ArrayList<String>();
        for (Persona p : listaDePersonas) {
            listafin.add(p.getNombre().toString());
        }
        return listafin.toArray(new String[]{});
    }

    public static Map<String, String> getNombreInfo() {
        return NOMBRE_INFO;
    }
}
