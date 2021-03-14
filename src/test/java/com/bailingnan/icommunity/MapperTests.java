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
import java.util.Date;

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
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInserUsers(){
        User user = new User();
        user.setUserName("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows =userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateUsers(){
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows=userMapper.updatePassword(150,"hello");
        System.out.println(rows);
    }
}
