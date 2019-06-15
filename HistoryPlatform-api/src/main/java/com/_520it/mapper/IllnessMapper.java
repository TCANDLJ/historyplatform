package com._520it.mapper;

import com._520it.pojo.Illness;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/21.
 */
public interface IllnessMapper {
    /**
     *保存疾病
     * @param illness
     */
    void saveIllness(Illness illness);

    /**
     *编辑疾病
     * @param id
     * @return
     */
    Illness editIllness(String id);

    /**
     *删除疾病
     * @param id
     */
    void removeIllness(String id);

    /**
     *查询疾病
     * @param illness
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<Illness> queryIllness(@Param("illness") Illness illness, @Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    /**
     *统计疾病
     * @param illness
     * @return
     */
    int countTotal(Illness illness);

    /**
     *更新疾病
     * @param illness
     */
    void updateIllness(Illness illness);

    /**
     * 查询疾病详细信息
     * @param illness
     * @return
     */
    List<Illness> queryUserIllness(Illness illness);
}
