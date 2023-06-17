package com.ph3.tmp;

// test01 muestra por consola el listado de programas en la base de datos
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ph3.vo.Programa;

public class Test01 {

    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory factoria = new Configuration().configure().buildSessionFactory();
            session = factoria.openSession();
            Query consulta = session.createQuery("from Programa programa");
            @SuppressWarnings("unchecked")
            List<Programa> lista = consulta.list();
            for (Programa p : lista) {
                System.out.println(p.getIdPrograma() + " - " + p.getDescripcion());
                System.out.println();
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

}
