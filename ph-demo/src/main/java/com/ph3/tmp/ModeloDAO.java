package com.ph3.tmp;

import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.TratamientoPrograma;

public interface ModeloDAO extends GenericDAO<Modelo, Integer> {
    public List<TratamientoPrograma> buscarModeloPorBike(String id) ;
}
