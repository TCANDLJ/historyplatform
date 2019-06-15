package com._520it.mapper;

import com._520it.pojo.History;
import com._520it.pojo.KindsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/20.
 */

public interface HistoryMapper {

    /**
     * 保存医院信息
     * @param history
     */
    void saveHistory(History history);

    /**
     * 获取医院信息
     * @param history
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<History> queryHistorys(@Param("history") History history, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     * 统计总记录数
     * @param history
     * @return
     */
    int countTotal(History history);

    /**
     * 删除医院信息
     * @param id
     */
    void removeHistory(String id);

    /**
     * 查询医院
     * @param id
     * @return
     */
    History editHistory(String id);

    /**
     * 更新医院信息
     * @param history
     */
    void updateHistory(History history);

    /**
     * 查询医院
     * @param history
     * @return
     */
    History queryHistory(History history);

    /**
     * 统计科室
     * @param history
     * @return
     */
    int countUserTotal(History history);

    /**
     * 查询科室
     * @param history
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<KindsUser> queryKinds(@Param("history") History history,  @Param("startIndex") int startIndex, @Param("endIndex")int endIndex);
}
