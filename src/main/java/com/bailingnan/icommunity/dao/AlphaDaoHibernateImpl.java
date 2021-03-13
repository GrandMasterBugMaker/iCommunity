package com.bailingnan.icommunity.dao;

import org.springframework.stereotype.Repository;

/**
 * @author bailingnan
 * @date 2021/3/11
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select(){
        return "Hibernate";
    }

}
