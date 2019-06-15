package com._520it.service.impl;

import com._520it.mapper.ArticleMapper;
import com._520it.pojo.Article;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.PageResult;
import com._520it.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/12.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public void saveArticle(Article article) {
         articleMapper.saveArticle(article);
    }

    public PageResult getArticles(int startPage, String id,int status) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(4);
        pageResult.setStartPage(startPage);
        pageResult.init();
        int totalRecords=articleMapper.countArticles(id,status);
        if(totalRecords!=0){
            List<Article> articles=articleMapper.getArticles(pageResult.getStartIndex(),pageResult.getEndIndex(),pageResult.isPage(),id,status);
            pageResult.setList(articles);
            pageResult.setTotalRecords(totalRecords);
        }else {
            pageResult.setList(null);
        }
        return pageResult;
    }

    public void deleteArticle(String id) {
        articleMapper.deleteArticle(id);
    }

    public void applyArticle(String id) {
        articleMapper.applyArticle(id);
    }

    public Article toEditPage(String id) {
        return articleMapper.toEditPage(id);
    }

    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    public int countTotal(Article article) {
        return articleMapper.countTotal(article);
    }

    public List<Article> queryArticles(Article article, int startIndex, int endIndex) {
       return     articleMapper.queryArticles(article,startIndex,endIndex);
    }

    public void removeArticle(String id) {
        articleMapper.deleteArticle(id);
    }

    public List<Article> queryIndexArticles() {
        return articleMapper.queryIndexArticles();
    }

    public List<Article> queryOtherArticle(String id) {
        return articleMapper.queryOtherArticle(id);
    }

    public List<Article> queryNews(String type) {
        return articleMapper.queryNews(type);
    }

    public void updateArticleReadNum(String id) {
        articleMapper.updateArticleReadNum(id);
    }
}
