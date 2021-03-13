package com.bailingnan.icommunity.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author bailingnan
 * @date 2021/3/11
 */
@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select(){
        return "Mybatis";
    }
}
