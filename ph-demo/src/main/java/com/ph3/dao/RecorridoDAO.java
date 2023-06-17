package com.ph3.dao;

import java.util.Date;
import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.Recorrido;

public interface RecorridoDAO extends GenericDAO<Recorrido, Integer> {
  //  public Recorrido buscarPorPersonaTratamientoProgramaFaseYGrupo(Persona unaPersona, Integer idTratamiento, Integer idPrograma, Integer idFase, Integer idGrupo);
    public List<Recorrido> buscarRecorridosDeUnaPersona(Integer idPersona);
    public List<Recorrido> buscarRecorridosActivosDeUnaPersona(Integer idPersona);
    public List<Recorrido> buscarRecorridosDeUnaPersonaEntreFechas(Integer idPersona, Date fechaInicio, Date fechaFin);
    public List<Recorrido> buscarRecorridosPorMotivoEntreFechas(Integer idMotivo, Date fechaInicio, Date fechaFin);
}
