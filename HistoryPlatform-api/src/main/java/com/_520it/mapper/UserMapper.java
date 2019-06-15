package com._520it.mapper;


import com._520it.pojo.ArticleQuery;
import com._520it.pojo.Count;
import com._520it.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/1.
 */
public interface UserMapper {

    public void save(User user);

    /**
     * 根据用户名称，查询是否存在
     * */
    int getUserByname(String name);
    /**
     * 根据用户信息，查询用户是否存在
     * */
    User getUser(User user);

    /**
     * 更改用户密码
     * */
    void updataPW(@Param("id") String id, @Param("newPW") String newPW);

    /**
     * 获取管理员
     * @param user
     * @return
     */
    User getAdmin(User user);

    /***
     * 统计管理员相关信息
     * @param id
     * @return
     */
    Count countAricles(String id);

    /**
     * 统计用户人数
     * @param user
     * @return
     */
    int countTotal(User user);

    /**
     * 查询所有人
     * @param user
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<ArticleQuery> queryUsers(@Param("user") User user, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     * 删除文章
     * @param id
     */
    void deleteArticle(String id);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 更新用户积分
     * @param id
     * @param score
     */
    void updatescore(@Param("id") String id, @Param("score") long score);

    /**
     * 更新等级
     * @param id
     * @param score
     */
    void updateType(@Param("id") String id, @Param("score") String score);

    /**
     * 更新状态
     * @param id
     */
    void updateStatus(@Param("id") String id,@Param("status") String status);

    /**
     * 更新用户头像
     * @param id
     * @param src
     */
    void updatePicture(@Param("id") String id, @Param("src") String src);
}
