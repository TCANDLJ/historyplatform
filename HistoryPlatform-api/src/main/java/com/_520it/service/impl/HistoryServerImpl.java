package com._520it.service.impl;

import com._520it.mapper.HistoryMapper;
import com._520it.pojo.ArticleQuery;
import com._520it.pojo.History;
import com._520it.pojo.KindsUser;
import com._520it.service.HistoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/20.
 */
@Service
public class HistoryServerImpl implements HistoryServer {

    @Autowired
    private HistoryMapper  historyMapper;
    public void saveHistory(History history) {
     historyMapper.saveHistory(history);
    }

    public int countTotal(History history) {
        return historyMapper.countTotal(history);
    }

    public List<History> queryHistorys(History history, int startIndex, int endIndex) {
        return historyMapper.queryHistorys(history,  startIndex, endIndex);
    }

    public void removeHistory(String id) {
        historyMapper.removeHistory(id);
    }

    public History editHistory(String id) {
        return historyMapper.editHistory(id);
    }

    public void updateHistory(History history) {
        historyMapper.updateHistory(history);
    }

    public History queryHistory(History history) {
        return historyMapper.queryHistory(history);
    }

    public int countUserTotal(History history) {
        return historyMapper.countUserTotal(history);
    }

    public List<KindsUser> queryKinds(History history, int startIndex, int endIndex) {
        return historyMapper.queryKinds(history,  startIndex,  endIndex);
    }
}
