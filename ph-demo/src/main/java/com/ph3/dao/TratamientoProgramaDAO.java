package com.ph3.dao;

import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.TratamientoPrograma;

public interface TratamientoProgramaDAO extends GenericDAO<TratamientoPrograma, Integer> {
    public void insertar(TratamientoPrograma tratamientoprograma);
    public TratamientoPrograma buscarPorClave(Integer id);
    public List<TratamientoPrograma> buscarProgramasRelacionadosConUnTratamiento(Integer idPrograma);
    public List<TratamientoPrograma> buscarTratamientosExistentes();
    public List<TratamientoPrograma> buscarProgramasExistentes();
    public List<TratamientoPrograma> buscarTratamientoProgramasExistentesSegunTratamiento(Integer idTratamiento);
    public List<TratamientoPrograma> buscarTratamientoProgramasRelacionados(Integer idTratamiento, Integer idPrograma);
    public void borrarTratamientoProgramasDesmarcados(Integer idTratamiento, Integer idPrograma);
}
