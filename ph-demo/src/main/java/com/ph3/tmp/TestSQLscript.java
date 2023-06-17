package com.ph3.tmp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ph3.vo.TratamientoPrograma;

public class TestSQLscript {

    public static void main(String[] args) {
        org.hibernate.Query consulta = null;
        Session session = null;
        SessionFactory factoria = null;
        try {
            factoria = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            session = factoria.openSession();
            consulta = session.createQuery("FROM TratamientoPrograma tp where tp.tratamiento like :id");
            consulta.setString("id", "10");
            @SuppressWarnings("unchecked")
            List<TratamientoPrograma> lista = consulta.list();
            for (TratamientoPrograma p : lista) {
                System.out.println(p.getPrograma().getIdPrograma());
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            consulta = null;
            session.close();
            factoria.close();
        }
    }
}

