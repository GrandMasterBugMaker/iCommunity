package com.bailingnan.icommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bailingnan
 * @date 2021/3/11
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello,world!";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }

        System.out.println(request.getParameter("code"));
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer=response.getWriter();) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(path="/students",method= RequestMethod.GET)
    @ResponseBody
    public String getStudentString(@RequestParam(name="current",required=false,defaultValue ="1")int current, @RequestParam(name="limit",required=false,defaultValue ="10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    @RequestMapping(path="/student/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }
    @RequestMapping(path="/student",method=RequestMethod.POST)
    @ResponseBody
    public String saveStudentString(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path="/teacher",method=RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","zhangsan");
        mav.addObject("age","30");
        mav.setViewName("/demo/view");
        return mav;
    }
    @RequestMapping(path="/school",method=RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    @RequestMapping(path="/emp",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age",23);
        emp.put("salary",8000.00);
        return emp;
    }
}
