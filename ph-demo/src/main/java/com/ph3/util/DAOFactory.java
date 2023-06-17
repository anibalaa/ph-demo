package com.ph3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ph3.dao.AgrupacionDAO;
import com.ph3.dao.FaseDAO;
import com.ph3.dao.FaseGrupoDAO;
import com.ph3.dao.GrupoDAO;
import com.ph3.dao.MotivoDAO;
import com.ph3.dao.PersonaDAO;
import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.dao.RecorridoDAO;
import com.ph3.dao.RolDAO;
import com.ph3.dao.TratamientoDAO;
import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.daoimpl.AgrupacionDAOImpl;
import com.ph3.daoimpl.FaseDAOImpl;
import com.ph3.daoimpl.FaseGrupoDAOImpl;
import com.ph3.daoimpl.GrupoDAOImpl;
import com.ph3.daoimpl.MotivoDAOImpl;
import com.ph3.daoimpl.PersonaDAOImpl;
import com.ph3.daoimpl.ProgramaDAOImpl;
import com.ph3.daoimpl.ProgramaFaseDAOImpl;
import com.ph3.daoimpl.RecorridoDAOImpl;
import com.ph3.daoimpl.RolDAOImpl;
import com.ph3.daoimpl.TratamientoDAOImpl;
import com.ph3.daoimpl.TratamientoProgramaDAOImpl;
import com.ph3.daoimpl.UsuarioDAOImpl;
import com.ph3.tmp.ModeloDAO;
import com.ph3.tmp.ModeloDAOImpl;

public class DAOFactory {
    private static SessionFactory sf;

    public DAOFactory() {
        try {
            // Crea la SessionFactory a partir de la información contenida en hibernate.cfg.xml
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {

            System.err.println("\nError al crear la factoría: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // USUARIO PROBABLEMENTE HAY QUE MODIFICARLO
    public UsuarioDAOImpl getUsuarioDAO() {
        return new UsuarioDAOImpl(sf);
    }

    public static MotivoDAO getMotivoDAO() {
        return new MotivoDAOImpl(sf);
    }

    public static PersonaDAO getPersonaDAO() {
        return new PersonaDAOImpl(sf);
    }

    public static RecorridoDAO getRecorridoDAO() {
        return new RecorridoDAOImpl(sf);
    }

    public static TratamientoDAO getTratamientoDAO() {
        return new TratamientoDAOImpl(sf);
    }

    public static ProgramaDAO getProgramaDAO() {
        return new ProgramaDAOImpl(sf);
    }

    public static FaseDAO getFaseDAO() {
        return new FaseDAOImpl(sf);
    }

    public static GrupoDAO getGrupoDAO() {
        return new GrupoDAOImpl(sf);
    }

    public static RolDAO getRolDAO() {
        return new RolDAOImpl(sf);
    }

    // AQUI IRIA EL USUARIO MODIFICADO

    // NUEVO
    public static AgrupacionDAO getAgrupacionDAO() {
        return new AgrupacionDAOImpl(sf);
    }

    public static TratamientoProgramaDAO getTratamientoProgramaDAO() {
        return new TratamientoProgramaDAOImpl(sf);
    }

    public static ProgramaFaseDAO getProgramaFaseDAO() {
        return new ProgramaFaseDAOImpl(sf);
    }

    public static FaseGrupoDAO getFaseGrupoDAO() {
        return new FaseGrupoDAOImpl(sf);
    }

    public static ModeloDAO getModeloDAO() {
        return new ModeloDAOImpl(sf);
    }
}
