package com._520it.controller;

import com._520it.pojo.Count;
import com._520it.pojo.User;
import com._520it.service.impl.UserServiceImpl;
import com._520it.utils.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by 超哥 on 2019/4/13.
 */
@Controller
public class IndexController {

    @Autowired
    private UserServiceImpl userService;

   @RequestMapping("/{pageHtml}")
    public String  index(@PathVariable("pageHtml") String pageHtml){
       return  pageHtml;
    }

    @RequestMapping("/")
    public String  login(){
        return  "login";
    }


    @RequestMapping(value = "/index/regist",method = RequestMethod.POST)
    public String  register(User user, HttpServletRequest request) throws Exception {
            int count= userService.getUserByname(user.getName());
            if(count!=0){
                request.setAttribute("msg","用户名已存在！！！");
                return "resgist";
            }
            user.setPassword(MyMD5.md5(user.getPassword()));
            user.setScore("0");
            user.setType("4");//管理员
            user.setPictureSrc("/img/admin/1.jpg");
            userService.save(user);
            return "login";
    }

    @RequestMapping(value = "/index/login",method = RequestMethod.POST)
    public String  login(User user,HttpServletRequest request) throws Exception {
           user.setPassword(MyMD5.md5(user.getPassword()));
           User admin= userService.getAdmin(user);
            if(admin==null){
                request.setAttribute("msg","用户名或密码输入错误！！！");
                return "login";
            }
        admin.setStatus("1");
        request.getSession().setAttribute("admin",admin);
        Count count=userService.countAricles(admin.getId());
        request.getSession().setAttribute("count",count);
        return "index";
    }
    @RequestMapping(value = "/index/loginout")
    public String  loginout(HttpServletRequest request){
        request.getSession().setAttribute("admin",null);
        return "login";
    }

    @RequestMapping(value = "/index/updatePW",method = RequestMethod.POST)
    public String  updatePW(String newPW,HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("admin");
        userService.updataPW(user.getId(), MyMD5.md5(newPW));
        return "login";
    }



}
