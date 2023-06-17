package com.ph3.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.vo.TratamientoPrograma;

public class TratamientoProgramaDAOImpl extends GenericDAOImpl<TratamientoPrograma, Integer> implements TratamientoProgramaDAO {

    public TratamientoProgramaDAOImpl(SessionFactory sf) {
        super(sf);
    }

    public void insertar(TratamientoPrograma tratamientoprograma) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(tratamientoprograma);
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("Error al insertar ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public TratamientoPrograma buscarPorClave(Integer id) {
        TratamientoPrograma tratamientoprograma = null;
        try {
            sf.getCurrentSession().beginTransaction();
            tratamientoprograma = sf.getCurrentSession().get(TratamientoPrograma.class, id);
            return tratamientoprograma;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarProgramasRelacionadosConUnTratamiento(Integer idTratamiento) {
        List<TratamientoPrograma> listaDeTratamientoProgramas = null;
        String qstr = "select distinct tp.idPrograma,p.descripcion from TratamientoPrograma as tp join Programa as p where tp.idPrograma = p.idPrograma  and tp.idTratamiento =:idTratamiento order by p.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idTratamiento", idTratamiento);
            listaDeTratamientoProgramas = consulta.list();
            System.out.println(listaDeTratamientoProgramas);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeTratamientoProgramas;
        } catch (RuntimeException e) {
            System.err.println("Error buscando P.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarTratamientosExistentes() {
        List<TratamientoPrograma> listaDeTratamientos = null;
        String qstr = "select distinct tp.idTratamiento,t.descripcion from Tratamiento as t join TratamientoPrograma as tp where t.idTratamiento = tp.idTratamiento order by t.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            listaDeTratamientos = consulta.list();
            System.out.println(listaDeTratamientos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeTratamientos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando T.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarProgramasExistentes() {
        List<TratamientoPrograma> listaDeProgramas = null;
        String qstr = "select distinct tp.idPrograma,p.descripcion from Programa as p join TratamientoPrograma as tp where p.idPrograma = tp.idPrograma order by p.descripcion asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            listaDeProgramas = consulta.list();
            System.out.println(listaDeProgramas);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeProgramas;
        } catch (RuntimeException e) {
            System.err.println("Error buscando T.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarTratamientoProgramasExistentesSegunTratamiento(Integer idTratamiento) {
        List<TratamientoPrograma> listaDeTratamientos = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query consulta = sf.getCurrentSession().createQuery("FROM TratamientoPrograma WHERE idTratamiento=:idTratamiento");
            consulta.setParameter("idTratamiento", idTratamiento);
            listaDeTratamientos = consulta.list();

            sf.getCurrentSession().getTransaction().commit();
            return listaDeTratamientos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando T.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarTratamientoProgramasRelacionados(Integer idTratamiento, Integer idPrograma){
        List<TratamientoPrograma> listaDeTratamientoProgramas = null;
        String qstr = "select distinct tp.idTratamiento,tp.idPrograma from TratamientoPrograma as tp where tp.idTratamiento =:idTratamiento and tp.idPrograma =:idPrograma order by tp.idTratamiento asc";
        try {
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idTratamiento", idTratamiento);
            consulta.setParameter("idPrograma", idPrograma);
            listaDeTratamientoProgramas = consulta.list();
            System.out.println(listaDeTratamientoProgramas);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeTratamientoProgramas;
        } catch (RuntimeException e) {
            System.err.println("Error buscando TP.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public void borrarTratamientoProgramasDesmarcados(Integer idTratamiento, Integer idPrograma){
        String qstr = "delete from TratamientoPrograma as tp where tp.idTratamiento = :idTratamiento and tp.idPrograma != :idPrograma";
        try {
            
            
//            sf.getCurrentSession().delete(sf.getCurrentSession().merge(objeto));
//            System.out.println(objeto);
//            System.out.println("***BORRADO***");
//            sf.getCurrentSession().getTransaction().commit();
            
            
            sf.getCurrentSession().beginTransaction();
            SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("idTratamiento", idTratamiento);
            consulta.setParameter("idPrograma", idPrograma);
            consulta.executeUpdate();
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("Error borrando TP.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }
    
    
}
