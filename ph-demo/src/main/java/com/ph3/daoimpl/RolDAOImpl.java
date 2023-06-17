package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.RolDAO;
import com.ph3.vo.Rol;

public class RolDAOImpl extends GenericDAOImpl<Rol, Integer> implements RolDAO {

    public RolDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
