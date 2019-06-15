package com._520it.service.impl;

import com._520it.mapper.AdminMapper;
import com._520it.pojo.ArticleDetail;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.User;
import com._520it.service.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/14.
 */
@Service
public class AdminServerImpl implements AdminServer {

    @Autowired
    private AdminMapper adminMapper;

    public List<ArticleQuery> queryArticle(ArticleQuery articleQuery, int startIndex, int endIndex) {
        return adminMapper.queryArticle(articleQuery,startIndex,endIndex);
    }

    public int countTotal(ArticleQuery articleQuery) {

        return adminMapper.countTotal(articleQuery);
    }

    public void updateStatus(String id, String status, String adminId) {
        adminMapper.updateStatus(id,status,adminId);
    }

    public ArticleDetail getArticleDetail(String id) {
        return adminMapper.getArticleDetail(id);
    }

    public void updateAdmin(User user) {
        adminMapper.updateAdmin(user);
    }
}
