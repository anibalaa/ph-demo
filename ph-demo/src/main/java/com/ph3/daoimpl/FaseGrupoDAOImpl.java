package com.ph3.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.ph3.dao.FaseGrupoDAO;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.Grupo;

public class FaseGrupoDAOImpl extends GenericDAOImpl<FaseGrupo, Integer> implements FaseGrupoDAO {

    public FaseGrupoDAOImpl(SessionFactory sf) {
        super(sf);
    }

    public void insertar(FaseGrupo faseGrupo) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(faseGrupo);
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("Error al insertar ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public FaseGrupo buscarPorClave(Integer id) {
        FaseGrupo faseGrupo = null;
        try {
            sf.getCurrentSession().beginTransaction();
            faseGrupo = sf.getCurrentSession().get(FaseGrupo.class, id);
            sf.getCurrentSession().getTransaction().commit();
            return faseGrupo;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<FaseGrupo> buscarFaseGruposExistentesSegunFase(Integer idFase) {

        List<FaseGrupo> listaDeFaseGrupos = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query consulta = sf.getCurrentSession().createQuery("FROM FaseGrupo WHERE idFase=:idFase");
            consulta.setParameter("idFase", idFase);
            listaDeFaseGrupos = consulta.list();
            sf.getCurrentSession().getTransaction().commit();
            return listaDeFaseGrupos;
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
    public List<FaseGrupo> buscarGruposRelacionadosConUnaFase(Integer idFase) {
        List<FaseGrupo> listaDeFaseGrupos = null;
        String qstr = "select distinct fg.idGrupo,g.descripcion from FaseGrupo as fg join Grupo as g where fg.idGrupo = g.idGrupo and fg.idFase =:idFase order by g.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idFase", idFase);
            listaDeFaseGrupos = consulta.list();
            System.out.println(listaDeFaseGrupos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeFaseGrupos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando G.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<FaseGrupo> buscarGruposExistentes() {
        List<FaseGrupo> listaDeFaseGrupos = null;
        String qstr = "select distinct fg.idGrupo,g.descripcion from FaseGrupo as fg join Grupo as g where fg.idGrupo = g.idGrupo order by g.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            listaDeFaseGrupos = consulta.list();
            System.out.println(listaDeFaseGrupos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeFaseGrupos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando G.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<FaseGrupo> buscarFaseGruposRelacionados(Integer idFase, Integer idGrupo) {
        List<FaseGrupo> listaDeFaseGrupos = null;
        String qstr = "select distinct fg.idFase,fg.idGrupo from FaseGrupo as fg where fg.idFase=:idFase and fg.idGrupo =:idGrupo order by fg.idFase asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idFase", idFase);
            consulta.setParameter("idGrupo", idGrupo);
            listaDeFaseGrupos = consulta.list();
            System.out.println(listaDeFaseGrupos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeFaseGrupos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando FG.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    
//    public FaseGrupo buscarPorClave(Integer id) {
//        FaseGrupo faseGrupo = null;
//        try {
//            sf.getCurrentSession().beginTransaction();
//            faseGrupo = sf.getCurrentSession().get(FaseGrupo.class, id);
//            sf.getCurrentSession().getTransaction().commit();
//            return faseGrupo;
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            sf.getCurrentSession().getTransaction().rollback();
//            return null;
//        } finally {
//            sf.getCurrentSession().close();
//        }
//    }
    
    public int buscarIdFaseGruposRelacionados(Fase fase, Grupo grupo){
        String qstr = "select distinct fg.idFaseGrupo from FaseGrupo as fg where fg.idFase=:idFase and fg.idGrupo =:idGrupo order by fg.idFaseGrupo asc";
        List<FaseGrupo> listaDeFaseGrupos = null;
        List<Integer> listaDeEnteros = null;
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idFase", fase.getIdFase());
            consulta.setParameter("idGrupo", grupo.getIdGrupo());
            listaDeEnteros = (List<Integer>) consulta.uniqueResult();
            System.out.println(listaDeFaseGrupos);
            int a = listaDeEnteros.get(0); 
            sf.getCurrentSession().getTransaction().commit();
            return a;
        } catch (RuntimeException e) {
            System.err.println("Error buscando FG.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return 0;
        } finally {
            sf.getCurrentSession().close();
        }
    }

}
