package com.ph3.daoimpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.ph3.vo.Usuario;

public class UsuarioDAOImpl {
    private SessionFactory sf;

    public UsuarioDAOImpl(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    // METODO NO UTILIZADO
    public Usuario getDetalleUsuario(Usuario usuario) {
        try {
            sf.getCurrentSession().beginTransaction();
            Query q = sf.getCurrentSession().createQuery("from Usuario where usuarioNombre=:usuario and usuarioClave=:clave");
            q.setParameter("usuario", usuario.getUsuarioNombre());
            q.setParameter("clave", usuario.getUsuarioClave());
            Usuario c = (Usuario) q.uniqueResult();
            return c;
        } catch (RuntimeException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return null;
        } finally {
            sf.getCurrentSession().close();
        }
    }
}
