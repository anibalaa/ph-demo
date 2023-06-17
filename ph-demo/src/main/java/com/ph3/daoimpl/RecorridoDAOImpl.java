package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.ph3.dao.RecorridoDAO;
import com.ph3.vo.Recorrido;

public class RecorridoDAOImpl extends GenericDAOImpl<Recorrido, Integer> implements RecorridoDAO {

    public RecorridoDAOImpl(SessionFactory sf) {
        super(sf);
    }

    @SuppressWarnings("unchecked")
    public List<Recorrido> buscarRecorridosDeUnaPersona(Integer idPersona) {
        List<Recorrido> listaDeRecorridos = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery("from Recorrido where idPersona=:idPersona");
            q.setParameter("idPersona", idPersona);
            listaDeRecorridos = q.list();
            sf.getCurrentSession().getTransaction().commit();
            return listaDeRecorridos;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Recorrido> buscarRecorridosActivosDeUnaPersona(Integer idPersona) {
        List<Recorrido> listaDeRecorridos = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery("from Recorrido where idPersona=:idPersona and activo=1");
            q.setParameter("idPersona", idPersona);
            listaDeRecorridos = q.list();
            sf.getCurrentSession().getTransaction().commit();
            return listaDeRecorridos;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Recorrido> buscarRecorridosDeUnaPersonaEntreFechas(Integer idPersona, Date fechaInicio, Date fechaFin) {
        List<Recorrido> listaDeRecorridos = null;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        String personaStr = idPersona.toString();
        System.out.println(personaStr);
        String fInicioStr = df.format(fechaInicio);
        System.out.println(fInicioStr);
        String fFinStr = df.format(fechaFin);
        System.out.println(fFinStr);

        // dado que el Union no funciona en hql, hay que hacer esta consulta más compleja como alternativa
        String qhql = "from Recorrido as r where idPersona in (select r1.persona.idPersona from Recorrido as r1 where idPersona=:idPersona1 and fechaInicio >='" + fInicioStr
                + "') or idPersona in (select r2.persona.idPersona from Recorrido as r2 where idPersona=:idPersona2 and fechaInicio >='" + fInicioStr + "' and fechaFin <='" + fFinStr + "')";

        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery(qhql);
            q.setParameter("idPersona1", personaStr);
            q.setParameter("idPersona2", personaStr);
            System.out.println(q.toString());
            try {
                listaDeRecorridos = q.list();
            } catch (Exception e) {
                System.err.println("Error en q.list()");
                e.printStackTrace();
            }
            System.out.println(listaDeRecorridos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeRecorridos;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Recorrido> buscarRecorridosPorMotivoEntreFechas(Integer idMotivo, Date fechaInicio, Date fechaFin) {
        List<Recorrido> listaDeRecorridos = null;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        String motivoStr = idMotivo.toString();
        System.out.println("motivo: " + motivoStr);
        String fInicioStr = df.format(fechaInicio);
        System.out.println(fInicioStr);
        String fFinStr = df.format(fechaFin);
        System.out.println(fFinStr);

        // dado que el Union no funciona en hql, hay que hacer esta consulta más compleja como alternativa
        String hql = "from Recorrido as r where idMotivo in (select r1.motivo.idMotivo from Recorrido as r1 where idMotivo=:idMotivo1 and fechaInicio >='" + fInicioStr
                + "') or idMotivo in (select r2.motivo.idMotivo from Recorrido as r2 where idMotivo=:idMotivo2 and fechaInicio >='" + fInicioStr + "' and fechaFin <='" + fFinStr + "')";

        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery(hql);
            q.setParameter("idMotivo1", motivoStr);
            q.setParameter("idMotivo2", motivoStr);
            System.out.println(q.toString());
            try {
                listaDeRecorridos = q.list();
            } catch (Exception e) {
                System.err.println("Error en q.list()");
                e.printStackTrace();
            }
            System.out.println(listaDeRecorridos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeRecorridos;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

}
