package com.ph3.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.vo.ProgramaFase;

public class ProgramaFaseDAOImpl extends GenericDAOImpl<ProgramaFase, Integer> implements ProgramaFaseDAO {

    public ProgramaFaseDAOImpl(SessionFactory sf) {
        super(sf);
    }

    public void insertar(ProgramaFase programaFase) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(programaFase);
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("Error al insertar ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public ProgramaFase buscarPorClave(Integer id) {
        ProgramaFase programaFase = null;
        try {
            sf.getCurrentSession().beginTransaction();
            programaFase = sf.getCurrentSession().get(ProgramaFase.class, id);
            return programaFase;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }
    @SuppressWarnings("unchecked")
    public List<ProgramaFase> buscarFasesRelacionadasConUnPrograma(Integer idPrograma) {
        List<ProgramaFase> listaDeProgramaFases = null;
        String qstr = "select distinct pf.idFase,f.descripcion from ProgramaFase as pf join Fase as f where f.idFase = pf.idFase and pf.idPrograma =:idPrograma order by f.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idPrograma", idPrograma);
            listaDeProgramaFases = consulta.list();
            System.out.println(listaDeProgramaFases);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeProgramaFases;
        } catch (RuntimeException e) {
            System.err.println("Error buscando F.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<ProgramaFase> buscarFasesExistentes() {
        List<ProgramaFase> listaDeProgramaFases = null;
        String qstr = "select distinct pf.idFase,f.descripcion from ProgramaFase as pf join Fase as f where f.idFase = pf.idFase order by f.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            listaDeProgramaFases = consulta.list();
            System.out.println(listaDeProgramaFases);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeProgramaFases;
        } catch (RuntimeException e) {
            System.err.println("Error buscando F.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ProgramaFase> buscarProgramaFasesRelacionadas(Integer idPrograma, Integer idFase){
        List<ProgramaFase> listaDeProgramaFases = null;
        String qstr = "select distinct pf.idPrograma,pf.idFase from ProgramaFase as pf where pf.idPrograma =:idPrograma and pf.idFase =:idFase order by pf.idPrograma asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idPrograma", idPrograma);
            consulta.setParameter("idFase", idFase);
            listaDeProgramaFases = consulta.list();
            System.out.println(listaDeProgramaFases);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeProgramaFases;
        } catch (RuntimeException e) {
            System.err.println("Error buscando PF.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }
}
