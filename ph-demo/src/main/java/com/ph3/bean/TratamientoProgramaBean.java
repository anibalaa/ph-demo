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

public class TratamientoProgramaBean {
    private static Map<String, String> TRATAMIENTO_PROGRAMA_INFO;
    static {
        TRATAMIENTO_PROGRAMA_INFO = Collections.synchronizedMap(new HashMap<String, String>());
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

    public List<TratamientoPrograma> getTratamientoInfo3() {

        return DAOFactory.getTratamientoProgramaDAO().buscarTratamientosExistentes();

    }

    public List<TratamientoPrograma> getTInfo3(Integer idTratamiento) {

        return DAOFactory.getTratamientoProgramaDAO().buscarTratamientoProgramasExistentesSegunTratamiento(idTratamiento);
    }

    public List<TratamientoPrograma> getProgramaInfo5(Integer idTratamiento) {
        List<TratamientoPrograma> ls = new ArrayList<TratamientoPrograma>();
        //............
        return ls;
    }
    
    public List<TratamientoPrograma> getProgramasRelacionadosConUnTratamiento(Integer idTratamiento) {
        return DAOFactory.getTratamientoProgramaDAO().buscarProgramasRelacionadosConUnTratamiento(idTratamiento);
    }

    public static Map<String, String> getDescripcionInfo() {
        return TRATAMIENTO_PROGRAMA_INFO;
    }
}