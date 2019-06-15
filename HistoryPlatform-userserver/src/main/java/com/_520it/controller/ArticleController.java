package com._520it.controller;

import com._520it.pojo.Article;
import com._520it.pojo.ArticleDetail;
import com._520it.pojo.PageResult;
import com._520it.pojo.User;
import com._520it.service.impl.AdminServerImpl;
import com._520it.service.impl.ArticleServiceImpl;
import com._520it.service.impl.UserServiceImpl;
import com._520it.utils.PictureUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 超哥 on 2019/4/12.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private AdminServerImpl adminServer;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 保存草稿箱
     */
    @RequestMapping(value = "/saveArticle",method = RequestMethod.POST)
    @ResponseBody
    public String  saveArticle(Article article,HttpServletRequest request){

        if(article.getId()==null || article.getId().trim()==""){
            User user = (User) request.getSession().getAttribute("user");
            article.setUserId(user.getId());
            article.setStatus("1");
            articleService.saveArticle(article);
        }else {
            articleService.updateArticle(article);
        }

        return "ok";
    }

    /**
     * 获取文章
     */
    @RequestMapping(value = "/getArticles",method = RequestMethod.POST)
    @ResponseBody
    public PageResult getArticles(@RequestParam(value = "startPage",defaultValue = "1") int startPage,int status,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        PageResult pageResult=articleService.getArticles(startPage,user.getId(),status);
        return pageResult;
    }

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.GET)
    @ResponseBody
    public String deleteArticle(String id){

        articleService.deleteArticle(id);

        return "ok";
    }

    /**
     * 上传文章
     * @param id
     * @return
     */
    @RequestMapping(value = "/applyArticle",method = RequestMethod.GET)
    @ResponseBody
    public String applyArticle(String id){
        articleService.applyArticle(id);
        return "ok";
    }

    /**
     * 跳转编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/toEditPage",method = RequestMethod.GET)
    @ResponseBody
    public Article toEditPage(String id){
        Article article=articleService.toEditPage(id);
        return article;
    }

    @RequestMapping("/queryDetail/{id}")
    public String queryDetail(@PathVariable("id") String id, Model model){
        //文章详情
        ArticleDetail articleDetail = adminServer.getArticleDetail(id);
        //查询其他作品
        List<Article> list=articleService.queryOtherArticle(id);
        articleDetail.setList(list);
        model.addAttribute("articleDetail",articleDetail);
        //更新文章阅读量
        articleService.updateArticleReadNum(id);
        return "news_detail";
    }
    @RequestMapping("/queryNews/{type}")
    public String queryNews(@PathVariable(value = "type") String type, Model model){
        List<Article> list = articleService.queryNews(type);
        model.addAttribute("result",list);
        model.addAttribute("type",type);
        return "news";
    }

    @RequestMapping("/person")
    public String person(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            return "login";
        }
        return "person";
    }

    @RequestMapping("/uploadPicture")
    @ResponseBody
    public Map uploadPicture(MultipartFile file, HttpServletRequest request) throws IOException {
        User user= (User) request.getSession().getAttribute("user");
        String src = PictureUtils.uploadPicture(file, "5", request);
        //更新用户头像
        userService.updatePicture(user.getId(),src);
        user.setPictureSrc(src);
        request.getSession().setAttribute("user",user);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }
}
