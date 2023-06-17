package com.ph3.tmp;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ph3.vo.Programa;

public class Test03 {
    public static void main(String[] args) {
        Query consulta = null;
        Session session = null;
        SessionFactory factoria = null;
        try {
            factoria = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            session = factoria.openSession();
            consulta = session.createQuery(" from Programa programa where programa.descripcion=:categoria");
            consulta.setString("categoria", "PG. acogida Gijon");
            @SuppressWarnings("unchecked")
            List<Programa> lista = consulta.list();
            for (Programa p : lista) {
                System.out.println(p.getDescripcion());
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
