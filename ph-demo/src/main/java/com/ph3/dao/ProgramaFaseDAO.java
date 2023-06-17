package com.ph3.dao;

import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.ProgramaFase;

public interface ProgramaFaseDAO extends GenericDAO<ProgramaFase, Integer> {
    public List<ProgramaFase> buscarFasesRelacionadasConUnPrograma(Integer idPrograma) ;
    public List<ProgramaFase> buscarFasesExistentes();
    public List<ProgramaFase> buscarProgramaFasesRelacionadas(Integer idPrograma, Integer idFase);
}
