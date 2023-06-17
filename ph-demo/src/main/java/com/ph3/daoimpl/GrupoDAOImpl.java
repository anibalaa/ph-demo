package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.GrupoDAO;
import com.ph3.vo.Grupo;

public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Integer> implements GrupoDAO {

    public GrupoDAOImpl(SessionFactory sf) {
        super(sf);
    }
}
