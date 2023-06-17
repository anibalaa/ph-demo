package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.AgrupacionDAO;
import com.ph3.vo.Agrupacion;

public class AgrupacionDAOImpl extends GenericDAOImpl<Agrupacion, Integer> implements AgrupacionDAO {

    public AgrupacionDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
