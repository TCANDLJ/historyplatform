package com._520it.service;

import com._520it.pojo.ArticleQuery;
import com._520it.pojo.Count;
import com._520it.pojo.User;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/2.
 */
public interface UserService {
    void save(User user);

    int getUserByname(String name);

    User getUser(User user);

    void updataPW(String id,String newPW);

    User getAdmin(User user);

    Count countAricles(String id);

    int countTotal(User user);

    List<ArticleQuery> queryUsers(User user, int startIndex, int endIndex);

    void deleteUserAndArticle(String id);

    void updateScore(String id, long sorce);

    void updateType(String id, String score);

    void updateStatus(String id,String status);

    void updatePicture(String id, String src);
}
