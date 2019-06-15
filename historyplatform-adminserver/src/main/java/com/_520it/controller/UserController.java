package com._520it.controller;

import com._520it.pojo.ArticleQuery;
import com._520it.pojo.PageResult;
import com._520it.pojo.User;
import com._520it.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/19.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/queryUsers",method = RequestMethod.POST)
    public String queryUsers(User user, Model model){
        PageResult result = new PageResult();
        String startPage = user.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(user.getStartPage()));
        }
        //统计总记录数
        int totalRecords=userService.countTotal(user);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询文章
            List<ArticleQuery> list = userService.queryUsers(user,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("user",user);
        return "userCenter";
    }

    @RequestMapping(value = "/removeUser/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String removeUser(@PathVariable("id") String id){
       userService.deleteUserAndArticle(id);
       return "ok";
    }
}
