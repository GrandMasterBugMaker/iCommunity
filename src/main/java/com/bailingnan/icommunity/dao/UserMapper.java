package com.bailingnan.icommunity.dao;

import com.bailingnan.icommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author bailingnan
 * @date 2021/3/13
 */
@Mapper
public interface UserMapper {
    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);


}
