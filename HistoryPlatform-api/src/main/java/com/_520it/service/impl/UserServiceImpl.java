package com._520it.service.impl;

import com._520it.mapper.UserMapper;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.Count;
import com._520it.pojo.User;
import com._520it.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 超哥 on 2019/4/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public void save(User user) {
        userMapper.save(user);
    }


    public int getUserByname(String name) {
      return userMapper.getUserByname(name);
    }


    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    public void updataPW(String id,String newPW) {
        userMapper.updataPW(id,newPW);

    }


    public User getAdmin(User user) {
        return userMapper.getAdmin(user);
    }

    public Count countAricles(String id) {
        return userMapper.countAricles(id);
    }

    public int countTotal(User user) {
        return userMapper.countTotal(user);
    }

    public List<ArticleQuery> queryUsers(User user, int startIndex, int endIndex) {
        return userMapper.queryUsers(user,startIndex,endIndex);
    }

    public void deleteUserAndArticle(String id) {
        userMapper.deleteUser(id);
        userMapper.deleteArticle(id);
    }

    public void updateScore(String id, long score) {
        userMapper.updatescore(id,score);
    }

    public void updateType(String id, String score) {
        userMapper.updateType(id, score);
    }

    public void updateStatus(String id,String status) {
        userMapper.updateStatus(id, status);
    }

    public void updatePicture(String id, String src) {
        userMapper.updatePicture(id,src);
    }

}
