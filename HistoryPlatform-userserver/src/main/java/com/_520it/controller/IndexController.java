package com._520it.controller;

import com._520it.pojo.Article;
import com._520it.pojo.User;
import com._520it.service.impl.ArticleServiceImpl;
import com._520it.utils.MyMD5;
import com._520it.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 超哥 on 2019/3/31.
 */
@Controller
public class IndexController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping("/")
    public String  index(Model model){
        List<Article> list = articleService.queryIndexArticles();
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String  register(User user,HttpServletRequest request){
        try {
            int count= userService.getUserByname(user.getName());
            if(count!=0){
                request.setAttribute("msg","用户名已存在！！！");
                return "resgist";
            }
            user.setPassword(MyMD5.md5(user.getPassword()));
            user.setScore("0");
            user.setType("1");//普通会员
            user.setPictureSrc("/img/head/3.jpeg");
            userService.save(user);
        }catch (Exception e){
            request.setAttribute("msg","注册失败");
            return "resgist";
        }
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String  login(User user, HttpServletRequest request) throws IOException {
        User user2=null;
        try {
            user.setPassword(MyMD5.md5(user.getPassword()));
            user2= userService.getUser(user);
            if(user2==null){
                request.setAttribute("msg","用户名或密码输入错误！！！");
                return "login";
            }
        }catch (Exception e){
            request.setAttribute("msg","登录失败");
            return "login";
        }
        user2.setStatus("1");
        Integer sorce= Integer.parseInt(user2.getScore());
        //会员升级
        if(sorce >500 && sorce<1000 ){
            userService.updateType(user2.getId(),user2.getScore());
            user2.setType("2");
        }else  if(sorce >=1000){
            userService.updateType(user2.getId(),user2.getScore());
            user2.setType("3");
        }
        //更新用户状态
        userService.updateStatus(user2.getId(),"1");
        //记录登录开始时间
        long startTime = System.currentTimeMillis();
        user2.setStartTime(startTime+"");
        request.getSession().setAttribute("user",user2);
        return "redirect:/";
    }
    @RequestMapping(value = "/loginout")
    public String  loginout(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        //计算登录时间
        long endTime = System.currentTimeMillis();
        long startTime =Long.parseLong(user.getStartTime());
        long score=(endTime-startTime)/1000;
        score=score/3600;
        //更新用户积分
        userService.updateScore(user.getId(),score);
        //更新用户状态
        userService.updateStatus(user.getId(),"2");
        request.getSession().setAttribute("user",null);
        return "redirect:/";
    }
    @RequestMapping(value = "/updatePW",method = RequestMethod.POST)
    public String  updatePW(String newPW,HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        userService.updataPW(user.getId(), MyMD5.md5(newPW));
        return "login";
    }


}
