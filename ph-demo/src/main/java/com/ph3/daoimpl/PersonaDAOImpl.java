package com.ph3.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.ph3.dao.PersonaDAO;
import com.ph3.vo.Persona;

public class PersonaDAOImpl extends GenericDAOImpl<Persona, Integer> implements PersonaDAO {

    public PersonaDAOImpl(SessionFactory sf) {
        super(sf);
    }

    @SuppressWarnings("unchecked")
    public List<Persona> buscarApellidosPorNombre(String str) {
        List<Persona> listaDePersonas = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery("from Persona where nombre=:str");
            q.setParameter("str", str);
            listaDePersonas = q.list();
            sf.getCurrentSession().getTransaction().commit();
            return listaDePersonas;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public Persona buscarNombreApellido1Apellido2(String nombre, String apellido1, String apellido2) {
        Persona persona = null;
        //String qstr = "select p.nombre, p.apellido1, p.apellido2 from Persona as p where p.nombre =:nombre and p.apellido1 =:apellido1 and p.apellido2 =:apellido2";
        String qstr2 = "from Persona as p where p.nombre =:nombre and p.apellido1 =:apellido1 and p.apellido2 =:apellido2";
        try {
            sf.getCurrentSession().beginTransaction();
            Query consulta = sf.getCurrentSession().createQuery(qstr2);
            // SQLQuery consulta = sf.getCurrentSession().createSQLQuery(qstr);
            // consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            consulta.setParameter("nombre", nombre);
            consulta.setParameter("apellido1", apellido1);
            consulta.setParameter("apellido2", apellido2);
            persona = (Persona) consulta.uniqueResult();
            sf.getCurrentSession().getTransaction().commit();
            return persona;
        } catch (RuntimeException e) {
            System.err.println("Error buscando P.E. ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

}
