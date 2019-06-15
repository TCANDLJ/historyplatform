package com._520it.mapper;

import com._520it.pojo.Article;
import com._520it.pojo.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/12.
 */
public interface ArticleMapper {

    /**
     * 保存文章到草稿箱
     */
     void  saveArticle(Article article);

    /**
     * 分页查询
     * @param
     * @param id
     * @return
     */
    List<Article> getArticles(@Param("startIndex") int startIndex,@Param("endIndex") int endIndex,@Param("page") boolean page, @Param("userId") String id,@Param("status") int status);


    /**
     * 统计有多少文章
     * @param id
     * @param status
     * @return
     */
    int countArticles(@Param("userId") String id, @Param("status") int status);

    /**
     * 删除文章
     * @param id
     */
    void deleteArticle(String id);

    /**
     * 上传文章
     * @param id
     */
    void applyArticle(String id);

    /**
     * 跳转编辑页面
     * @param id
     * @return
     */
    Article toEditPage(String id);

    /**
     * 更新文章
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 统计文章
     * @param article
     * @return
     */
    int countTotal(Article article);

    /**
     * 查询文章
     * @param article
     * @param startIndex
     * @param endIndex
     */
    List<Article> queryArticles(@Param("article") Article article, @Param("startIndex") int startIndex,@Param("endIndex") int endIndex);

    /**
     * 查询首页最新文章
     * @return
     */
    List<Article> queryIndexArticles();

    /**
     * 查询其他文章
     * @param id
     * @return
     */
    List<Article> queryOtherArticle(String id);

    /**
     * 查询最新10篇文章
     * @param type
     * @return
     */
    List<Article> queryNews(@Param("type") String type);

    /**
     * 更新文章阅读量
     * @param id
     */
    void updateArticleReadNum(String id);
}
