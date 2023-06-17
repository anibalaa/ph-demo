package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;

public class Apellido1PersonaBean {

    private static Map<String, String> APELLIDO1_INFO;
    static {
        APELLIDO1_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getPersonaInfo(String str) {
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        List<Persona> listaDePersonas = null;
        listaDePersonas = personaDAO.buscarApellidosPorNombre(str);
        List<String> listafin = new ArrayList<String>();
        for (Persona p : listaDePersonas) {
            listafin.add(p.getApellido1().toString());
        }

        return listafin.toArray(new String[] {});

    }

    public static Map<String, String> getApellido1Info() {
        return APELLIDO1_INFO;
    }

}
