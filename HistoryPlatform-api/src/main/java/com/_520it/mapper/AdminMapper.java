package com._520it.mapper;

import com._520it.pojo.ArticleDetail;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/14.
 */
public interface AdminMapper {

    List<ArticleQuery> queryArticle(@Param("article") ArticleQuery articleQuery, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    int countTotal(ArticleQuery articleQuery);

    /**
     * 更新文章状态
     * @param id
     * @param status
     * @param adminId
     */
    void updateStatus(@Param("id") String id, @Param("status") String status, @Param("adminId") String adminId);

    /**
     * 文章详细
     * @param id
     * @return
     */
    ArticleDetail getArticleDetail(String id);

    /**
     * 修改管理员信息
     * @param user
     */
    void updateAdmin(User user);
}
