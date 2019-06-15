package com._520it.service;

import com._520it.pojo.Article;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.PageResult;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/12.
 */
public interface ArticleService {


     void  saveArticle(Article article);

    PageResult getArticles(int startPage, String id,int status);

    void deleteArticle(String id);

    void applyArticle(String id);

    Article toEditPage(String id);

    void updateArticle(Article article);

    int countTotal(Article article);

    List<Article> queryArticles(Article article, int startIndex, int endIndex);

    void removeArticle(String id);

    List<Article> queryIndexArticles();

    List<Article> queryOtherArticle(String id);

    List<Article> queryNews(String type);

    void updateArticleReadNum(String id);
}
