package com._520it.controller;

import com._520it.pojo.Article;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.PageResult;
import com._520it.pojo.User;
import com._520it.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/19.
 */
@Controller
@RequestMapping("/admin")
public class AdminArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    /**
     * 保存草稿箱
     */
    @RequestMapping(value = "/saveArticle",method = RequestMethod.POST)
    @ResponseBody
    public String  saveArticle(Article article, HttpServletRequest request){
            User admin = (User) request.getSession().getAttribute("admin");
            article.setUserId(admin.getId());
            article.setStatus("4");
            articleService.saveArticle(article);
            return "ok";
    }
    @RequestMapping(value = "/user/queryArticles",method = RequestMethod.POST)
    public String queryArticles(Article article, Model model){
        PageResult result = new PageResult();
        String startPage = article.getStartPage();
        if(startPage==null || startPage.trim()==""){
            result.setStartPage(1);
        }else {
            result.setStartPage(Integer.parseInt(article.getStartPage()));
        }
        //统计总记录数
        int totalRecords=articleService.countTotal(article);
        if(totalRecords==0){
            result=null;
        }else{
            result.setTotalRecords(totalRecords);
            result.setPageNum(10);
            result.init();
            //查询文章
            List<Article> list = articleService.queryArticles(article,result.getStartIndex(),result.getEndIndex());
            result.setList(list);
        }
        model.addAttribute("result",result);
        model.addAttribute("article",article);
        return "userManage";
    }

    @RequestMapping(value = "/user/removeArticle/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String removeArticle(@PathVariable("id") String id){
        articleService.removeArticle(id);
        return "ok";
    }

}
