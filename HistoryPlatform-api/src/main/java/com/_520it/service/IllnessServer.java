package com._520it.service;

import com._520it.pojo.History;
import com._520it.pojo.Illness;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/21.
 */
public interface IllnessServer {
    void saveIllness(Illness illness);

    void updateIllness(Illness illness);

    int countTotal(Illness illness);

    List<Illness> queryIllness(Illness illness, int startIndex, int endIndex);

    void removeIllness(String id);

    Illness editIllness(String id);

    List<Illness> queryIllness(Illness illness);
}
