package com.ph3.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ph3.dao.TratamientoDAO;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Tratamiento;
import com.ph3.vo.TratamientoPrograma;

public class TratamientoBean {
    private static Map<String, String> TRATAMIENTO_INFO;
    static {
        TRATAMIENTO_INFO = Collections.synchronizedMap(new HashMap<String, String>());
    }

    public String[] getTratamientoInfo() {

        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        List<Tratamiento> listaDeTratamientos = tratamientoDAO.buscarTodos();
        List<String> listafin = new ArrayList<String>();

        for (Tratamiento t : listaDeTratamientos) {
            listafin.add(t.getDescripcion().toString());
        }
        return listafin.toArray(new String[]{});
    }

//    public String[] getProgramasRelacionadosConTratamiento(Integer idTratamiento) {
//        List<TratamientoPrograma> listaDeTratamientoProgramas = DAOFactory.getTratamientoProgramaDAO().buscarProgramasRelacionadosConUnTratamiento(idTratamiento);
//        List<String> listaFin = new ArrayList<String>();
//        for (TratamientoPrograma tp : listaDeTratamientoProgramas) {
//            //listaFin.add(tp.getPrograma().getIdPrograma().toString());
//            listaFin.add(tp.getPrograma().getDescripcion().toString());
//        }
//        return listaFin.toArray(new String[]{});
//
//    }
    
    public List<TratamientoPrograma> getProgramasRelacionadosConTratamiento(Integer idTratamiento) {
        return DAOFactory.getTratamientoProgramaDAO().buscarProgramasRelacionadosConUnTratamiento(idTratamiento); 

    }
    
    public static Map<String, String> getDescripcionInfo() {
        return TRATAMIENTO_INFO;
    }
}