package com._520it.service;

import com._520it.pojo.ArticleDetail;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.User;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/14.
 */
public interface AdminServer {

    List<ArticleQuery> queryArticle(ArticleQuery articleQuery, int startIndex, int endIndex);

    int countTotal(ArticleQuery articleQuery);

    void updateStatus(String id, String status, String id1);

    ArticleDetail getArticleDetail(String id);

    void updateAdmin(User user);
}
