package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.FaseDAO;
import com.ph3.vo.Fase;

public class FaseDAOImpl extends GenericDAOImpl<Fase, Integer> implements FaseDAO {

    public FaseDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
