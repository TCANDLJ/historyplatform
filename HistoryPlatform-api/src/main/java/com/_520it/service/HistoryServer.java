package com._520it.service;

import com._520it.pojo.ArticleQuery;
import com._520it.pojo.History;
import com._520it.pojo.KindsUser;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/20.
 */
public interface HistoryServer {
    void saveHistory(History history);

    int countTotal(History history);

    List<History> queryHistorys(History history, int startIndex, int endIndex);

    void removeHistory(String id);

    History editHistory(String id);

    void updateHistory(History history);

    History queryHistory(History history);

    int countUserTotal(History history);

    List<KindsUser> queryKinds(History history, int startIndex, int endIndex);
}
