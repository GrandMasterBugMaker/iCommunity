package com.bailingnan.icommunity.service;

import com.bailingnan.icommunity.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bailingnan
 * @date 2021/3/14
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

}