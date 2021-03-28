package com.bailingnan.icommunity.controller;

import com.bailingnan.icommunity.entity.User;
import com.bailingnan.icommunity.service.UserService;
import com.bailingnan.icommunity.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author bailingnan
 * @date 2021/3/26
 */
@Controller
public class LoginController implements CommunityConstant {
    @Autowired
    private UserService userService;

    @RequestMapping(path="/register",method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }

    @RequestMapping(path="/register",method=RequestMethod.POST)
    public String register(Model model, User user){
        Map<String,Object> map = userService.register(user);
        if(map==null||map.isEmpty()){
            model.addAttribute("msg","注册成功，我们已经向您的邮箱发送了一封激活邮件，请尽快激活！");
            model.addAttribute("target","/index");
            return "/site/operate-result";
        }else{
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            model.addAttribute("emailMsg",map.get("emailMsg"));
            return "/site/register";
        }
    }
    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String getLoginPage() {return "site/login";}
    //http://localhost:8080/icommunity/activation/101/code
    @RequestMapping(path="/activation/{userId}/{code}",method=RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId,@PathVariable("code") String code){
        int result=userService.activation(userId,code);
        if(result==ACTIVATION_SUCCESS){
            model.addAttribute("msg","激活成功，您的账号可以正常使用了！");
            model.addAttribute("target","/login");
        }else if(result==ACTIVATION_REPEAT){
            model.addAttribute("msg","操作无效，该账号已被激活过！");
            model.addAttribute("target","/index");
        }else{
            model.addAttribute("msg","激活失败，您提供的激活码不正确！");
            model.addAttribute("target","/index");
        }
        return "/sites/operate-result";
    }
}
