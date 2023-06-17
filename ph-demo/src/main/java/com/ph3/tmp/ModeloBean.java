package com.ph3.tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.util.DAOFactory;
import com.ph3.vo.TratamientoPrograma;

public class ModeloBean {

    private static Map<String, String> MODEL_INFO;
    static {
        MODEL_INFO = Collections.synchronizedMap(new HashMap<String, String>());
        MODEL_INFO.put("", "");
        String key = null;
        String value = null;

        MODEL_INFO.put(key, value);

    }

    public String[] getModeloInfo(String idTratamiento) {
        System.out.println("idTratamiento: " + idTratamiento);
        ModeloDAO modeloDAO = DAOFactory.getModeloDAO();
        List<TratamientoPrograma> lista = modeloDAO.buscarModeloPorBike(idTratamiento);
        List<String> listafin = new ArrayList<String>();
        for (TratamientoPrograma tp : lista) {
            System.out.println(tp.getPrograma().getIdPrograma());
            listafin.add(tp.getPrograma().getIdPrograma().toString());
        }
        return listafin.toArray(new String[] {});
    }

    public String[] getDesignerInfo() {
        return MODEL_INFO.keySet().toArray(new String[] {});
    }

    public static Map<String, String> getModelInfo() {
        return MODEL_INFO;
    }
}
