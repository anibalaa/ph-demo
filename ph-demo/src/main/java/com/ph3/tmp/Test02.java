package com.ph3.tmp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ph3.vo.Programa;

public class Test02 {

    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory factoria = new Configuration().configure().buildSessionFactory();
            session = factoria.openSession();
            Programa programa = (Programa) session.get(Programa.class, 23);
            System.out.println(programa.getDescripcion());
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

}
