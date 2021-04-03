package com.bailingnan.icommunity.dao;

import com.bailingnan.icommunity.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @author bailingnan
 * @date 2021/3/29
 */
@Mapper
@Deprecated
public interface LoginTicketMapper {
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired}) ",

    })
    @Options(useGeneratedKeys = true,keyProperty ="id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket ",
            "where ticket=#{ticket} "
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "update login_ticket ",
            "set status=#{status} ",
            "where ticket=#{ticket} "
    })
    int updateStatus(String ticket,int status);


}
