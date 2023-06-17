package com.ph3.tmp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ph3.daoimpl.GenericDAOImpl;
import com.ph3.vo.TratamientoPrograma;

public class ModeloDAOImpl extends GenericDAOImpl<Modelo, Integer> implements ModeloDAO {
    SessionFactory sf;

    public ModeloDAOImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoPrograma> buscarModeloPorBike(String id) {
        System.out.println("id: "+ id);
        org.hibernate.Query consulta = null;
        Session session = null;
        SessionFactory factoria = null;
        try {
            factoria = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            session = factoria.openSession();
            consulta = session.createQuery("FROM TratamientoPrograma tp where tp.tratamiento like :id");
            consulta.setString("id", id);   /// CAMBIAR POR ID
            List<TratamientoPrograma> lista = consulta.list();
            for (TratamientoPrograma p : lista) {
                System.out.println(p.getPrograma().getIdPrograma());
            }
            return lista;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            consulta = null;
            session.close();
            factoria.close();
        }
    }

}
