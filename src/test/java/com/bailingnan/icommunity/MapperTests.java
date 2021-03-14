package com.bailingnan.icommunity;

import com.bailingnan.icommunity.dao.UserMapper;
import com.bailingnan.icommunity.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.activation.DataSource;

/**
 * @author bailingnan
 * @date 2021/3/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=ICommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectUsers(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }
}
