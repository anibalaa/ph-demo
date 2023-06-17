package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.PersonaDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Persona;

public class Apellido2PersonaBean {

    private static Map<String, String> APELLIDO2_INFO;
    static {
        APELLIDO2_INFO = Collections.synchronizedMap(new HashMap<String,String>());
    }
    
    public String[] getPersonaInfo(String str) {
    PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
    List<Persona> listaDePersonas = personaDAO.buscarApellidosPorNombre(str);
    List<String> listafin = new ArrayList<String>();
    for (Persona p : listaDePersonas) {
        listafin.add(p.getApellido2().toString());
    }
        return listafin.toArray(new String[] {});

    }

    public static Map<String,String> getNombreInfo(){
        return APELLIDO2_INFO;
    }
}
