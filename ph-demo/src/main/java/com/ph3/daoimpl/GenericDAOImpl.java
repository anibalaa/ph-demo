package com.ph3.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.ph3.util.GenericDAO;

public abstract class GenericDAOImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

    SessionFactory sf;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl(SessionFactory sf) {
        this.sf = sf;
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private Class<T> claseDePersistencia;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public T buscarPorClave(Id id) {

        // en el método modificar, cuando intento modificar dos veces seguidas el mismo registro
        // la segunda vez lo coge de la cache y no de la base de datos
        // por tanto al mostrarlo en pantalla parece que no ha hecho la modificación
        // pero en base de datos si está hecha.
        // Depurando veo que el objeto recuperado es null, porque lo coge de la cache !!!!
        // pendiente de desactivar la cache

        // OJO: ES MUY IMPORTANTE HACER EL COMMIT DESPUES DE LAS CONSULTAS
        // Y LAS SIGUIENTES PROPIEDADES DEL HIBERNATE.CFG.XML

        // <!-- ACTIVAR EL CONTROL AUTOMÁTICO DE SESSION CONTEXT -->
        // <property name="hibernate.current_session_context_class">thread</property>
        // <property name="hibernate.jdbc.use_get_generated_keys">true</property>
        // <property name="hibernate.enable_lazy_load_no_trans">true</property>

        T objeto = null;
        try {
            sf.getCurrentSession().beginTransaction();
            objeto = (T) sf.getCurrentSession().load(claseDePersistencia, id);
            //System.out.println(objeto);
            System.out.println("***ENCONTRADO POR ID***");
            sf.getCurrentSession().getTransaction().commit();
            return objeto;
        } catch (RuntimeException e) {
            System.err.println("Error buscando por ID ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> buscarTodos() {
        List<T> listaDeObjetos = null;
        try {
            sf.getCurrentSession().beginTransaction();
            Query consulta = sf.getCurrentSession().createQuery("select o from " + claseDePersistencia.getSimpleName() + " o");
            listaDeObjetos = consulta.list();
            System.out.println(listaDeObjetos);
            sf.getCurrentSession().getTransaction().commit();
            return listaDeObjetos;
        } catch (RuntimeException e) {
            System.err.println("Error buscando todos ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }

    }

    public void salvar(T objeto) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().merge(objeto);
            // en mi método tengo que insertar en las tablas relacionadas
            // tcd.insertTitCta(new TitularesCuentas(cuenta, titular, new
            // Date()));
            System.out.println(objeto);
            System.out.println("***SALVADO***");
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("error al salvar ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }

    public void borrar(T objeto) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(sf.getCurrentSession().merge(objeto));
            // en mi método tengo que insertar en las tablas relacionadas
            // tcd.insertTitCta(new TitularesCuentas(cuenta, titular, new
            // Date()));
            System.out.println(objeto);
            System.out.println("***BORRADO***");
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("error al borrar ");
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }

    }

    public void insertar(T objeto) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(objeto);
            // en mi método tengo que insertar en las tablas relacionadas
            // tcd.insertTitCta(new TitularesCuentas(cuenta, titular, new
            // Date()));
            System.out.println(objeto);
            System.out.println("***INSERTADO***");
            sf.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException e) {
            System.err.println("error al insertar " + e.getCause() + objeto);
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
        } finally {
            sf.getCurrentSession().close();
        }
    }
}
