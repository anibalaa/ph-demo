package com.ph3.daoimpl;


import org.hibernate.SessionFactory;
import com.ph3.dao.TratamientoDAO;
import com.ph3.vo.Tratamiento;

public class TratamientoDAOImpl extends GenericDAOImpl<Tratamiento, Integer> implements TratamientoDAO {

    
    public TratamientoDAOImpl(SessionFactory sf) {
        super(sf);
    }

}
