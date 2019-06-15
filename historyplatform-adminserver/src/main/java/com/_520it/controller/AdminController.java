package com._520it.controller;

import com._520it.pojo.*;
import com._520it.service.AdminServer;
import com._520it.utils.MyMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/14.
 */
@Controller
@RequestMapping("/admin/index")
public class AdminController {

    @Autowired
    private AdminServer adminServer;


    @RequestMapping(value = "/queryArticles",method = RequestMethod.POST)
    public String queryArticles(ArticleQuery articleQuery, Model model){
        PageResult result = new PageResult();
        String startPage = articleQuery.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(articleQuery.getStartPage()));
        }
        //统计总记录数
        int totalRecords=adminServer.countTotal(articleQuery);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询文章
            List<ArticleQuery> list = adminServer.queryArticle(articleQuery,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("articleQuery",articleQuery);
         return "index";
    }

    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    @ResponseBody
    public String updateStatus(String id, String status, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("admin");
        adminServer.updateStatus(id,status,user.getId());
        Count count= (Count) request.getSession().getAttribute("count");
        count.setCount1((Integer.parseInt(count.getCount1())-1)+"");
        count.setCount2((Integer.parseInt(count.getCount2())+1)+"");
        if(status.equals("3")){
            count.setCount4((Integer.parseInt(count.getCount4())+1)+"");
        }else{
            count.setCount3((Integer.parseInt(count.getCount3())+1)+"");
        }
        return "ok";
    }
    @RequestMapping(value = "/articleDetail/{id}")
    public String articleDetail(@PathVariable("id") String id, Model model){
        ArticleDetail articleDetail=adminServer.getArticleDetail(id);
        model.addAttribute("articleDetail",articleDetail);
        return "news_detail";
    }

    @RequestMapping(value = "/updateAdmin")
    public String updateAdmin(User user,HttpServletRequest request) throws Exception {
        User user1 = (User) request.getSession().getAttribute("admin");
        user.setId(user1.getId());
        String viewString="personCenter";
        if(user.getPassword()!=null){
            user.setPassword(MyMD5.md5(user.getPassword()));
            viewString="login";
        }
        adminServer.updateAdmin(user);
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());
        request.getSession().setAttribute("admin",user1);

       return viewString;
    }




}
