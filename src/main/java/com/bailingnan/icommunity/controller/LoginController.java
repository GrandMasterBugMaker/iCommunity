package com.bailingnan.icommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bailingnan
 * @date 2021/3/26
 */
@Controller
public class LoginController {
    @RequestMapping(path="/register",method = RequestMethod.GET)
    public String getRegisterPage() {
        return "/site/register";
    }
}
