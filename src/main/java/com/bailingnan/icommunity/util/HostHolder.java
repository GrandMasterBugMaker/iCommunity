package com.bailingnan.icommunity.util;

import com.bailingnan.icommunity.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息，用于代替session对象
 * @author bailingnan
 * @date 2021/3/30
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users=new ThreadLocal<>();
    public void setUser(User user){
        users.set(user);
    }
    public User getUserById(){
        return users.get();
    }
    public void clear(){
        users.remove();
    }
}
