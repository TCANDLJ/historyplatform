package com._520it.service.impl;

import com._520it.mapper.IllnessMapper;
import com._520it.pojo.History;
import com._520it.pojo.Illness;
import com._520it.service.IllnessServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 超哥 on 2019/4/21.
 */
@Service
public class IllnessServerImpl  implements IllnessServer{

    @Autowired
    private IllnessMapper illnessMapper;

    public void saveIllness(Illness illness) {
       illnessMapper.saveIllness(illness);
    }

    public void updateIllness(Illness illness) {
        illnessMapper.updateIllness(illness);
    }

    public int countTotal(Illness illness) {
        return illnessMapper.countTotal(illness);
    }

    public List<Illness> queryIllness(Illness illness, int startIndex, int endIndex) {
        return illnessMapper.queryIllness(illness,  startIndex,  endIndex);
    }

    public void removeIllness(String id) {
       illnessMapper.removeIllness(id);
    }

    public Illness editIllness(String id) {
        return illnessMapper.editIllness(id);
    }

    public  List<Illness> queryIllness(Illness illness) {
        return illnessMapper.queryUserIllness(illness);
    }
}
