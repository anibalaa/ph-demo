package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.MotivoDAO;
import com.ph3.vo.Motivo;

public class MotivoDAOImpl extends GenericDAOImpl<Motivo, Integer> implements MotivoDAO {

    public MotivoDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
