package com.ph3.dao;

import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.Grupo;

public interface FaseGrupoDAO extends GenericDAO<FaseGrupo, Integer> {

    public void insertar(FaseGrupo faseGrupo);
    public FaseGrupo buscarPorClave(Integer id);
    public List<FaseGrupo> buscarFaseGruposExistentesSegunFase(Integer idFase);
    public List<FaseGrupo> buscarGruposRelacionadosConUnaFase(Integer idFase);
    public List<FaseGrupo> buscarGruposExistentes();
    public List<FaseGrupo> buscarFaseGruposRelacionados(Integer idFase,Integer idGrupo);
    public int buscarIdFaseGruposRelacionados(Fase fase, Grupo grupo);
}
