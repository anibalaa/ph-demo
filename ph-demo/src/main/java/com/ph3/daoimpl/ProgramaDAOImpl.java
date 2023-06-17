package com.ph3.daoimpl;

import org.hibernate.SessionFactory;

import com.ph3.dao.ProgramaDAO;
import com.ph3.vo.Programa;

public class ProgramaDAOImpl extends GenericDAOImpl<Programa, Integer> implements ProgramaDAO {

    public ProgramaDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
