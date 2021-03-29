package com.bailingnan.icommunity.controller;

import com.bailingnan.icommunity.util.CommunityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author bailingnan
 * @date 2021/3/28
 */
@Controller
public class AlphaController {
    @RequestMapping(path="/cookie/set",method= RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response){
        //创建cookie
        Cookie cookie=new Cookie("code", CommunityUtil.generateUUID());
        //设置cookie生效的范围
        cookie.setPath("/icommunity/alpha");
        //设置cookie生效时间
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
        return "set cookie";
    }
    @RequestMapping(path="/cookie/get",method=RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
        return "get cookie";
    }
    @RequestMapping(path="/session/set",method=RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("id",1);
        session.setAttribute("name","Test");
        return "set session";
    }
}
